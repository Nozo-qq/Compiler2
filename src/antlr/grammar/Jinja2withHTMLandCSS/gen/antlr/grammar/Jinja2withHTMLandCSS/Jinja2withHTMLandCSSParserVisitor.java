// Generated from D:/Nozo/Projects/Compiler2/src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Jinja2withHTMLandCSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Jinja2withHTMLandCSSParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code jinja2}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2(Jinja2withHTMLandCSSParser.Jinja2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code css}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCss(Jinja2withHTMLandCSSParser.CssContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#anyId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyId(Jinja2withHTMLandCSSParser.AnyIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinja2Prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2Prog(Jinja2withHTMLandCSSParser.Jinja2ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#doctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code openCloseTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfClosingTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#startTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTag(Jinja2withHTMLandCSSParser.StartTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(Jinja2withHTMLandCSSParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullAttr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullAttr(Jinja2withHTMLandCSSParser.FullAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAttr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAttr(Jinja2withHTMLandCSSParser.BooleanAttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeValue(Jinja2withHTMLandCSSParser.AttributeValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nestedElement}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedElement(Jinja2withHTMLandCSSParser.NestedElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaExpression}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaBlock}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textContent}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#elementContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextContent(Jinja2withHTMLandCSSParser.TextContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Jinja2withHTMLandCSSParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Jinja2withHTMLandCSSParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#memberAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(Jinja2withHTMLandCSSParser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Jinja2withHTMLandCSSParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssProg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelectorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSelector(Jinja2withHTMLandCSSParser.ElementSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassSelector(Jinja2withHTMLandCSSParser.ClassSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSelector(Jinja2withHTMLandCSSParser.IdSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(Jinja2withHTMLandCSSParser.CssValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssNumber}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssNumber(Jinja2withHTMLandCSSParser.CssNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssUnit}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssUnit(Jinja2withHTMLandCSSParser.CssUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssColor}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssIdentifier}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssIdentifier(Jinja2withHTMLandCSSParser.CssIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssComma}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssMinus}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssMinus(Jinja2withHTMLandCSSParser.CssMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssString}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssLParen}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssLParen(Jinja2withHTMLandCSSParser.CssLParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssRParen}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRParen(Jinja2withHTMLandCSSParser.CssRParenContext ctx);
}