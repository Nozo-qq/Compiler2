package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;

public class CSSDeclarationNode extends ASTNode {
    private String property;
    private String value;

    public CSSDeclarationNode(int line, String property, String value) {
        super(line);
        this.property = property;
        this.value = value;
    }

    @Override
    public String label() {
        return "CSSDeclarationNode: Property: " + property + " | Value: " + value;
    }
}