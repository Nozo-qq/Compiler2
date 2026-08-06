package ASTJinja2withHTMLandCSS.CSS.Values;

// عقدة للألوان (#FFF)
public class CSSColorNode extends CSSValueNode {
    public CSSColorNode(int line, String value) {
        super(line, value);
    }
    @Override
    public String label() {
        return "CSSColor " + getValue();
    }
}