package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class AttributeNameNode extends ASTNode {
    private final String name;
    public AttributeNameNode(int line, String name) { super(line); this.name = name; }
    public String getName() { return name; }
    @Override public String label() { return "AttrName '" + name + "'"; }
}
