package FlaskStatement;

import java.util.List;
import java.util.Map;

public class ListExpr extends Expression{
    public List<Expression> expressions;

    public ListExpr(int line,List<Expression> expressions){
        super(line);
        this.expressions=expressions;
    }


    @Override
    public String toString() {
        return expressions.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        return expressions == null
                ? List.of()
                : List.copyOf(expressions);
    }

}
