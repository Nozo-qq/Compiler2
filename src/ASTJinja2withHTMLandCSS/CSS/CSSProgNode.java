package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;

public class CSSProgNode extends ASTNode {
    public CSSProgNode(int line) {
        super(line);
    }

    public void addRule(CSSRuleNode rule) {
        addChild(rule);
    }

    @Override
    public String label() {
        return "CSSProgNode";
    }
}