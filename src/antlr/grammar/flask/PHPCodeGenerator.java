package antlr.grammar.flask;

import FlaskStatement.*;
import java.util.*;

public class PHPCodeGenerator {

    private final StringBuilder phpCode = new StringBuilder();
    private int indentLevel = 0;

    private void emitIndent() {
        phpCode.append("    ".repeat(indentLevel));
    }

    private void emitLine(String text) {
        emitIndent();
        phpCode.append(text).append("\n");
    }

    public String generate(List<Statement> ast) {
        phpCode.append("<?php\n\n");

        // Inject expanded mock Flask ecosystem classes and functions into generated runtime memory
        phpCode.append("""
        // --- FLASK CORE RUNTIME EMULATION LAYER ---
        class FlaskRequest {
            public $method;
            public $form;
            public function __construct() {
                $this->method = $_SERVER['REQUEST_METHOD'];
                $this->form = $_POST;
            }
        }
        $request = new FlaskRequest();

        function redirect($url) {
            header("Location: " . $url);
            exit();
        }

        function url_for($endpoint) {
            return $endpoint == "home" ? "/" : "/" . $endpoint;
        }

        function render_template($file, $context = []) {
            extract($context);
            include __DIR__ . "/templates/" . $file;
        }

        function send_from_directory($directory, $filename) {
            $filePath = __DIR__ . "/" . $directory . "/" . $filename;
            if (file_exists($filePath)) {
                header("Content-Type: " . mime_content_type($filePath));
                readfile($filePath);
                exit();
            }
            header("HTTP/1.0 404 Not Found");
            echo "404 Not Found";
            exit();
        }
        // ------------------------------------------

        """);

        // Process variables, lists, configurations and functions
        for (Statement stmt : ast) {
            generateStatement(stmt);
        }

        // Inject Route Resolution Engine down at the bottom of our file output
        generateRouteDispatcher(ast);

        return phpCode.toString();
    }

    private void generateStatement(Statement stmt) {
        if (stmt instanceof Assignment assign) {
            String leftSide = generateExpression(assign.getLeft());
            String rightSide = generateExpression(assign.getRight());

            // FIX: If the right side was wiped out (like Flask initialization), safely fallback to null
            if (rightSide.trim().isEmpty()) {
                rightSide = "null";
            }
            emitLine(leftSide + " = " + rightSide + ";");
        }
        else if (stmt instanceof FunctionDef func) {
            generateFunctionDef(func);
        }
        else if (stmt instanceof ForStatement forStmt) {
            generateForStatement(forStmt);
        }
        else if (stmt instanceof IfStatement ifStmt) {
            generateIfStatement(ifStmt);
        }
        else if (stmt instanceof ReturnStatement retStmt) {
            emitLine("return " + generateExpression(retStmt.getExpression()) + ";");
        }
        else if (stmt instanceof BreakStatement) {
            emitLine("break;");
        }
        else if (stmt instanceof ExpressionStatement exprStmt) {
            emitLine(generateExpression(exprStmt.getExpression()) + ";");
        }
    }

    private void generateFunctionDef(FunctionDef func) {
        List<String> phpParams = new ArrayList<>();
        for (String param : func.getParameters()) {
            phpParams.add("$" + param);
        }
        String paramList = String.join(", ", phpParams);

        emitLine("function " + func.getName() + "(" + paramList + ") {");
        indentLevel++;

        // Inject scope access to shared globals inside function contexts
        emitLine("global $products, $request;");

        for (Statement bodyStmt : func.getBody()) {
            generateStatement(bodyStmt);
        }

        indentLevel--;
        emitLine("}\n");
    }

    private void generateForStatement(ForStatement forStmt) {
        String collection = generateExpression(forStmt.getIterableExpression());
        String iterator = "$" + forStmt.getIteratorName();

        emitLine("foreach (" + collection + " as " + iterator + ") {");
        indentLevel++;

        for (Statement bodyStmt : forStmt.getBody()) {
            generateStatement(bodyStmt);
        }

        indentLevel--;
        emitLine("}");
    }

    private void generateIfStatement(IfStatement ifStmt) {
        String condition = generateExpression(ifStmt.getConditionExpression());
        emitLine("if (" + condition + ") {");
        indentLevel++;

        for (Statement bodyStmt : ifStmt.getBody()) {
            generateStatement(bodyStmt);
        }

        indentLevel--;
        emitLine("}");

        if (ifStmt.getElseBody() != null && !ifStmt.getElseBody().isEmpty()) {
            emitLine("else {");
            indentLevel++;
            for (Statement bodyStmt : ifStmt.getElseBody()) {
                generateStatement(bodyStmt);
            }
            indentLevel--;
            emitLine("}");
        }
    }

    private String generateExpression(Expression expr) {
        if (expr instanceof Name nameNode) {
            if (nameNode.id.equals("__name__")) {
                return "\"__main__\""; // Python emulation fallback
            }
            return "$" + nameNode.id;
        }
        if (expr instanceof Literal literal) {
            Object val = literal.value;
            if (val instanceof String str) {
                // Strip pre-existing quotes to avoid double-escaping (""text"")
                String cleanStr = str.replaceAll("^\"|\"$|^'|'$", "");
                return "\"" + cleanStr + "\"";
            }
            return String.valueOf(val);
        }
        if (expr instanceof ListExpr listExpr) {
            List<String> elements = listExpr.expressions.stream()
                    .map(this::generateExpression)
                    .toList();
            return "[" + String.join(", ", elements) + "]";
        }
        if (expr instanceof DictExpr dictExpr) {
            List<String> pairs = new ArrayList<>();
            for (Map.Entry<String, Expression> entry : dictExpr.pairs.entrySet()) {
                String cleanKey = entry.getKey().replaceAll("^\"|\"$|^'|'$", "");
                pairs.add("\"" + cleanKey + "\" => " + generateExpression(entry.getValue()));
            }
            return "[" + String.join(", ", pairs) + "]";
        }
        if (expr instanceof Subscript subscript) {
            String target = generateExpression(subscript.value);
            String index = generateExpression(subscript.index);
            return target + "[" + index + "]";
        }
        if (expr instanceof Attribute attr) {
            String obj = generateExpression(attr.object);
            if (obj.equals("$request") && attr.attribute.equals("method")) {
                return "$request->method";
            }
            if (obj.equals("$request") && attr.attribute.equals("form")) {
                return "$request->form";
            }
            return obj + "->" + attr.attribute;
        }
        if (expr instanceof BinaryOperation binOp) {
            return generateExpression(binOp.left) + " " + binOp.op.symbol + " " + generateExpression(binOp.right);
        }
        if (expr instanceof FunctionCall call) {
            return generateFunctionCall(call);
        }
        return "";
    }

    private String generateFunctionCall(FunctionCall call) {
        String name = "";
        if (call.called instanceof Name nameNode) {
            name = nameNode.id;
        } else if (call.called instanceof Attribute attr) {
            String obj = generateExpression(attr.object);
            if (obj.equals("$products") && attr.attribute.equals("append")) {
                return "array_push($products, " + generateExpression(call.args.get(0)) + ")";
            }
            name = attr.attribute;
        }

        switch (name) {
            case "Flask":
                return ""; // Ignore initialization assignment expression output safely
            case "render_template":
                String templateName = generateExpression(call.args.get(0));
                List<String> contextPairs = new ArrayList<>();
                for (Map.Entry<String, Expression> entry : call.kwargs.entrySet()) {
                    contextPairs.add("\"" + entry.getKey() + "\" => " + generateExpression(entry.getValue()));
                }
                return "render_template(" + templateName + ", [" + String.join(", ", contextPairs) + "])";
            case "redirect":
                return "redirect(" + generateExpression(call.args.get(0)) + ")";
            case "url_for":
                return "url_for(" + generateExpression(call.args.get(0)) + ")";
            case "float":
                return "(float)" + generateExpression(call.args.get(0));
            default:
                List<String> normalArgs = call.args.stream().map(this::generateExpression).toList();
                return name + "(" + String.join(", ", normalArgs) + ")";
        }
    }

    private void generateRouteDispatcher(List<Statement> ast) {
        phpCode.append("\n// --- ROUTE ROUTING DISPATCH ENGINE ---\n");
        phpCode.append("$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);\n\n");

        for (Statement stmt : ast) {
            if (stmt instanceof FunctionDef func && func.getDecorators() != null) {
                for (Decorator dec : func.getDecorators()) {
                    if (dec.expr instanceof FunctionCall call && !call.args.isEmpty()) {
                        String rawRule = generateExpression(call.args.get(0)).replace("\"", "");

                        if (rawRule.equals("/")) {
                            phpCode.append("if ($uri === '/') {\n    " + func.getName() + "();\n    exit();\n}\n");
                        }
                        // FIX: Cleanly captures dynamic segments (<int:...> and <path:...>)
                        else if (rawRule.contains("<")) {
                            String cleanParam = rawRule
                                    .replaceAll("<int:(\\w+)>", "(?P<$1>\\\\d+)")
                                    .replaceAll("<path:(\\w+)>", "(?P<$1>.*)");

                            String regexPattern = "~^" + cleanParam + "$~";

                            phpCode.append("if (preg_match('" + regexPattern + "', $uri, $matches)) {\n");

                            // Dynamically map capture variables into target function parameters
                            List<String> passArgs = new ArrayList<>();
                            for (String param : func.getParameters()) {
                                passArgs.add("$matches['" + param + "']");
                            }

                            phpCode.append("    " + func.getName() + "(" + String.join(", ", passArgs) + ");\n");
                            phpCode.append("    exit();\n}\n");
                        }
                        else {
                            phpCode.append("if ($uri === '" + rawRule + "') {\n    " + func.getName() + "();\n    exit();\n}\n");
                        }
                    }
                }
            }
        }
    }
}