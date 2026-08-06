package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.Selectors.SelectorListNode;

public class CSSRuleNode extends ASTNode {
    public CSSRuleNode(int line, SelectorListNode selectors) {
        super(line);
        addChild(selectors);
    }

    public void addDeclaration(CSSDeclarationNode declaration) {
        addChild(declaration);
    }

    @Override
    public String label() {
        return "CSSRuleNode";
    }
}