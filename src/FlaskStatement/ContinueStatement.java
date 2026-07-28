package FlaskStatement;

import java.util.List;

public class ContinueStatement extends Statement{
    public ContinueStatement(int line) {
        super(line);
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
}
