package antlr.grammar.flask;

import FlaskStatement.Program;
import FlaskStatement.Statement;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends FlaskExprParserBaseVisitor<Program>{
    @Override
    public Program visitProgram(FlaskExprParser.ProgramContext ctx) {
        List<Statement> statements = new ArrayList<>();

        ASTStatementsBuilderVisitor statementVisitor = new ASTStatementsBuilderVisitor();
        for (var stmtCtx : ctx.statement()) {
            statements.add(statementVisitor.visit(stmtCtx));
        }

        return new Program(statements);
    }
}
