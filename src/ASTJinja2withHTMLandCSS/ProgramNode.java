package ASTJinja2withHTMLandCSS;

import java.util.List;

public class ProgramNode extends ASTNode {
    private final ASTNode root;

    public ProgramNode(int line, ASTNode root) {
        super("Program", line);
        this.root = root;
    }
    @Override
    public List<ASTNode> getChildren() {
        return (root != null) ? List.of(root) : List.of();
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName);
        if (root != null) root.print(indent + "  ");
    }
}

