package FlaskStatement;

import java.util.List;

public class ForStatement extends Statement {
    private final Expression iterableExpression;
    private final String iteratorName;
    private final List<Statement> body;

    public ForStatement(int line,Expression iterableExpression,
                        String iteratorName,
                        List<Statement> body) {
        super(line);
        this.iterableExpression = iterableExpression;
        this.iteratorName = iteratorName;
        this.body = body;
    }

    public Expression getIterableExpression() {
        return iterableExpression;
    }

    public String getIteratorName() {
        return iteratorName;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }


    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new java.util.ArrayList<>();

        if (iterableExpression != null) {
            children.add(iterableExpression);
        }

        if (body != null) {
            children.addAll(body);
        }

        return children;
    }

}
