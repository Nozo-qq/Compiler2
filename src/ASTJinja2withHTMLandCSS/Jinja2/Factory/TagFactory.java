package ASTJinja2withHTMLandCSS.Jinja2.Factory;

import ASTJinja2withHTMLandCSS.Jinja2.TagNameNode;
import ASTJinja2withHTMLandCSS.Jinja2.VoidTagNameNode;

public class TagFactory {
    public static TagNameNode createTag(int line, String name) {
        return new TagNameNode(line, name);
    }
    public static VoidTagNameNode createVoidTag(int line, String name) {
        return new VoidTagNameNode(line, name);
    }
}
