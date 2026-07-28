package FlaskStatement;

import java.util.List;

public class Assignment extends Statement {
    private final Expression left;
    private final Expression right;

    public Assignment(int line,Expression left, Expression right) {
        super(line);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }


    @Override
    public List<ASTNode> getChildren() {
        return List.of(left, right);
    }

}
