package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class EndTagNode extends ASTNode {
    private final TagNameNode tagName;

    public EndTagNode(int line, TagNameNode tagName) {
        super(line);
        this.tagName = tagName;
        addChild(tagName);
    }

    public String getName() { return tagName.getName(); }

    @Override public String label() { return "EndTag </" + getName() + ">"; }
}
