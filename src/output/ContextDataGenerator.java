package output;

import FlaskStatement.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Walks a Flask AST and extracts the data actually handed to render_template()
 * calls, keyed by template name, instead of translating the program into a
 * runnable target language. This is the "Context Data" the Jinja/HTML stage
 * of the overall project consumes.
 */
public class ContextDataGenerator {

    private final Map<String, Object> staticAssignments = new LinkedHashMap<>();
    private final LinkedHashMap<String, LinkedHashMap<String, Object>> templateContexts = new LinkedHashMap<>();
    private final StringBuilder log = new StringBuilder();

    private int templatesFound = 0;
    private int resolvedKwargCount = 0;
    private int skippedKwargCount = 0;
    private int collisionCount = 0;

    public LinkedHashMap<String, Object> generate(List<Statement> programStatements) {
        collectTopLevelStaticAssignments(programStatements);

        for (Statement stmt : programStatements) {
            if (stmt instanceof FunctionDef fn) {
                List<FunctionCall> calls = new ArrayList<>();
                findFunctionCalls(fn.getBody(), calls);
                for (FunctionCall call : calls) {
                    if (isRenderTemplateCall(call)) {
                        handleRenderTemplateCall(call, fn.getName());
                    }
                }
            }
        }

        appendSummary();
        return new LinkedHashMap<>(templateContexts);
    }

    public String getLogText() {
        return log.toString();
    }

    private void collectTopLevelStaticAssignments(List<Statement> statements) {
        for (Statement stmt : statements) {
            if (stmt instanceof Assignment assign && assign.getLeft() instanceof Name n) {
                try {
                    Object value = StaticValueResolver.evaluate(assign.getRight(), staticAssignments);
                    staticAssignments.put(n.id, value);
                } catch (StaticValueResolver.UnresolvableException e) {
                    log.append("info: top-level assignment '").append(n.id)
                            .append("' skipped (not statically resolvable: ").append(e.nodeDescription).append(")\n");
                }
            }
        }
    }

    private void findFunctionCalls(List<Statement> body, List<FunctionCall> out) {
        if (body == null) return;
        for (Statement stmt : body) {
            if (stmt instanceof Assignment assign) {
                collectExpressionCalls(assign.getLeft(), out);
                collectExpressionCalls(assign.getRight(), out);
            } else if (stmt instanceof ExpressionStatement exprStmt) {
                collectExpressionCalls(exprStmt.getExpression(), out);
            } else if (stmt instanceof ReturnStatement ret) {
                if (ret.getExpression() != null) collectExpressionCalls(ret.getExpression(), out);
            } else if (stmt instanceof IfStatement ifStmt) {
                collectExpressionCalls(ifStmt.getConditionExpression(), out);
                findFunctionCalls(ifStmt.getBody(), out);
                findFunctionCalls(ifStmt.getElseBody(), out);
            } else if (stmt instanceof ForStatement forStmt) {
                collectExpressionCalls(forStmt.getIterableExpression(), out);
                findFunctionCalls(forStmt.getBody(), out);
            } else if (stmt instanceof FunctionDef nestedFn) {
                findFunctionCalls(nestedFn.getBody(), out);
            }
        }
    }

    private void collectExpressionCalls(Expression expr, List<FunctionCall> out) {
        if (expr == null) return;
        if (expr instanceof FunctionCall call) {
            out.add(call);
            collectExpressionCalls(call.called, out);
            for (Expression arg : call.args) collectExpressionCalls(arg, out);
            for (Expression kwarg : call.kwargs.values()) collectExpressionCalls(kwarg, out);
        } else if (expr instanceof BinaryOperation binOp) {
            collectExpressionCalls(binOp.left, out);
            collectExpressionCalls(binOp.right, out);
        } else if (expr instanceof Attribute attr) {
            collectExpressionCalls(attr.object, out);
        } else if (expr instanceof Subscript sub) {
            collectExpressionCalls(sub.value, out);
            collectExpressionCalls(sub.index, out);
        } else if (expr instanceof ListExpr le) {
            for (Expression e : le.expressions) collectExpressionCalls(e, out);
        } else if (expr instanceof DictExpr de) {
            for (Expression e : de.pairs.values()) collectExpressionCalls(e, out);
        }
    }

    private boolean isRenderTemplateCall(FunctionCall call) {
        return call.called instanceof Name n && "render_template".equals(n.id);
    }

    private void handleRenderTemplateCall(FunctionCall call, String enclosingFnName) {
        if (call.args.isEmpty()) {
            log.append("warning: render_template call in function '").append(enclosingFnName)
                    .append("' at line ").append(call.line).append(" — no template name argument, skipped\n");
            return;
        }

        Object templateNameValue;
        try {
            templateNameValue = StaticValueResolver.evaluate(call.args.get(0), staticAssignments);
        } catch (StaticValueResolver.UnresolvableException e) {
            log.append("warning: render_template call in function '").append(enclosingFnName)
                    .append("' at line ").append(call.line)
                    .append(" — template name not a static string (").append(e.nodeDescription).append("), skipped\n");
            return;
        }

        if (!(templateNameValue instanceof String templateName)) {
            log.append("warning: render_template call in function '").append(enclosingFnName)
                    .append("' at line ").append(call.line).append(" — template name did not resolve to a string, skipped\n");
            return;
        }

        templatesFound++;
        LinkedHashMap<String, Object> context = templateContexts.computeIfAbsent(templateName, k -> new LinkedHashMap<>());

        for (Map.Entry<String, Expression> kwarg : call.kwargs.entrySet()) {
            String key = kwarg.getKey();
            try {
                Object value = StaticValueResolver.evaluate(kwarg.getValue(), staticAssignments);
                if (context.containsKey(key)) {
                    collisionCount++;
                    log.append(templateName).append(": kwarg '").append(key)
                            .append("' overwritten by later render_template call in function '")
                            .append(enclosingFnName).append("' at line ").append(call.line).append("\n");
                }
                context.put(key, value);
                resolvedKwargCount++;
            } catch (StaticValueResolver.UnresolvableException e) {
                skippedKwargCount++;
                log.append(templateName).append(": skipped kwarg '").append(key)
                        .append("' — not statically resolvable (").append(e.nodeDescription).append(")\n");
            }
        }
    }

    private void appendSummary() {
        log.append("---\n");
        log.append("Summary: templates=").append(templatesFound)
                .append(", resolvedKwargs=").append(resolvedKwargCount)
                .append(", skippedKwargs=").append(skippedKwargCount)
                .append(", collisions=").append(collisionCount).append("\n");
    }
}
