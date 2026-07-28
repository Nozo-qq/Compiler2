package FlaskStatement;

import java.util.List;

public class IfStatement extends Statement {
    private final Expression conditionExpression;
    private final List<Statement> body;
    private final List<Statement> elseBody;

    public IfStatement(int line ,Expression conditionExpression,
                       List<Statement> body,
                       List<Statement> elseBody) {
        super(line);
        this.conditionExpression = conditionExpression;
        this.body = body;
        this.elseBody = elseBody;
    }

    public Expression getConditionExpression() {
        return conditionExpression;
    }

    public List<Statement> getBody() {
        return body;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new java.util.ArrayList<>();

        if (conditionExpression != null) {
            children.add(conditionExpression);
        }

        if (body != null) {
            children.addAll(body);
        }

        if (elseBody != null && !elseBody.isEmpty()) {
            children.addAll(elseBody);
        }

        return children;
    }

}
