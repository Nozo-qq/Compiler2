package ASTJinja2withHTMLandCSS;

public class ProgramNode extends ASTNode {
    public ProgramNode(int line, ASTNode root) {
        super(line);
        addChild(root);
    }
    @Override public String label() { return "Program"; }
}