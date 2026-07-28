package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocumentNode extends ASTNode {
    private final DoctypeNode doctype;
    private final List<ASTNode> topLevelContent = new ArrayList<>();

    public HtmlDocumentNode(int line, DoctypeNode doctype) {
        super("HtmlDocument", line);
        this.doctype = doctype;
    }

    public void addContent(ASTNode node) {
        topLevelContent.add(node);
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (doctype != null) {
            children.add(doctype);
        }
        children.addAll(topLevelContent);
        return children;
    }
}
