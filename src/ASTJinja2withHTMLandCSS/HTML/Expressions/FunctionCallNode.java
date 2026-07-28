package ASTJinja2withHTMLandCSS.HTML.Expressions;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionCallNode extends ASTNode {
    private final MemberAccessNode callee;
    private final List<ArgumentNode> arguments = new ArrayList<>();

    public FunctionCallNode(int line, MemberAccessNode callee) {
        super("FunctionCall", line);
        this.callee = callee;
    }

    public void addArgument(ArgumentNode argument) {
        arguments.add(argument);
    }

    public MemberAccessNode getCallee() {
        return callee;
    }

    public List<ArgumentNode> getArguments() {
        return arguments;
    }

    @Override
    public String getNodeValue() {
        return (callee != null ? callee.getNodeValue() : "?") + "(...)";
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (callee != null) {
            children.add(callee);
        }
        children.addAll(arguments);
        return children;
    }
}
