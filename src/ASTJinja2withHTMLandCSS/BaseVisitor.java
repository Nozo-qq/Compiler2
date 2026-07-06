package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.CSS.*;
import ASTJinja2withHTMLandCSS.CSS.Selectors.*;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParserBaseVisitor;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;

public class BaseVisitor extends Jinja2withHTMLandCSSParserBaseVisitor<ASTNode> {

    public BaseVisitor() {
        // Visitor مخصص لبناء الـ AST فقط - التحليل الدلالي سيكون في مرحلة منفصلة
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
}