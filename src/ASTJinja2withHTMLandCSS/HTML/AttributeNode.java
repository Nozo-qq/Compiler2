package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class AttributeNode extends ASTNode {
    private final String name;
    private final AttributeValueNode value;
    private final boolean isBoolean;

    public AttributeNode(int line, String name, AttributeValueNode value, boolean isBoolean) {
        super("Attribute", line);
        this.name = name;
        this.value = value;
        this.isBoolean = isBoolean;
    }

    public String getName() {
        return name;
    }

    public AttributeValueNode getValue() {
        return value;
    }

    public boolean isBoolean() {
        return isBoolean;
    }

    @Override
    public String getNodeValue() {
        return isBoolean ? name : name + "=...";
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
