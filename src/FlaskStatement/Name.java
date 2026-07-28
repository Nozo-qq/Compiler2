package FlaskStatement;

import java.util.List;

public class Name extends Expression {
    public final String id;

    public Name(int line, String id) {
        super(line);
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of(); // leaf
    }
}
