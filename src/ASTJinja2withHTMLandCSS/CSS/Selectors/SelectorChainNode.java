package ASTJinja2withHTMLandCSS.CSS.Selectors;
import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class SelectorChainNode extends CSSSelectorNode {
    private final List<CSSSelectorNode> parts = new ArrayList<>();

    public SelectorChainNode(int line) { super("SelectorChain", line, null); }
    public void addPart(CSSSelectorNode part) { parts.add(part); }

    @Override
    public List<ASTNode> getChildren() { return new ArrayList<>(parts); }

    @Override
    protected String getNodeValue() { return "Selector Chain"; }
}