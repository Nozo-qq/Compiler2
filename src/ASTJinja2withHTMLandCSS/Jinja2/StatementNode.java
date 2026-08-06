package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class StatementNode extends ASTNode {
    private final String text;
    public StatementNode(int line, String text) { super(line); this.text = text; }
    public String getText() { return text; }
    @Override public String label() { return "Text \"" + text + "\""; }
}
