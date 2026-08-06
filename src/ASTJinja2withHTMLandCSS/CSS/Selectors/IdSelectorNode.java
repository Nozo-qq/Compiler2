package ASTJinja2withHTMLandCSS.CSS.Selectors;

public class IdSelectorNode extends CSSSelectorNode {
    private String idName;

    public IdSelectorNode(int line, String idName) {
        super(line);
        this.idName = idName;
    }

    @Override
    public String label() {
        return "IdSelectorNode: #" + idName;
    }
}