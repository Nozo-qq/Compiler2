// Generated from C:/Projects/CompilerProject/src/antlr/grammar/flask/FlaskExprParser.g4 by ANTLR 4.13.2
package antlr.grammar.flask;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskExprParser}.
 */
public interface FlaskExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImport(FlaskExprParser.ImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImport(FlaskExprParser.ImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(FlaskExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(FlaskExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn(FlaskExprParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn(FlaskExprParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(FlaskExprParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(FlaskExprParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Break}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak(FlaskExprParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak(FlaskExprParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue(FlaskExprParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Continue}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue(FlaskExprParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefstatementment(FlaskExprParser.FunctionDefstatementmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefstatementment(FlaskExprParser.FunctionDefstatementmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ifstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatementment(FlaskExprParser.IfstatementmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ifstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatementment(FlaskExprParser.IfstatementmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Forstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForstatementment(FlaskExprParser.ForstatementmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Forstatementment}
	 * labeled alternative in {@link FlaskExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForstatementment(FlaskExprParser.ForstatementmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(FlaskExprParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(FlaskExprParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(FlaskExprParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(FlaskExprParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void enterForstatement(FlaskExprParser.ForstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void exitForstatement(FlaskExprParser.ForstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(FlaskExprParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(FlaskExprParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#importstatement}.
	 * @param ctx the parse tree
	 */
	void enterImportstatement(FlaskExprParser.ImportstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#importstatement}.
	 * @param ctx the parse tree
	 */
	void exitImportstatement(FlaskExprParser.ImportstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(FlaskExprParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(FlaskExprParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(FlaskExprParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(FlaskExprParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FlaskExprParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FlaskExprParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskExprParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(FlaskExprParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskExprParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(FlaskExprParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(FlaskExprParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(FlaskExprParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(FlaskExprParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(FlaskExprParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(FlaskExprParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(FlaskExprParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(FlaskExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(FlaskExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(FlaskExprParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(FlaskExprParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseLit(FlaskExprParser.FalseLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseLit(FlaskExprParser.FalseLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subscript}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(FlaskExprParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subscript}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(FlaskExprParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(FlaskExprParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(FlaskExprParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNoneLit(FlaskExprParser.NoneLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNoneLit(FlaskExprParser.NoneLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(FlaskExprParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(FlaskExprParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(FlaskExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(FlaskExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(FlaskExprParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(FlaskExprParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dict}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDict(FlaskExprParser.DictContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dict}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDict(FlaskExprParser.DictContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueLit(FlaskExprParser.TrueLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueLit(FlaskExprParser.TrueLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code List}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterList(FlaskExprParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code List}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitList(FlaskExprParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(FlaskExprParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(FlaskExprParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(FlaskExprParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link FlaskExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(FlaskExprParser.FunctionCallContext ctx);
}