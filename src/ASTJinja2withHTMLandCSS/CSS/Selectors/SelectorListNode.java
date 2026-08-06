package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;

public class SelectorListNode extends ASTNode {
    public SelectorListNode(int line) {
        super(line);
    }

    public void addSelector(SelectorChainNode selector) {
        addChild(selector);
    }

    @Override
    public String label() {
        return "SelectorListNode: Selector List";
    }
}