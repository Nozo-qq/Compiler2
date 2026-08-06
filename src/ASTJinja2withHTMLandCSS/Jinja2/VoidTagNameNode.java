package ASTJinja2withHTMLandCSS.Jinja2;

public class VoidTagNameNode extends TagNameNode {
    public VoidTagNameNode(int line, String name) { super(line, name); }
    @Override public String label() { return "VoidTagName '" + getName() + "'"; }
}
