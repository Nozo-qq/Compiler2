package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class AttributeNode extends ASTNode {
    private final AttributeNameNode name;
    private final AttributeValueNode value; // null للـ boolean attributes

    public AttributeNode(int line, AttributeNameNode name, AttributeValueNode value) {
        super(line);
        this.name = name;
        this.value = value;
        addChild(name);
        if (value != null) addChild(value);
    }

    public String getName() { return name.getName(); }
    public String getValue() { return value == null ? null : value.getValue(); }
    public boolean isBoolean() { return value == null; }

    @Override public String label() {
        return isBoolean() ? "Attribute [" + getName() + "]"
                           : "Attribute [" + getName() + "=\"" + getValue() + "\"]";
    }
}
