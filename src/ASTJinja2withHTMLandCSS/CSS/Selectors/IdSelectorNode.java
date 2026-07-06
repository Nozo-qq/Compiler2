package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;

public class IdSelectorNode extends CSSSelectorNode {
    public IdSelectorNode(int line, String name) { super("IdSelector", line, "#" + name); }
}