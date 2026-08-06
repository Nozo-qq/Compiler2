package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class OpenCloseTagNode extends ASTNode {
    private final StartTagNode startTag;
    private EndTagNode endTag;

    public OpenCloseTagNode(int line, StartTagNode startTag) {
        super(line);
        this.startTag = startTag;
        addChild(startTag);
    }

    public StartTagNode getStartTag() { return startTag; }
    public EndTagNode getEndTag() { return endTag; }

    public void addContent(ASTNode content) { addChild(content); }

    public void setEndTag(EndTagNode endTag) {
        this.endTag = endTag;
        addChild(endTag);
    }

    @Override public String label() { return "Element <" + startTag.getName() + ">...</" + startTag.getName() + ">"; }
}
