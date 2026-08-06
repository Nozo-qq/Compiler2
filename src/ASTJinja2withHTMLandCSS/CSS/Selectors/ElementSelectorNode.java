package ASTJinja2withHTMLandCSS.CSS.Selectors;

public class ElementSelectorNode extends CSSSelectorNode {
    private String name;

    public ElementSelectorNode(int line, String name) {
        super(line);
        this.name = name;
    }

    @Override
    public String label() {
        return "ElementSelectorNode: " + name;
    }
}