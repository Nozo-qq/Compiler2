package FlaskStatement;

import java.util.*;

public class ASTPrettyPrinter {

    public static void print(ASTNode root) {
        printNode(root, "", true, 0);
    }

    private static void printNode(ASTNode node, String prefix, boolean isLast, int depth) {
        System.out.print(prefix);

        // connector
        if (depth > 0) {
            // children of root: always └── (كما طلبت)
            if (depth == 1) {
                System.out.print("└── ");
            } else {
                System.out.print(isLast ? "└── " : "├── ");
            }
        }

        // ONLY class name + line
        System.out.println(
                node.getClass().getSimpleName() +
                        " (line " + node.line + ")"
        );

        List<ASTNode> children = getChildrenInOrder(node);

        for (int i = 0; i < children.size(); i++) {
            boolean lastChild = (i == children.size() - 1);

            String childPrefix;
            if (depth == 0) {
                childPrefix = "";
            } else {
                childPrefix = prefix + (isLast ? "    " : "│   ");
            }

            printNode(children.get(i), childPrefix, lastChild, depth + 1);
        }
    }

    // =========================
    // ترتيب الأبناء فقط (بدون labels)
    // =========================
    private static List<ASTNode> getChildrenInOrder(ASTNode node) {
        List<ASTNode> result = new ArrayList<>();

        if (node instanceof Program p) {
            result.addAll(p.statements);
        }
        else if (node instanceof Assignment a) {
            result.add(a.getLeft());
            result.add(a.getRight());
        }
        else if (node instanceof BinaryOperation b) {
            result.add(b.left);
            result.add(b.right);
        }
        else if (node instanceof ReturnStatement r && r.getExpression() != null) {
            result.add(r.getExpression());
        }
        else if (node instanceof FunctionDef f) {
            if (f.getDecorators() != null) {
                for (Decorator d : f.getDecorators()) {
                    result.add(d);
                }
            }
            result.addAll(f.getBody());
        }
        else if (node instanceof FunctionCall c) {
            result.add(c.called);
            result.addAll(c.args);
            result.addAll(c.kwargs.values());
        }
        else if (node instanceof IfStatement i) {
            result.add(i.getConditionExpression());
            result.addAll(i.getBody());
            result.addAll(i.getElseBody());
        }
        else if (node instanceof ForStatement f) {
            result.add(f.getIterableExpression());
            result.addAll(f.getBody());
        }
        else if (node instanceof ListExpr l) {
            result.addAll(l.expressions);
        }
        else if (node instanceof DictExpr d) {
            result.addAll(d.pairs.values());
        }
        else if (node instanceof Attribute a) {
            result.add(a.object);
        }
        else if (node instanceof Subscript s) {
            result.add(s.value);
            result.add(s.index);
        }

        return result;
    }
}
