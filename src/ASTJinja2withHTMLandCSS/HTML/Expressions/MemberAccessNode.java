package ASTJinja2withHTMLandCSS.HTML.Expressions;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class MemberAccessNode extends ASTNode {
    private final List<String> path;

    public MemberAccessNode(int line, List<String> path) {
        super("MemberAccess", line);
        this.path = path;
    }

    public List<String> getPath() {
        return path;
    }

    @Override
    public String getNodeValue() {
        return String.join(".", path);
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}
