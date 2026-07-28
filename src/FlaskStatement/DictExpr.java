package FlaskStatement;

import java.util.List;
import java.util.Map;

public class DictExpr extends Expression{
    public Map<String,Expression> pairs;

    public DictExpr(int line ,Map<String, Expression> pairs) {
        super(line);
        this.pairs = pairs;
    }


    @Override
    public String toString() {
        return pairs.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        return pairs == null
                ? List.of()
                : List.copyOf(pairs.values());
    }

}
