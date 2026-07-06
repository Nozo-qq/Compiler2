package ASTJinja2withHTMLandCSS.CSS.Selectors;
import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class SelectorListNode extends CSSSelectorNode {
    private final List<CSSSelectorNode> selectors = new ArrayList<>();

    public SelectorListNode(int line) { super("SelectorList", line, null); }
    public void addSelector(CSSSelectorNode sel) { selectors.add(sel); }

    @Override
    public List<ASTNode> getChildren() { return new ArrayList<>(selectors); }

    @Override
    protected String getNodeValue() { return "Selector List"; }
}