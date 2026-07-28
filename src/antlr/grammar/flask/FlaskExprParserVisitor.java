// Generated from C:/Projects/CompilerProject/src/antlr/grammar/flask/FlaskExprParser.g4 by ANTLR 4.13.2
package antlr.grammar.flask;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Import}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport(FlaskExprParser.ImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(FlaskExprParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(FlaskExprParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(FlaskExprParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(FlaskExprParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(FlaskExprParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefstatementment(FlaskExprParser.FunctionDefstatementmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ifstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatementment(FlaskExprParser.IfstatementmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Forstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstatementment(FlaskExprParser.ForstatementmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(FlaskExprParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(FlaskExprParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#forstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstatement(FlaskExprParser.ForstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(FlaskExprParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#importstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportstatement(FlaskExprParser.ImportstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(FlaskExprParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(FlaskExprParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FlaskExprParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskExprParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(FlaskExprParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(FlaskExprParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(FlaskExprParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(FlaskExprParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(FlaskExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(FlaskExprParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLit(FlaskExprParser.FalseLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subscript}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(FlaskExprParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(FlaskExprParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoneLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneLit(FlaskExprParser.NoneLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(FlaskExprParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(FlaskExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FlaskExprParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dict}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict(FlaskExprParser.DictContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLit(FlaskExprParser.TrueLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code List}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(FlaskExprParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(FlaskExprParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(FlaskExprParser.FunctionCallContext ctx);
}