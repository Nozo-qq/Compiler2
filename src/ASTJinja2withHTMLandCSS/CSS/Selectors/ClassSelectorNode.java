package ASTJinja2withHTMLandCSS.CSS.Selectors;

public class ClassSelectorNode extends CSSSelectorNode {
    private String className;

    public ClassSelectorNode(int line, String className) {
        super(line);
        this.className = className;
    }

    @Override
    public String label() {
        return "ClassSelectorNode: ." + className;
    }
}