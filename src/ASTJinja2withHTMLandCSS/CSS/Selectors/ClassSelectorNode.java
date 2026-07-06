package ASTJinja2withHTMLandCSS.CSS.Selectors;

public class ClassSelectorNode extends CSSSelectorNode {
    public ClassSelectorNode(int line, String name) { super("ClassSelector", line, "." + name); }
}