package ASTJinja2withHTMLandCSS.HTML;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.BaseVisitor;
import ASTJinja2withHTMLandCSS.MYErrorListener;
import ASTJinja2withHTMLandCSS.HTML.Expressions.ExpressionNode;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Splits an unquoted attribute-value string (e.g. "/product/{{ p.id }}") into
 * literal TextNode / ExpressionNode parts. The main grammar's attributeValue
 * rule keeps STRING as one opaque token, so each {{ ... }} span found here is
 * re-lexed/re-parsed on its own via the exprContentOnly start rule.
 */
public final class AttributeValueParser {
    private AttributeValueParser() {}

    public static AttributeValueNode parse(int line, String text, String templatePath, BaseVisitor visitor) {
        AttributeValueNode node = new AttributeValueNode(line);
        StringBuilder literal = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            int start = text.indexOf("{{", i);
            if (start < 0) {
                literal.append(text, i, text.length());
                break;
            }
            literal.append(text, i, start);
            int end = text.indexOf("}}", start + 2);
            if (end < 0) {
                literal.append(text, start, text.length());
                break;
            }
            if (literal.length() > 0) {
                node.addPart(new TextNode(line, literal.toString()));
                literal.setLength(0);
            }
            String fragment = text.substring(start + 2, end).trim();
            ASTNode inner = parseFragment(fragment, templatePath, visitor);
            node.addPart(new ExpressionNode(line, inner));
            i = end + 2;
        }
        if (literal.length() > 0) {
            node.addPart(new TextNode(line, literal.toString()));
        }
        return node;
    }

    private static ASTNode parseFragment(String fragment, String templatePath, BaseVisitor visitor) {
        Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(CharStreams.fromString(fragment));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new MYErrorListener(templatePath + " (attribute expression)"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new MYErrorListener(templatePath + " (attribute expression)"));
        Jinja2withHTMLandCSSParser.ExprContentOnlyContext ctx = parser.exprContentOnly();
        return visitor.visitExprContent(ctx.exprContent());
    }
}
