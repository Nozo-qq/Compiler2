package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class TextNode extends ASTNode {
    private final String text;

    public TextNode(int line, String text) {
        super("Text", line);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getNodeValue() {
        return text;
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}
