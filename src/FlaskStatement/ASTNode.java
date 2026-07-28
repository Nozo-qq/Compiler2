package FlaskStatement;

import java.util.List;

public abstract class ASTNode {
    public final int line;

    protected ASTNode(int line) {
        this.line = line;
    }

    public abstract List<ASTNode> getChildren();
}
