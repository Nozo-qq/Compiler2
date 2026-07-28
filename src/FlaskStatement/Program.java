package FlaskStatement;

import java.util.List;

public class Program extends ASTNode {
    public List<Statement> statements;

    public Program(List<Statement> stmts) {
        super(0);
        this.statements = stmts;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.copyOf(statements);
    }
}

