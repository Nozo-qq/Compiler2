package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ForNode extends ASTNode {
    private final String loopVar;
    private final String iterableName;
    private final List<ASTNode> body = new ArrayList<>();

    public ForNode(int line, String loopVar, String iterableName) {
        super("For", line);
        this.loopVar = loopVar;
        this.iterableName = iterableName;
    }

    public void addBodyItem(ASTNode item) {
        body.add(item);
    }

    public String getLoopVar() {
        return loopVar;
    }

    public String getIterableName() {
        return iterableName;
    }

    public List<ASTNode> getBody() {
        return body;
    }

    @Override
    public String getNodeValue() {
        return "for " + loopVar + " in " + iterableName;
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(body);
    }
}
