package FlaskStatement;  // Assuming same package as your other AST nodes

import java.util.List;

public class BinaryOperation extends Expression {
    public  Expression left;
    public  Operator op;
    public Expression right;

    public BinaryOperation(int line ,Expression left, Operator op, Expression right) {
        super(line);
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }


    @Override
    public List<ASTNode> getChildren() {
        return List.of(left, right);
    }


    public enum Operator {
        ADD("+"), SUB("-"), MUL("*"), DIV("/"),
        GT(">"), LT("<"), GTE(">="), LTE("<="),
        EQ("=="), NEQ("!=");

        public String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public static Operator fromToken(String tokenText) {
            return switch (tokenText) {
                case "+"  -> ADD;
                case "-"  -> SUB;
                case "*"  -> MUL;
                case "/"  -> DIV;
                case ">"  -> GT;
                case "<"  -> LT;
                case ">=" -> GTE;
                case "<=" -> LTE;
                case "==" -> EQ;
                case "!=" -> NEQ;
                default   -> throw new IllegalArgumentException("Unknown op: " + tokenText);
            };
        }
    }
}