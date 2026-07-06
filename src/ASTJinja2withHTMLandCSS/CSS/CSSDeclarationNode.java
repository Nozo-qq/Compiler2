package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class CSSDeclarationNode extends ASTNode {
    private String property;
    private String value;

    // الباني (Constructor) المحدث ليستقبل 3 وسطاء
    public CSSDeclarationNode(int line, String property, String value) {
        super("CSSDeclarationNode", line);
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    // هذا التابع الذي سيستخدمه الـ ASTPrinter لطباعة العقدة بشكل جميل
    @Override
    public String getNodeValue() {
        return "Property: " + property + " | Value: " + value;
    }

    // التصريح (Declaration) هو عقدة ورقية (Leaf Node) في شجرتنا، لذا ليس لها أبناء
    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}