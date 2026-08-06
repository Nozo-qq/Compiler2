package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class StartTagNode extends ASTNode {
    private final TagNameNode tagName;

    public StartTagNode(int line, TagNameNode tagName) {
        super(line);
        this.tagName = tagName;
        addChild(tagName);
    }

    public TagNameNode getTagName() { return tagName; }
    public String getName() { return tagName.getName(); }

    public void addAttribute(AttributeNode attr) { addChild(attr); }

    @Override public String label() { return "StartTag <" + getName() + ">"; }
}
