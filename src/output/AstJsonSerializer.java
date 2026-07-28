package output;

import FlaskStatement.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Serializes a validated Flask AST (Program) into a generic JSON-ready tree. */
public final class AstJsonSerializer {

    private AstJsonSerializer() {}

    public static String serialize(Program program, boolean pretty) {
        return JsonWriter.write(nodeToJson(program), pretty);
    }

    private static Object nodeToJson(ASTNode node) {
        if (node == null) {
            return null;
        }

        LinkedHashMap<String, Object> json = new LinkedHashMap<>();

        if (node instanceof Program program) {
            json.put("type", "Program");
            json.put("line", program.line);
            json.put("statements", nodeListToJson(program.statements));

        } else if (node instanceof Assignment assign) {
            json.put("type", "Assignment");
            json.put("line", assign.line);
            json.put("left", nodeToJson(assign.getLeft()));
            json.put("right", nodeToJson(assign.getRight()));

        } else if (node instanceof ExpressionStatement exprStmt) {
            json.put("type", "ExpressionStatement");
            json.put("line", exprStmt.line);
            json.put("expression", nodeToJson(exprStmt.getExpression()));

        } else if (node instanceof ReturnStatement ret) {
            json.put("type", "ReturnStatement");
            json.put("line", ret.line);
            json.put("expression", nodeToJson(ret.getExpression()));

        } else if (node instanceof BreakStatement brk) {
            json.put("type", "BreakStatement");
            json.put("line", brk.line);

        } else if (node instanceof ContinueStatement cont) {
            json.put("type", "ContinueStatement");
            json.put("line", cont.line);

        } else if (node instanceof ImportStatement imp) {
            json.put("type", "ImportStatement");
            json.put("line", imp.line);
            json.put("packageParts", stringListToJson(imp.getPackageParts()));
            json.put("importedNames", stringListToJson(imp.getImportedNames()));

        } else if (node instanceof Decorator dec) {
            json.put("type", "Decorator");
            json.put("line", dec.line);
            json.put("expression", nodeToJson(dec.expr));

        } else if (node instanceof FunctionDef fn) {
            json.put("type", "FunctionDef");
            json.put("line", fn.line);
            json.put("name", fn.getName());
            json.put("parameters", stringListToJson(fn.getParameters()));
            json.put("decorators", fn.getDecorators() == null ? new ArrayList<>() : nodeListToJson(fn.getDecorators()));
            json.put("body", nodeListToJson(fn.getBody()));

        } else if (node instanceof IfStatement ifStmt) {
            json.put("type", "IfStatement");
            json.put("line", ifStmt.line);
            json.put("condition", nodeToJson(ifStmt.getConditionExpression()));
            json.put("body", nodeListToJson(ifStmt.getBody()));
            json.put("elseBody", nodeListToJson(ifStmt.getElseBody()));

        } else if (node instanceof ForStatement forStmt) {
            json.put("type", "ForStatement");
            json.put("line", forStmt.line);
            json.put("iterableExpression", nodeToJson(forStmt.getIterableExpression()));
            json.put("iteratorName", forStmt.getIteratorName());
            json.put("body", nodeListToJson(forStmt.getBody()));

        } else if (node instanceof Name name) {
            json.put("type", "Name");
            json.put("line", name.line);
            json.put("id", name.id);

        } else if (node instanceof Literal lit) {
            json.put("type", "Literal");
            json.put("line", lit.line);
            json.put("value", lit.isString() ? PyLiteralUtil.unquoteString((String) lit.value) : lit.value);

        } else if (node instanceof ListExpr listExpr) {
            json.put("type", "ListExpr");
            json.put("line", listExpr.line);
            json.put("elements", nodeListToJson(listExpr.expressions));

        } else if (node instanceof DictExpr dictExpr) {
            json.put("type", "DictExpr");
            json.put("line", dictExpr.line);
            LinkedHashMap<String, Object> pairs = new LinkedHashMap<>();
            for (Map.Entry<String, Expression> entry : dictExpr.pairs.entrySet()) {
                pairs.put(PyLiteralUtil.unquoteString(entry.getKey()), nodeToJson(entry.getValue()));
            }
            json.put("pairs", pairs);

        } else if (node instanceof BinaryOperation binOp) {
            json.put("type", "BinaryOperation");
            json.put("line", binOp.line);
            json.put("operator", binOp.op.symbol);
            json.put("left", nodeToJson(binOp.left));
            json.put("right", nodeToJson(binOp.right));

        } else if (node instanceof Attribute attr) {
            json.put("type", "Attribute");
            json.put("line", attr.line);
            json.put("object", nodeToJson(attr.object));
            json.put("attribute", attr.attribute);

        } else if (node instanceof Subscript sub) {
            json.put("type", "Subscript");
            json.put("line", sub.line);
            json.put("value", nodeToJson(sub.value));
            json.put("index", nodeToJson(sub.index));

        } else if (node instanceof FunctionCall call) {
            json.put("type", "FunctionCall");
            json.put("line", call.line);
            json.put("called", nodeToJson(call.called));
            json.put("args", nodeListToJson(call.args));
            LinkedHashMap<String, Object> kwargs = new LinkedHashMap<>();
            for (Map.Entry<String, Expression> entry : call.kwargs.entrySet()) {
                kwargs.put(entry.getKey(), nodeToJson(entry.getValue()));
            }
            json.put("kwargs", kwargs);

        } else {
            json.put("type", node.getClass().getSimpleName());
            json.put("line", node.line);
            json.put("warning", "unserialized node type");
        }

        return json;
    }

    private static List<Object> nodeListToJson(List<? extends ASTNode> nodes) {
        List<Object> out = new ArrayList<>();
        if (nodes == null) return out;
        for (ASTNode node : nodes) {
            out.add(nodeToJson(node));
        }
        return out;
    }

    private static List<Object> stringListToJson(List<String> strings) {
        List<Object> out = new ArrayList<>();
        if (strings == null) return out;
        out.addAll(strings);
        return out;
    }
}
