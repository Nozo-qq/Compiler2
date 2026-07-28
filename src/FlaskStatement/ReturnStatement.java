package FlaskStatement;

import java.util.List;

public class ReturnStatement extends Statement {
    private final Expression expression; // can be null

    public ReturnStatement(int line ,Expression expression) {
        super(line);
        this.expression = expression;
    }

    public boolean returnsValue() {
        return expression != null;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public List<ASTNode> getChildren() {
        return expression == null
                ? List.of()
                : List.of(expression);
    }

}

