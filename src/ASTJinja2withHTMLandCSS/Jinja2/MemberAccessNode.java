package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class MemberAccessNode extends ASTNode {
    private final List<String> parts = new ArrayList<>();

    public MemberAccessNode(int line) { super(line); }

    public void addPart(String part) { parts.add(part); }
    public List<String> getParts() { return parts; }

    @Override public String label() { return "MemberAccess " + String.join(".", parts); }
}
