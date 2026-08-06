package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class TagNameNode extends ASTNode {
    private final String name;
    public TagNameNode(int line, String name) { super(line); this.name = name; }
    public String getName() { return name; }
    @Override public String label() { return "TagName '" + name + "'"; }
}
