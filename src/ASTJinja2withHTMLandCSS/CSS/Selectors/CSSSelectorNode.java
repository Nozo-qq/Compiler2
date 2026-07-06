package ASTJinja2withHTMLandCSS.CSS.Selectors;
import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public abstract class CSSSelectorNode extends ASTNode {
    protected String selectorValue;

    public CSSSelectorNode(String nodeType, int line, String selectorValue) {
        super(nodeType, line);
        this.selectorValue = selectorValue;
    }

    public String getSelectorValue() { return selectorValue; }

    @Override
    public List<ASTNode> getChildren() { return new ArrayList<>(); } // افتراضياً بدون أبناء

    @Override
    protected String getNodeValue() { return selectorValue; }
}