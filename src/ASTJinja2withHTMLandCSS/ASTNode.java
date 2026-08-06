package ASTJinja2withHTMLandCSS;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {
    protected final int line;
    protected final List<ASTNode> children = new ArrayList<>();

    public ASTNode(int line) { this.line = line; }

    public int getLine() { return line; }

    public List<ASTNode> getChildren() { return children; }

    public void addChild(ASTNode child) {
        if (child != null) children.add(child);
    }

    public abstract String label();

    public String toTree() { return toTree("", true, true); }

    private String toTree(String prefix, boolean isLast, boolean isRoot) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        if (!isRoot) sb.append(isLast ? "└── " : "├── ");
        sb.append(label()).append("  (line ").append(line).append(")\n");
        String childPrefix = isRoot ? "" : prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < children.size(); i++)
            sb.append(children.get(i).toTree(childPrefix, i == children.size() - 1, false));
        return sb.toString();
    }
}