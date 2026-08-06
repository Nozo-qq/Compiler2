package ASTJinja2withHTMLandCSS.Jinja2.Factory;

import ASTJinja2withHTMLandCSS.Jinja2.AttributeNameNode;

public class AttributeFactory {
    public static AttributeNameNode create(int line, String name) {
        return new AttributeNameNode(line, name);
    }
}
