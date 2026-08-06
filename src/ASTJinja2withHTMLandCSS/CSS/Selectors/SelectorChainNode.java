package ASTJinja2withHTMLandCSS.CSS.Selectors;

public class SelectorChainNode extends CSSSelectorNode {
    private String pseudoClass;

    public SelectorChainNode(int line) {
        super(line);
    }

    public void addPart(CSSSelectorNode part) {
        addChild(part);
    }

    public void setPseudoClass(String pseudoClass) {
        this.pseudoClass = pseudoClass;
    }

    @Override
    public String label() {
        return pseudoClass != null ? "SelectorChainNode: Selector Chain (:" + pseudoClass + ")" : "SelectorChainNode: Selector Chain";
    }
}