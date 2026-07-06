package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CSSProgNode extends ASTNode {

    private final List<CSSRuleNode> rules = new ArrayList<>();

    public CSSProgNode(int line) {
        super("CSSProg", line);
    }

    public void addRule(CSSRuleNode rule) {
        rules.add(rule);
    }
    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(rules);
    }

}
