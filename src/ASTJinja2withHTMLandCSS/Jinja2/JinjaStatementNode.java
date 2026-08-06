package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class JinjaStatementNode extends ASTNode {
    private final String statement;
    public JinjaStatementNode(int line, String statement) { super(line); this.statement = statement; }
    public String getStatement() { return statement; }
    @Override public String label() { return "JinjaStatement {% " + statement + " %}"; }
}
