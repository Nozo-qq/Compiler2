package FlaskStatement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FunctionCall extends Expression{
    public  Expression called;
    public  List<Expression> args;
    public  Map<String, Expression> kwargs;

    public FunctionCall(int line ,Expression called,
                        List<Expression> args,
                        Map<String, Expression> kwargs) {
        super(line);
        this.called = called;
        this.args = Collections.unmodifiableList(args);
        this.kwargs = Collections.unmodifiableMap(kwargs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(called).append("(");
        boolean first = true;
        for (Expression arg : args) {
            if (!first) sb.append(", ");
            sb.append(arg);
            first = false;
        }
        for (var entry : kwargs.entrySet()) {
            if (!first) sb.append(", ");
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new java.util.ArrayList<>();

        if (called != null) {
            children.add(called);
        }

        if (args != null) {
            children.addAll(args);
        }

        if (kwargs != null) {
            children.addAll(kwargs.values());
        }

        return children;
    }

}
