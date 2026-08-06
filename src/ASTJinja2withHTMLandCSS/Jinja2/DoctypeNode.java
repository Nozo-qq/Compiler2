package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class DoctypeNode extends ASTNode {
    public DoctypeNode(int line) { super(line); }
    @Override public String label() { return "Doctype <!DOCTYPE html>"; }
}
