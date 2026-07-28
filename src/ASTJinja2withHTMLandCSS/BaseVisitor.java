package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.CSS.*;
import ASTJinja2withHTMLandCSS.CSS.Selectors.*;
import ASTJinja2withHTMLandCSS.HTML.*;
import ASTJinja2withHTMLandCSS.HTML.Expressions.*;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParserBaseVisitor;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.misc.Interval;

import java.util.ArrayList;
import java.util.List;

public class BaseVisitor extends Jinja2withHTMLandCSSParserBaseVisitor<ASTNode> {

    private final String templatePath;

    public BaseVisitor() {
        this("template");
        // Visitor مخصص لبناء الـ AST فقط - التحليل الدلالي سيكون في مرحلة منفصلة
    }

    public BaseVisitor(String templatePath) {
        this.templatePath = templatePath;
    }

    @Override
    public ASTNode visitCss(Jinja2withHTMLandCSSParser.CssContext ctx) {
        ASTNode root = visit(ctx.cssProg());
        return new ProgramNode(ctx.start.getLine(), root);
    }

    @Override
    public ASTNode visitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx) {
        CSSProgNode prog = new CSSProgNode(ctx.start.getLine());
        for (var r : ctx.cssRule()) {
            prog.addRule((CSSRuleNode) visit(r));
        }
        return prog;
    }

    @Override
    public ASTNode visitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx) {
        SelectorListNode selectors = (SelectorListNode) visit(ctx.cssSelectorList());
        CSSRuleNode rule = new CSSRuleNode(ctx.start.getLine(), selectors);

        for (var d : ctx.cssDeclaration()) {
            rule.addDeclaration((CSSDeclarationNode) visit(d));
        }
        return rule;
    }

    @Override
    public ASTNode visitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx) {
        SelectorListNode list = new SelectorListNode(ctx.start.getLine());
        for (var s : ctx.cssSelector()) {
            list.addSelector((SelectorChainNode) visit(s));
        }
        return list;
    }

    @Override
    public ASTNode visitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx) {
        SelectorChainNode chain = new SelectorChainNode(ctx.start.getLine());

        for (var s : ctx.simpleSelector()) {
            chain.addPart((CSSSelectorNode) visit(s));
        }

        // دعم الفئات الوهمية (Pseudo-classes)
        if (ctx.COLON() != null && ctx.anyId() != null) {
            String pseudoClass = ":" + ctx.anyId().getText();
            chain.addPart(new ElementSelectorNode(ctx.COLON().getSymbol().getLine(), pseudoClass));
        }

        return chain;
    }

    // --- زيارة المحددات البسيطة ---

    @Override
    public ASTNode visitElementSelector(Jinja2withHTMLandCSSParser.ElementSelectorContext ctx) {
        return new ElementSelectorNode(ctx.start.getLine(), ctx.anyId().getText());
    }

    @Override
    public ASTNode visitClassSelector(Jinja2withHTMLandCSSParser.ClassSelectorContext ctx) {
        return new ClassSelectorNode(ctx.start.getLine(), ctx.anyId().getText());
    }

    @Override
    public ASTNode visitIdSelector(Jinja2withHTMLandCSSParser.IdSelectorContext ctx) {
        return new IdSelectorNode(ctx.start.getLine(), ctx.anyId().getText());
    }

    // --- زيارة الخاصية والتصريح ---

    @Override
    public ASTNode visitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx) {
        String propName = ctx.anyId().getText().toLowerCase();
        String valueText = ctx.cssValue().getText().toLowerCase(); // القيمة كنص كامل كما في هيكليتك

        // إنشاء العقدة باستخدام الهيكلية الخاصة بك
        return new CSSDeclarationNode(ctx.start.getLine(), propName, valueText);
    }

    // ================= JINJA2 & HTML =================

    @Override
    public ASTNode visitJinja2(Jinja2withHTMLandCSSParser.Jinja2Context ctx) {
        ASTNode root = visit(ctx.jinja2Prog());
        return new ProgramNode(ctx.start.getLine(), root);
    }

    @Override
    public ASTNode visitJinja2Prog(Jinja2withHTMLandCSSParser.Jinja2ProgContext ctx) {
        DoctypeNode doctype = ctx.doctype() != null ? (DoctypeNode) visit(ctx.doctype()) : null;
        HtmlDocumentNode doc = new HtmlDocumentNode(ctx.start.getLine(), doctype);
        for (ASTNode child : visitElementContentList(ctx.elementContent())) {
            doc.addContent(child);
        }
        return doc;
    }

    @Override
    public ASTNode visitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx) {
        String keyword = ctx.anyId(0).getText();
        String value = ctx.anyId(1).getText();
        return new DoctypeNode(ctx.start.getLine(), keyword, value);
    }

    @Override
    public ASTNode visitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx) {
        HtmlElementNode element = new HtmlElementNode(ctx.start.getLine(), ctx.anyId().getText(), false);
        for (Jinja2withHTMLandCSSParser.AttributeContext attrCtx : ctx.attribute()) {
            element.addAttribute((AttributeNode) visit(attrCtx));
        }
        for (ASTNode child : visitElementContentList(ctx.elementContent())) {
            element.addChild(child);
        }
        return element;
    }

    @Override
    public ASTNode visitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx) {
        HtmlElementNode element = new HtmlElementNode(ctx.start.getLine(), ctx.anyId().getText(), true);
        for (Jinja2withHTMLandCSSParser.AttributeContext attrCtx : ctx.attribute()) {
            element.addAttribute((AttributeNode) visit(attrCtx));
        }
        return element;
    }

    @Override
    public ASTNode visitFullAttr(Jinja2withHTMLandCSSParser.FullAttrContext ctx) {
        String name = ctx.anyId().getText();
        String rawWithQuotes = ctx.attributeValue().STRING().getText();
        String unquoted = rawWithQuotes.substring(1, rawWithQuotes.length() - 1);
        AttributeValueNode value = AttributeValueParser.parse(
                ctx.attributeValue().start.getLine(), unquoted, templatePath, this);
        return new AttributeNode(ctx.start.getLine(), name, value, false);
    }

    @Override
    public ASTNode visitBooleanAttr(Jinja2withHTMLandCSSParser.BooleanAttrContext ctx) {
        return new AttributeNode(ctx.start.getLine(), ctx.anyId().getText(), null, true);
    }

    @Override
    public ASTNode visitNestedElement(Jinja2withHTMLandCSSParser.NestedElementContext ctx) {
        return visit(ctx.htmlelement());
    }

    @Override
    public ASTNode visitJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public ASTNode visitJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public ASTNode visitTextContent(Jinja2withHTMLandCSSParser.TextContentContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public ASTNode visitStatement(Jinja2withHTMLandCSSParser.StatementContext ctx) {
        // WS is skipped by the lexer, so ctx.getText() would concatenate token
        // texts with no separator ("+ Add Product" -> "+AddProduct"). Pull the
        // literal source slice instead so internal spacing survives.
        String text = ctx.start.getInputStream().getText(
                Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
        return new TextNode(ctx.start.getLine(), text);
    }

    @Override
    public ASTNode visitExpression(Jinja2withHTMLandCSSParser.ExpressionContext ctx) {
        ASTNode inner = visit(ctx.exprContent());
        return new ExpressionNode(ctx.start.getLine(), inner);
    }

    @Override
    public ASTNode visitExprContent(Jinja2withHTMLandCSSParser.ExprContentContext ctx) {
        MemberAccessNode callee = (MemberAccessNode) visit(ctx.memberAccess());
        if (ctx.LPAREN() == null) {
            return callee;
        }
        FunctionCallNode call = new FunctionCallNode(ctx.start.getLine(), callee);
        if (ctx.argList() != null) {
            for (Jinja2withHTMLandCSSParser.ArgItemContext argCtx : ctx.argList().argItem()) {
                call.addArgument((ArgumentNode) visit(argCtx));
            }
        }
        return call;
    }

    @Override
    public ASTNode visitExprContentOnly(Jinja2withHTMLandCSSParser.ExprContentOnlyContext ctx) {
        return visit(ctx.exprContent());
    }

    @Override
    public ASTNode visitArgItem(Jinja2withHTMLandCSSParser.ArgItemContext ctx) {
        String name = ctx.anyId() != null ? ctx.anyId().getText() : null;
        ASTNode value = visit(ctx.argValue());
        return new ArgumentNode(ctx.start.getLine(), name, value);
    }

    @Override
    public ASTNode visitArgValue(Jinja2withHTMLandCSSParser.ArgValueContext ctx) {
        if (ctx.STRING() != null) {
            String raw = ctx.STRING().getText();
            String unquoted = raw.substring(1, raw.length() - 1);
            return new LiteralNode(ctx.start.getLine(), unquoted, raw);
        }
        if (ctx.NUMBER() != null) {
            String raw = ctx.NUMBER().getText();
            Object value = raw.contains(".") ? (Object) Double.parseDouble(raw) : (Object) Long.parseLong(raw);
            return new LiteralNode(ctx.start.getLine(), value, raw);
        }
        return visit(ctx.memberAccess());
    }

    @Override
    public ASTNode visitMemberAccess(Jinja2withHTMLandCSSParser.MemberAccessContext ctx) {
        List<String> path = new ArrayList<>();
        for (Jinja2withHTMLandCSSParser.AnyIdContext id : ctx.anyId()) {
            path.add(id.getText());
        }
        return new MemberAccessNode(ctx.start.getLine(), path);
    }

    @Override
    public ASTNode visitBlock(Jinja2withHTMLandCSSParser.BlockContext ctx) {
        String loopVar = ctx.anyId(0).getText();
        String iterableName = ctx.anyId(1).getText();
        ForNode forNode = new ForNode(ctx.start.getLine(), loopVar, iterableName);
        for (ASTNode child : visitElementContentList(ctx.elementContent())) {
            forNode.addBodyItem(child);
        }
        return forNode;
    }

    // Between sibling elementContent nodes, WS is skipped by the lexer, so e.g.
    // "$ {{ p.price }}" would lose the space between the two children if their
    // rendered output were simply concatenated. Insert a synthetic space TextNode
    // wherever there's a source-character gap between consecutive children.
    private List<ASTNode> visitElementContentList(List<Jinja2withHTMLandCSSParser.ElementContentContext> items) {
        List<ASTNode> result = new ArrayList<>();
        Jinja2withHTMLandCSSParser.ElementContentContext prev = null;
        for (Jinja2withHTMLandCSSParser.ElementContentContext item : items) {
            if (prev != null && item.start.getStartIndex() > prev.stop.getStopIndex() + 1) {
                result.add(new TextNode(item.start.getLine(), " "));
            }
            ASTNode node = visit(item);
            if (node != null) {
                result.add(node);
            }
            prev = item;
        }
        return result;
    }
}