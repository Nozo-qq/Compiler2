package ASTJinja2withHTMLandCSS.CSS.Values;
// عقدة للأرقام
public class CSSNumberNode extends CSSValueNode {
    public CSSNumberNode(int line, String value) {
        super(line, value);
    }
    @Override
    public String label() {
        return "CSSNumber " + getValue();
    }
}