package FlaskStatement;

import java.util.List;

public class Decorator extends Statement{
    public  Expression expr;   // the expression after @ (e.g. @cache, @app.route("/"))

    public Decorator(int line,Expression expr) {
        super(line);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "@" + expr;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of(expr);
    }
}
