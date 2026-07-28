package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class HtmlElementNode extends ASTNode {
    private final String tagName;
    private final List<AttributeNode> attributes = new ArrayList<>();
    private final List<ASTNode> content = new ArrayList<>();
    private final boolean selfClosing;

    public HtmlElementNode(int line, String tagName, boolean selfClosing) {
        super("HtmlElement", line);
        this.tagName = tagName;
        this.selfClosing = selfClosing;
    }

    public void addAttribute(AttributeNode attribute) {
        attributes.add(attribute);
    }

    public void addChild(ASTNode child) {
        content.add(child);
    }

    public String getTagName() {
        return tagName;
    }

    public List<AttributeNode> getAttributes() {
        return attributes;
    }

    public List<ASTNode> getContent() {
        return content;
    }

    public boolean isSelfClosing() {
        return selfClosing;
    }

    @Override
    public String getNodeValue() {
        return "<" + tagName + (selfClosing ? " />" : ">");
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>(attributes);
        children.addAll(content);
        return children;
    }
}
