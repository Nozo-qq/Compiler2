package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class SelfClosingTagNode extends ASTNode {
    private final VoidTagNameNode tagName;

    public SelfClosingTagNode(int line, VoidTagNameNode tagName) {
        super(line);
        this.tagName = tagName;
        addChild(tagName);
    }

    public String getName() { return tagName.getName(); }

    public void addAttribute(AttributeNode attr) { addChild(attr); }

    @Override public String label() { return "SelfClosingTag <" + getName() + "/>"; }
}
