package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.CSS.*;
import ASTJinja2withHTMLandCSS.CSS.Selectors.*;
import ASTJinja2withHTMLandCSS.Jinja2.*;
import ASTJinja2withHTMLandCSS.Jinja2.Factory.*;
import SymbolsTable.SymbolsTable;
import antlr.grammar.Jinja2withHTMLandCSS.Jinja2withHTMLandCSSParserBaseVisitor;
import antlr.grammar.Jinja2withHTMLandCSS.Jinja2withHTMLandCSSParser;
import java.util.*;

public class BaseVisitor extends Jinja2withHTMLandCSSParserBaseVisitor<ASTNode> {
    private final SymbolsTable htmlST = SymbolsTable.getHtmlInstance();
    public List<String> semanticErrors;
    public BaseVisitor() {
        this.semanticErrors = new ArrayList<>();
    }

    @Override
    public ASTNode visitJinja2(Jinja2withHTMLandCSSParser.Jinja2Context ctx) {
        ASTNode root = visit(ctx.jinja2Prog());
        return new ProgramNode(ctx.start.getLine(), root);
    }

    @Override
    public ASTNode visitCss(Jinja2withHTMLandCSSParser.CssContext ctx) {
        ASTNode root = visit(ctx.cssProg());
        return new ProgramNode(ctx.start.getLine(), root);
    }

    @Override
    public ASTNode visitJinja2Prog(Jinja2withHTMLandCSSParser.Jinja2ProgContext ctx) {
        Jinja2ProgNode node = new Jinja2ProgNode(ctx.start.getLine());
        if (ctx.doctype() != null)
            node.setDoctype((DoctypeNode) visit(ctx.doctype()));

        for (var elem : ctx.elementContent())
            node.addElement(visit(elem));

        return node;
    }

    @Override
    public ASTNode visitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx) {
        return new DoctypeNode(ctx.start.getLine());
    }

    @Override
    public ASTNode visitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx) {
        String s=ctx.startTag().tagName().getText();
        String e=ctx.endTag().tagName().getText();
        if (!Objects.equals(s,e)){
            semanticErrors.add("Tag mismatch line: "+ctx.startTag().start.getLine()+" Header: "+"<"+s+">"+" line "+ctx.endTag().start.getLine()+" footer: "+"</"+e+">");
        }
        StartTagNode start = (StartTagNode) visit(ctx.startTag());
        OpenCloseTagNode node = new OpenCloseTagNode(ctx.start.getLine(), start);

        for (var c : ctx.elementContent()) {
            node.addContent(visit(c));
        }

        node.setEndTag((EndTagNode) visit(ctx.endTag()));
        return node;
    }

    @Override
    public ASTNode visitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx) {
        VoidTagNameNode vtag = (VoidTagNameNode) visit(ctx.voidTagName());
        SelfClosingTagNode node = new SelfClosingTagNode(ctx.start.getLine(), vtag);
        checkRequiredAttributes(vtag.getName(), ctx.attribute(), ctx.start.getLine());
        for (var att : ctx.attribute()) {
            AttributeNode attrNode = (AttributeNode) visit(att);
            node.addAttribute(attrNode);

            registerAttributes(attrNode,att.start.getLine());

        }

        return node;
    }

    @Override
    public ASTNode visitStartTag(Jinja2withHTMLandCSSParser.StartTagContext ctx) {
        TagNameNode tn = (TagNameNode) visit(ctx.tagName());
        StartTagNode node = new StartTagNode(ctx.start.getLine(), tn);
        checkRequiredAttributes(tn.getName(), ctx.attribute(), ctx.start.getLine());
        for (var att : ctx.attribute()) {
            AttributeNode attrNode = (AttributeNode) visit(att);
            node.addAttribute(attrNode);

            registerAttributes(attrNode,att.start.getLine());
        }
        return node;
    }

    @Override
    public ASTNode visitEndTag(Jinja2withHTMLandCSSParser.EndTagContext ctx) {
        TagNameNode tn = (TagNameNode) visit(ctx.tagName());
        return new EndTagNode(ctx.start.getLine(), tn);
    }

    @Override
    public ASTNode visitTagName(Jinja2withHTMLandCSSParser.TagNameContext ctx) {
        String name = ctx.getText().toLowerCase();
        return TagFactory.createTag(ctx.start.getLine(), name);
    }

    @Override
    public ASTNode visitVoidTagName(Jinja2withHTMLandCSSParser.VoidTagNameContext ctx) {
        String name = ctx.getText().toLowerCase();
        return TagFactory.createVoidTag(ctx.start.getLine(), name);
    }

    // Labeled Alternatives for attribute
    @Override
    public ASTNode visitFullAttr(Jinja2withHTMLandCSSParser.FullAttrContext ctx) {
        AttributeNameNode name = (AttributeNameNode) visit(ctx.attributeName());
        AttributeValueNode value = (AttributeValueNode) visit(ctx.attributeValue());
        return new AttributeNode(ctx.start.getLine(), name, value);
    }

    @Override
    public ASTNode visitBooleanAttr(Jinja2withHTMLandCSSParser.BooleanAttrContext ctx) {
        AttributeNameNode name = (AttributeNameNode) visit(ctx.attributeName());
        return new AttributeNode(ctx.start.getLine(), name, null);
    }

    @Override
    public ASTNode visitAttributeName(Jinja2withHTMLandCSSParser.AttributeNameContext ctx) {
        String name = ctx.getText().toLowerCase();
        return AttributeFactory.create(ctx.start.getLine(), name);
    }

    @Override
    public ASTNode visitAttributeValue(Jinja2withHTMLandCSSParser.AttributeValueContext ctx) {
        String raw = ctx.getText();
        String val = raw.replaceAll("^[\"']|[\"']$", "");
        return new AttributeValueNode(ctx.start.getLine(), val);
    }

    // Labeled Alternatives for elementContent
    @Override
    public ASTNode visitTextContent(Jinja2withHTMLandCSSParser.TextContentContext ctx) {
        return visit(ctx.statement());
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
    public ASTNode visitStatement(Jinja2withHTMLandCSSParser.StatementContext ctx) {
        return new StatementNode(ctx.start.getLine(), ctx.getText());
    }

    @Override
    public ASTNode visitExpression(Jinja2withHTMLandCSSParser.ExpressionContext ctx) {
        MemberAccessNode m = (MemberAccessNode) visit(ctx.memberAccess());
        return new ExpressionNode(ctx.start.getLine(), m);
    }

    @Override
    public ASTNode visitMemberAccess(Jinja2withHTMLandCSSParser.MemberAccessContext ctx) {
        String baseVar = ctx.anyId(0).getText();
        Map<String, Object> dataSent = (Map<String, Object>) htmlST.getHtmlSymbol("data_sent");

        // Check if base exists (either in data_sent or as a local iterator)
        boolean existsGlobally = dataSent != null && dataSent.containsKey(baseVar);
        boolean existsLocally = htmlST.getHtmlSymbol(baseVar) != null;

        if (!existsGlobally && !existsLocally) {
            semanticErrors.add("Line " + ctx.start.getLine() + ": Variable '" + baseVar + "' is undefined.");

        }
        // Advanced: If base is found and there are nested parts (e.g., pr.price)
        if (existsGlobally && ctx.anyId().size() > 1) {
            // You could reflectively check if the object in dataSent has the subsequent keys
            // This is where you'd catch 'pr.Price' vs 'pr.price' errors
        }

        MemberAccessNode node = new MemberAccessNode(ctx.start.getLine());
        for (var id : ctx.anyId()) node.addPart(id.getText());
        return node;
    }
    @Override
    public ASTNode visitJinjaStatement(Jinja2withHTMLandCSSParser.JinjaStatementContext ctx) {
        // We want to capture the specific instruction inside the {% %}
        // Example: "{% set x = 10 %}" -> captures "set x = 10"

        StringBuilder sb = new StringBuilder();

        // Iterate through children starting after BLOCK_START and before BLOCK_END
        for (int i = 1; i < ctx.getChildCount() - 1; i++) {
            sb.append(ctx.getChild(i).getText()).append(" ");
        }

        String statementText = sb.toString().trim();

        // Optional: Add semantic check for 'set' to register variables in Symbol Table
        if (statementText.startsWith("set")) {
            String[] parts = statementText.split("\\s+");
            if (parts.length > 1) {
                String varName = parts[1]; // The 'x' in 'set x = 10'
                Map<String, Object> details = new LinkedHashMap<>();
                details.put("type", "jinja_var");
                details.put("line", ctx.start.getLine());
                htmlST.addHtmlSymbol(varName, details);
            }
        }

        return new JinjaStatementNode(ctx.start.getLine(), statementText);
    }

    @Override
    public ASTNode visitBlock(Jinja2withHTMLandCSSParser.BlockContext ctx) {
        String iterator = ctx.anyId(0).getText();
        String collection = ctx.anyId(1).getText();
        // Check for Shadowing
        if (htmlST.getHtmlSymbol(iterator) != null) {
            semanticErrors.add("Line " + ctx.start.getLine() + ": Warning: Iterator '" + iterator + "' shadows an existing variable.");
        }

        Map<String, Object> dataSent = (Map<String, Object>) htmlST.getHtmlSymbol("data_sent");
        if (dataSent == null || !dataSent.containsKey(collection)) {
            semanticErrors.add("Line " + ctx.start.getLine() + ": Collection '" + collection + "' not found.");
        }

        Map<String, Object> localDetails = new LinkedHashMap<>();
        localDetails.put("type", "iterator");
        localDetails.put("parent_collection", collection);
        htmlST.addHtmlSymbol(iterator, localDetails);

        BlockNode block = new BlockNode(ctx.start.getLine(), iterator, collection);
        for (var c : ctx.elementContent()){
            block.addContent(visit(c));
        }

        htmlST.removehtmlkey(iterator);
        return block;
    }
    private void registerAttributes(AttributeNode attrNode, int line) {
        String attrName = attrNode.getName().toLowerCase().trim();
        String attrValue = attrNode.getValue();

        if (attrValue != null) {
            if (attrName.equals("id")) {
                if (htmlST.getHtmlSymbol(attrValue) != null) {
                    semanticErrors.add("Line " + line + ": Duplicate ID '" + attrValue + "' detected.");
                } else {
                    Map<String, Object> details = new LinkedHashMap<>();
                    details.put("type", "id");
                    details.put("line", line);
                    htmlST.addHtmlSymbol(attrValue, details);
                }
            } else if (attrName.equals("class")) {
                String[] classes = attrValue.split("\\s+");
                for (String className : classes) {
                    if (!className.isEmpty()) {
                        Map<String, Object> details = new LinkedHashMap<>();
                        details.put("type", "class");
                        details.put("line", line);
                        htmlST.addHtmlSymbol(className, details);
                    }
                }
            }
        }
    }
    private void checkRequiredAttributes(String tagName, List<Jinja2withHTMLandCSSParser.AttributeContext> attributes, int line) {
        // Extract names directly from the context text
        List<String> attrNames = new ArrayList<>();
        for (var attrCtx : attributes) {
            // This assumes your attribute grammar has an attributeName rule
            attrNames.add(attrCtx.getText().split("=")[0].toLowerCase().trim());
        }

        if (tagName.equals("img") && !attrNames.contains("src")) {
            semanticErrors.add("Line " + line + ": Missing 'src' for <img> tag.");
        }
        if (tagName.equals("a") && !attrNames.contains("href")) {
            semanticErrors.add("Line " + line + ": Missing 'href' for <a> tag.");
        }
    }
// ===== CSS =====

    @Override
    public ASTNode visitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx) {
        CSSProgNode prog = new CSSProgNode(ctx.start.getLine());
        for (var r : ctx.cssRule())
            prog.addRule((CSSRuleNode) visit(r));
        return prog;
    }

    @Override
    public ASTNode visitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx) {
        SelectorListNode selectors = (SelectorListNode) visit(ctx.cssSelectorList());
        CSSRuleNode rule = new CSSRuleNode(ctx.start.getLine(), selectors);

        for (var d : ctx.cssDeclaration())
            rule.addDeclaration((CSSDeclarationNode) visit(d));

        return rule;
    }

    @Override
    public ASTNode visitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx) {
        SelectorListNode list = new SelectorListNode(ctx.start.getLine());
        for (var s : ctx.cssSelector())
            list.addSelector((SelectorChainNode) visit(s));
        return list;
    }

    @Override
    public ASTNode visitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx) {
        SelectorChainNode chain = new SelectorChainNode(ctx.start.getLine());

        for (var s : ctx.simpleSelector()) {
            chain.addPart((CSSSelectorNode) visit(s));
        }

        // التقاط الفئات الوهمية (الهوفر) وتخزينه في الشجرة
        if (ctx.COLON() != null && ctx.anyId() != null) {
            chain.setPseudoClass(ctx.anyId().getText());
        }

        return chain;
    }

    // --- زيارة المحددات البسيطة ---

    @Override
    public ASTNode visitElementSelector(Jinja2withHTMLandCSSParser.ElementSelectorContext ctx) {
        // استخدمنا anyId مباشرة كما عرفناها في الـ Grammar الجديد
        return new ElementSelectorNode(ctx.start.getLine(), ctx.anyId().getText());
    }

    @Override
    public ASTNode visitClassSelector(Jinja2withHTMLandCSSParser.ClassSelectorContext ctx) {
        String className = ctx.anyId().getText(); // جلبنا الاسم مباشرة

        // التحليل الدلالي (الذي كتبه زملاؤك) - سنبقيه لأنه ممتاز!
        if (htmlST.getHtmlSymbol(className) == null) {
            semanticErrors.add("Line " + ctx.start.getLine() + " Warning: CSS class ." + className + " is defined but never used in HTML.");
        }

        return new ClassSelectorNode(ctx.start.getLine(), className);
    }

    @Override
    public ASTNode visitIdSelector(Jinja2withHTMLandCSSParser.IdSelectorContext ctx) {
        String idName = ctx.anyId().getText(); // جلبنا الاسم مباشرة

        // التحليل الدلالي
        if (htmlST.getHtmlSymbol(idName) == null) {
            semanticErrors.add("Line " + ctx.start.getLine() + " Warning: CSS ID #" + idName + " has no matching element in HTML.");
        }

        return new IdSelectorNode(ctx.start.getLine(), idName);
    }

    // --- زيارة الخاصية ---

    @Override
    public ASTNode visitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx) {
        String propName = ctx.anyId().getText().toLowerCase(); // جلب اسم الخاصية
        String valueText = ctx.cssValue().getText().toLowerCase(); // جلب القيمة كنص كامل!

        // --- التحليل الدلالي (Semantic Check) للخصائص ---
        // بما أننا حولنا القيمة لنص، صار البحث أسهل بكثير من الـ Atoms
        if ((propName.equals("color") || propName.contains("background-color"))
                && !valueText.startsWith("#") && !valueText.matches("^[a-z]+$")) {
            semanticErrors.add("Line " + ctx.start.getLine() + ": CSS Property '" + propName + "' expects a valid color.");
        }

        if ((propName.equals("width") || propName.equals("height"))
                && !valueText.matches(".*\\d.*") && !valueText.contains("auto") && !valueText.contains("inherit")) {
            semanticErrors.add("Line " + ctx.start.getLine() + ": CSS Property '" + propName + "' expects a numeric value.");
        }

        // إنشاء العقدة باستخدام التصميم النظيف الجديد
        return new CSSDeclarationNode(ctx.start.getLine(), propName, valueText);
    }

    // ❌ تم حذف كل توابع visitCssValue و visitCssNumber وغيرها لأننا لم نعد نحتاجها!
}