package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class Jinja2ProgNode extends ASTNode {
    private DoctypeNode doctype;

    public Jinja2ProgNode(int line) { super(line); }

    public void setDoctype(DoctypeNode d) {
        this.doctype = d;
        children.add(0, d); // الدوكتايب دائماً أول عنصر بالعرض
    }

    public DoctypeNode getDoctype() { return doctype; }

    public void addElement(ASTNode element) { addChild(element); }

    @Override public String label() { return "Jinja2Prog"; }
}
