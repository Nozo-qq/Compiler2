package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class ExpressionNode extends ASTNode {
    private final MemberAccessNode member;

    public ExpressionNode(int line, MemberAccessNode member) {
        super(line);
        this.member = member;
        addChild(member);
    }

    public MemberAccessNode getMember() { return member; }

    @Override public String label() { return "Expression {{ ... }}"; }
}
