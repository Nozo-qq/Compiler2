package FlaskStatement;

import java.util.List;

public class FunctionDef extends Statement {
    private final String name;
    private final List<String> parameters;
    private final List<Statement> body;
    private final List<Decorator> decorators;

    public FunctionDef(int line,String name,
                       List<String> parameters,
                       List<Statement> body,
                       List<Decorator> decorators) {
        super(line);
        this.name = name;
        this.parameters = parameters;
        this.body = body;
        this.decorators = decorators;
    }

    public List<Decorator> getDecorators() {
        return decorators;
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new java.util.ArrayList<>();

        if (decorators != null) {
            children.addAll(decorators);
        }

        if (body != null) {
            children.addAll(body);
        }

        return children;
    }

}


