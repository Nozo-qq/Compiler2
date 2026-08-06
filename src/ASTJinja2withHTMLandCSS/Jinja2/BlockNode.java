package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

public class BlockNode extends ASTNode {
    private final String iterator;
    private final String collection;

    public BlockNode(int line, String iterator, String collection) {
        super(line);
        this.iterator = iterator;
        this.collection = collection;
    }

    public String getIterator() { return iterator; }
    public String getCollection() { return collection; }

    public void addContent(ASTNode content) { addChild(content); }

    @Override public String label() { return "ForBlock {% for " + iterator + " in " + collection + " %}"; }
}
