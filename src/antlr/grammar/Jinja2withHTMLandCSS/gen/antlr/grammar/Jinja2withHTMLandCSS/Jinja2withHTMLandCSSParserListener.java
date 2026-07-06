// Generated from D:/Nozo/Projects/Compiler2/src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Jinja2withHTMLandCSSParser}.
 */
public interface Jinja2withHTMLandCSSParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code jinja2}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterJinja2(Jinja2withHTMLandCSSParser.Jinja2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitJinja2(Jinja2withHTMLandCSSParser.Jinja2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code css}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterCss(Jinja2withHTMLandCSSParser.CssContext ctx);
	/**
	 * Exit a parse tree produced by the {@code css}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitCss(Jinja2withHTMLandCSSParser.CssContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#anyId}.
	 * @param ctx the parse tree
	 */
	void enterAnyId(Jinja2withHTMLandCSSParser.AnyIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#anyId}.
	 * @param ctx the parse tree
	 */
	void exitAnyId(Jinja2withHTMLandCSSParser.AnyIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinja2Prog}.
	 * @param ctx the parse tree
	 */
	void enterJinja2Prog(Jinja2withHTMLandCSSParser.Jinja2ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinja2Prog}.
	 * @param ctx the parse tree
	 */
	void exitJinja2Prog(Jinja2withHTMLandCSSParser.Jinja2ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#doctype}.
	 * @param ctx the parse tree
	 */
	void enterDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#doctype}.
	 * @param ctx the parse tree
	 */
	void exitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code openCloseTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlelement}.
	 * @param ctx the parse tree
	 */
	void enterOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code openCloseTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlelement}.
	 * @param ctx the parse tree
	 */
	void exitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfClosingTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlelement}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfClosingTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlelement}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#startTag}.
	 * @param ctx the parse tree
	 */
	void enterStartTag(Jinja2withHTMLandCSSParser.StartTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#startTag}.
	 * @param ctx the parse tree
	 */
	void exitStartTag(Jinja2withHTMLandCSSParser.StartTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterEndTag(Jinja2withHTMLandCSSParser.EndTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitEndTag(Jinja2withHTMLandCSSParser.EndTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullAttr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterFullAttr(Jinja2withHTMLandCSSParser.FullAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullAttr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitFullAttr(Jinja2withHTMLandCSSParser.FullAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAttr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAttr(Jinja2withHTMLandCSSParser.BooleanAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAttr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAttr(Jinja2withHTMLandCSSParser.BooleanAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(Jinja2withHTMLandCSSParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(Jinja2withHTMLandCSSParser.AttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedElement}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void enterNestedElement(Jinja2withHTMLandCSSParser.NestedElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedElement}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void exitNestedElement(Jinja2withHTMLandCSSParser.NestedElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaExpression}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaExpression}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaBlock}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaBlock}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textContent}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void enterTextContent(Jinja2withHTMLandCSSParser.TextContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textContent}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 */
	void exitTextContent(Jinja2withHTMLandCSSParser.TextContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Jinja2withHTMLandCSSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Jinja2withHTMLandCSSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Jinja2withHTMLandCSSParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Jinja2withHTMLandCSSParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(Jinja2withHTMLandCSSParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(Jinja2withHTMLandCSSParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Jinja2withHTMLandCSSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Jinja2withHTMLandCSSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssProg}.
	 * @param ctx the parse tree
	 */
	void enterCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssProg}.
	 * @param ctx the parse tree
	 */
	void exitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelectorList}.
	 * @param ctx the parse tree
	 */
	void enterCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelectorList}.
	 * @param ctx the parse tree
	 */
	void exitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElementSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterElementSelector(Jinja2withHTMLandCSSParser.ElementSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElementSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitElementSelector(Jinja2withHTMLandCSSParser.ElementSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterClassSelector(Jinja2withHTMLandCSSParser.ClassSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitClassSelector(Jinja2withHTMLandCSSParser.ClassSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterIdSelector(Jinja2withHTMLandCSSParser.IdSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitIdSelector(Jinja2withHTMLandCSSParser.IdSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValue(Jinja2withHTMLandCSSParser.CssValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValue(Jinja2withHTMLandCSSParser.CssValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssNumber}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssNumber(Jinja2withHTMLandCSSParser.CssNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssNumber}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssNumber(Jinja2withHTMLandCSSParser.CssNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssUnit}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssUnit(Jinja2withHTMLandCSSParser.CssUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssUnit}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssUnit(Jinja2withHTMLandCSSParser.CssUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssColor}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssColor}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssIdentifier}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssIdentifier(Jinja2withHTMLandCSSParser.CssIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssIdentifier}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssIdentifier(Jinja2withHTMLandCSSParser.CssIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssComma}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssComma}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssMinus}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssMinus(Jinja2withHTMLandCSSParser.CssMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssMinus}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssMinus(Jinja2withHTMLandCSSParser.CssMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssString}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssString}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssLParen}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssLParen(Jinja2withHTMLandCSSParser.CssLParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssLParen}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssLParen(Jinja2withHTMLandCSSParser.CssLParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssRParen}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void enterCssRParen(Jinja2withHTMLandCSSParser.CssRParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssRParen}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 */
	void exitCssRParen(Jinja2withHTMLandCSSParser.CssRParenContext ctx);
}