package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class DoctypeNode extends ASTNode {
    private final String keyword;
    private final String value;

    public DoctypeNode(int line, String keyword, String value) {
        super("Doctype", line);
        this.keyword = keyword;
        this.value = value;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getNodeValue() {
        return "<!" + keyword + " " + value + ">";
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}
