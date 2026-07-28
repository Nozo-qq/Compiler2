package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class AttributeValueNode extends ASTNode {
    private final List<ASTNode> parts = new ArrayList<>();

    public AttributeValueNode(int line) {
        super("AttributeValue", line);
    }

    public void addPart(ASTNode part) {
        parts.add(part);
    }

    public List<ASTNode> getParts() {
        return parts;
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(parts);
    }
}
