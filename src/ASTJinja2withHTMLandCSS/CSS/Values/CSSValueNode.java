package ASTJinja2withHTMLandCSS.CSS.Values;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public abstract class CSSValueNode extends ASTNode {
    protected String value;

    public CSSValueNode(int line, String value) {
        super(line);
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(); // القيم غالباً هي أوراق (Leaf Nodes) ليس لها أبناء
    }

}