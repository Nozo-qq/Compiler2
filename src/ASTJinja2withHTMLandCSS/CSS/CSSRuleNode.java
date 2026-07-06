package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.Selectors.SelectorListNode;

import java.util.ArrayList;
import java.util.List;

public class CSSRuleNode extends ASTNode {

    private final SelectorListNode selectors;
    private final List<CSSDeclarationNode> declarations = new ArrayList<>();

    public CSSRuleNode(int line, SelectorListNode selectors) {
        super("CSSRule", line);
        this.selectors = selectors;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (selectors != null) {
            children.add(selectors);
        }
        children.addAll(declarations);
        return children;
    }

    public void addDeclaration(CSSDeclarationNode d) {
        declarations.add(d);
    }
}
