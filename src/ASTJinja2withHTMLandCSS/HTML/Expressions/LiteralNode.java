package ASTJinja2withHTMLandCSS.HTML.Expressions;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class LiteralNode extends ASTNode {
    private final Object value;
    private final String rawText;

    public LiteralNode(int line, Object value, String rawText) {
        super("Literal", line);
        this.value = value;
        this.rawText = rawText;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String getNodeValue() {
        return rawText;
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}
