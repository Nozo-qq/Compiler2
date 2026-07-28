package antlr.grammar.flask;

import FlaskStatement.*;

import java.util.*;

public class ASTStatementsBuilderVisitor  extends  FlaskExprParserBaseVisitor<Statement>{
    AntlrToExpression expressionVisitor = new AntlrToExpression();
    int loopDepth =0;
//    public static Stack<String> scope = new Stack<>();
    private Scope currentScope;
    int forCounter = 0;
    int ifCounter =0;
    public ASTStatementsBuilderVisitor() {
        this.currentScope = new Scope(null, "main", Scope.ScopeType.GLOBAL);
    }
    private void pushScope(String name, Scope.ScopeType type) {
        this.currentScope = new Scope(this.currentScope, name, type);
    }

    private void popScope() {
        if (this.currentScope.getParent() != null) {
            this.currentScope = this.currentScope.getParent();
        }
    }
    @Override
    public Statement visitImportstatement(FlaskExprParser.ImportstatementContext ctx) {
        List<String> packageParts = new ArrayList<>();
        packageParts.add(ctx.packageName().NAME(0).getText());
        for (int i = 1; i < ctx.packageName().NAME().size(); i++) {
            packageParts.add(ctx.packageName().NAME(i).getText());
        }
        List<String> importedName = new ArrayList<>();
        for (int i = 0; i < ctx.importList().NAME().size(); i++) {
            importedName.add(ctx.importList().NAME(i).getText());
        }

        return new ImportStatement(ctx.getStart().getLine(),packageParts, importedName);

    }


    @Override
    public Statement visitAssignment(FlaskExprParser.AssignmentContext ctx) {
        Expression left = expressionVisitor.visit(ctx.expr(0));
        Expression right = expressionVisitor.visit(ctx.expr(1));

        if (!(left instanceof Name || left instanceof Subscript || left instanceof Attribute)) {
            throw new RuntimeException("SyntaxError: cannot assign to expression type on left-hand side at line " + ctx.getStart().getLine());
        }
        String varName = left.toString();
        // 1. Define the variable in our new object-based local scope
        currentScope.define(varName, right);

        return new Assignment(ctx.getStart().getLine(), left, right);
    }
    @Override
    public Statement visitReturnStmt(FlaskExprParser.ReturnStmtContext ctx) {
        if (currentScope.getType() == Scope.ScopeType.GLOBAL) {
            throw new RuntimeException("SyntaxError: 'return' outside function");
        }
        Expression expression = expressionVisitor.visit(ctx.expr());

        return new ReturnStatement(ctx.getStart().getLine(),expression);
    }


    @Override
    public Statement visitExprStmt(FlaskExprParser.ExprStmtContext ctx) {
        Expression expression = expressionVisitor.visit(ctx.expr());
        return new ExpressionStatement(ctx.getStart().getLine(),expression);
    }


    @Override
    public Statement visitBreak(FlaskExprParser.BreakContext ctx) {
        if (loopDepth == 0) {
            throw new RuntimeException("SyntaxError: 'break' outside loop at line " + ctx.getStart().getLine());
        }
        return new BreakStatement(ctx.getStart().getLine());
    }

    @Override
    public Statement visitContinue(FlaskExprParser.ContinueContext ctx) {
        if (loopDepth == 0) {
            throw new RuntimeException("SyntaxError: 'continue' outside loop at line " + ctx.getStart().getLine());
        }
        return new ContinueStatement(ctx.getStart().getLine());
    }

    @Override
    public Statement visitFunctionDefstatementment(FlaskExprParser.FunctionDefstatementmentContext ctx) {

        List<Decorator> decorators = new ArrayList<>();
        for (var decCtx : ctx.decorator()) {
            decorators.add(visitDecorator(decCtx));
        }

        FunctionDef func = (FunctionDef) visitFunctionDef(ctx.functionDef());

        return new FunctionDef(ctx.getStart().getLine(),
                func.getName(),
                func.getParameters(),
                func.getBody(),
                decorators
        );
    }

    @Override
    public Statement visitFunctionDef(FlaskExprParser.FunctionDefContext ctx) {
        // 1) Name of function
        String name = ctx.NAME(0).getText();

        // 2) Parameters
        List<String> parameters = new ArrayList<>();
        for (int i = 1; i < ctx.NAME().size(); i++) {
            parameters.add(ctx.NAME(i).getText());
        }

        // 3) Push New Function Scope (Python local execution block)
        pushScope(name, Scope.ScopeType.FUNCTION);

        // Define parameters inside this local scope namespace
        for (String param : parameters) {
            currentScope.define(param, "parameter");
        }

        // 4) Parse Body statements inside this newly bounded environment
        List<Statement> body = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            body.add((Statement) visit(stmtCtx));
        }

        // 5) Exit back out to parent scope context
        popScope();

        return new FunctionDef(ctx.getStart().getLine(), name, parameters, body, null);
    }


    @Override
    public Statement visitIfstatement(FlaskExprParser.IfstatementContext ctx) {
        // REFACTOR NOTE: Removed pushScope / popScope because Python 'if' has no local scope block.
        Expression condition = expressionVisitor.visit(ctx.expr());

        List<Statement> ifBody = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            ifBody.add((Statement) visit(stmtCtx));
        }

        List<Statement> elseBody = new ArrayList<>();
        // Un-comment and adjust if your elseStatement rule is active:
        // if (ctx.elseStatement() != null) {
        //     for (var stmtCtx : ctx.elseStatement().statement()) {
        //         elseBody.add((Statement) visit(stmtCtx));
        //     }
        // }

        return new IfStatement(ctx.getStart().getLine(), condition, ifBody, elseBody);
    }

    @Override
    public Statement visitForstatement(FlaskExprParser.ForstatementContext ctx) {
        // REFACTOR NOTE: Removed pushScope / popScope because Python 'for' loops share scope with their surroundings.
        String name = ctx.NAME().getText();
        Expression expression = expressionVisitor.visit(ctx.expr());

        // The loop control variable is declared/updated right in the current surrounding scope
        currentScope.define(name, expression);
        loopDepth++;
        List<Statement> body = new ArrayList<>();
        for (var statement : ctx.statement()) {
            body.add((Statement) visit(statement));
        }
        loopDepth--;

        return new ForStatement(ctx.getStart().getLine(), expression, name, body);
    }
    @Override
    public Decorator visitDecorator(FlaskExprParser.DecoratorContext ctx) {
        Expression expr = expressionVisitor.visit(ctx.expr());
        return new Decorator(ctx.getStart().getLine(),expr);
    }

}


