package ASTJinja2withHTMLandCSS.HTML.Expressions;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionNode extends ASTNode {
    private final ASTNode inner;

    public ExpressionNode(int line, ASTNode inner) {
        super("Expression", line);
        this.inner = inner;
    }

    public ASTNode getInner() {
        return inner;
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (inner != null) {
            children.add(inner);
        }
        return children;
    }
}
