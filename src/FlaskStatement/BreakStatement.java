package FlaskStatement;

import java.util.List;

public class BreakStatement extends Statement {
    public BreakStatement(int line) {
        super(line);
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
}

