package FlaskStatement;

import java.util.List;

public class ExpressionStatement extends Statement{
private final Expression expression;


    public ExpressionStatement(int line,Expression expression) {
        super(line);
        this.expression = expression;

    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of(expression);
    }
}
