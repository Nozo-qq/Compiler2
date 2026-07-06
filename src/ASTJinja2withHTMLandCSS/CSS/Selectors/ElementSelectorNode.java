package ASTJinja2withHTMLandCSS.CSS.Selectors;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;
public class ElementSelectorNode extends CSSSelectorNode {
    public ElementSelectorNode(int line, String name) { super("ElementSelector", line, name); }
}