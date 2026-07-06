package ASTJinja2withHTMLandCSS.CSS.Values;

// عقدة لوحدات القياس (px, em, %)
public class CSSUnitNode extends CSSValueNode {
    public CSSUnitNode(int line, String value) {
        super("CSSUnit", line, value);
    }
}