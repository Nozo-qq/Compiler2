package FlaskStatement;

import java.util.List;

public class Subscript extends Expression {
    public final Expression value;
    public final Expression index;

    public Subscript(int line, Expression value, Expression index) {
        super(line);
        this.value = value;
        this.index = index;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of(value, index);
    }
}

