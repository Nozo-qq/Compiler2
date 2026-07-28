package ASTJinja2withHTMLandCSS.HTML.Expressions;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ArgumentNode extends ASTNode {
    private final String name;
    private final ASTNode value;

    public ArgumentNode(int line, String name, ASTNode value) {
        super("Argument", line);
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public ASTNode getValue() {
        return value;
    }

    @Override
    public String getNodeValue() {
        return name != null ? name + "=" : "(positional)";
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (value != null) {
            children.add(value);
        }
        return children;
    }
}
