package antlr.grammar.flask;

import FlaskStatement.*;
import java.util.*;

public class SemanticAnalyzer {

    private Scope currentScope;
    private final Set<String> builtInFunctions = new HashSet<>();
    private final Set<String> builtInNames = new HashSet<>();

    public SemanticAnalyzer() {
        // Initialize with the standard Python/Flask global module scope
        this.currentScope = new Scope(null, "main", Scope.ScopeType.GLOBAL);

        // Seed standard Flask/Python global built-ins so they pass validation
        builtInFunctions.addAll(Arrays.asList(
                "Flask", "render_template", "request", "redirect", "url_for", "print", "len", "range","append"
        ));
        builtInNames.addAll(Arrays.asList(
               "__name__"
        ));
    }

    // Main entry point to kick off validation for the entire AST program
    public void analyze(List<Statement> ast) {
        for (Statement stmt : ast) {
            checkStatement(stmt);
        }
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    // Router to evaluate statements
    private void checkStatement(Statement stmt) {
        if (stmt instanceof Assignment assign) {
            checkAssignment(assign);
        } else if (stmt instanceof FunctionDef func) {
            checkFunctionDef(func);
        } else if (stmt instanceof ExpressionStatement exprStmt) {
            checkExpression(exprStmt.getExpression());
        } else if (stmt instanceof IfStatement ifStmt) {
            checkIfStatement(ifStmt);
        } else if (stmt instanceof ForStatement forStmt) {
            checkForStatement(forStmt);
        }
    }


    private void checkExpression(Expression expr) {
        if (expr instanceof Name nameNode) {
            // [ERROR 1: NameError] Look up the name across the active scope chain
            if (currentScope.lookup(nameNode.id) == null && !builtInFunctions.contains(nameNode.id) && !builtInNames.contains(nameNode.id)) {
                throw new RuntimeException("SemanticError: NameError: Variable '" + nameNode.id + "' is not defined at line " + nameNode.line);
            }
        }

        else if (expr instanceof BinaryOperation binOp) {
            // Deep dive into both operational sides to verify all underlying targets exist
            checkExpression(binOp.left);
            checkExpression(binOp.right);
        }

        else if (expr instanceof FunctionCall call) {
            Expression called = call.called;
            String funcName;

            // Fix: If it's a method call (like obj.append()), extract the method name string
            if (called instanceof Attribute attributeNode) {
                funcName = attributeNode.attribute; // This yields "append"
            } else {
                funcName = called.toString();
            }

            // Check if it's a valid function or a standard built-in keyword (like 'append')
            Object typeRecord = currentScope.lookup(funcName);
            boolean isBuiltIn = builtInFunctions.contains(funcName);

            if (typeRecord == null && !isBuiltIn) {
                throw new RuntimeException("SemanticError: NameError: Function '" + funcName + "' is not defined at line " + call.line);
            }

            boolean isCallable = isBuiltIn
                    || "function".equals(typeRecord)
                    //here we let the parameter of the function be callable because the python is loassly typed language , so this is one of the tradoffs , we can not check if the parameter is callable or not in daynamic typed languages
                    || "parameter".equals(typeRecord);

            if (!isCallable) {
                throw new RuntimeException("SemanticError: TypeError: '" + funcName + "' object of type '" + typeRecord + "' is not callable at line " + call.line);
            }
            boolean isRegisteredFunc = (typeRecord != null && typeRecord.equals("function"));

            if (!isBuiltIn && !isRegisteredFunc) {
                throw new RuntimeException("SemanticError: TypeError: '" + funcName + "' object is not callable at line " + call.line);
            }

            // Validate parameters passed as arguments
            for (Expression arg : call.args) {
                checkExpression(arg);
            }
            for (Expression kwarg : call.kwargs.values()) {
                checkExpression(kwarg);
            }
        }

    }


    private void checkFunctionDef(FunctionDef func) {
        String funcName = func.getName();

        // [ERROR 2: RedefinitionError] Prevent overwriting names in the same local block
        if (currentScope.lookup(funcName) != null) {
            throw new RuntimeException("SemanticError: RedefinitionError: symbol '" + funcName + "' is already defined in this scope layer at line " + func.line);
        }


        // Register function inside outer scope environment block
        currentScope.define(funcName, "function");

        // Open an inner function local execution scope frame context
        currentScope = new Scope(currentScope, funcName, Scope.ScopeType.FUNCTION);

        // Bind parameters locally
        for (String param : func.getParameters()) {
            currentScope.define(param, "parameter");
        }

        // Cascade checks through the function body statements sequentially
        for (Statement bodyStmt : func.getBody()) {
            checkStatement(bodyStmt);
        }

        // Safely exit function definition execution scope frame block context
        currentScope = currentScope.getParent();
    }

    private void checkAssignment(Assignment assign) {
        // Check right-hand variables first!
        checkExpression(assign.getRight());

        String varName = assign.getLeft().toString();

        // Register assignment creation signature status
        currentScope.define(varName, "variable");
    }

    private void checkForStatement(ForStatement forStmt) {
        // Validate target expression iterable source
        checkExpression(forStmt.getIterableExpression());

        String iteratorName = forStmt.getIteratorName();

        // Fix: Catch if the loop variable shadows something in a parent scope
        if (currentScope.getParent() != null && currentScope.getParent().lookup(iteratorName) != null) {
            System.out.println("SemanticWarning: Local loop variable '" + iteratorName + "' shadows outer declaration scope record.");
        }

        // Register loop control target variable directly into current outer scope context
        currentScope.define(iteratorName, "variable");

        // Process statements nested inside loop execution path
        for (Statement stmt : forStmt.getBody()) {
            checkStatement(stmt);
        }
    }
    private void checkIfStatement(IfStatement ifStmt) {
        checkExpression(ifStmt.getConditionExpression());

        for (Statement stmt : ifStmt.getBody()) {
            checkStatement(stmt);
        }
        for (Statement stmt : ifStmt.getElseBody()) {
            checkStatement(stmt);
        }
    }

}