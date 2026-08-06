package ASTJinja2withHTMLandCSS;

public class FrontendRootNode extends ASTNode {
    public FrontendRootNode(int line) {
        super(line);
    }

    @Override
    public String label() {
        return "Frontend_Project_Root";
    }
}