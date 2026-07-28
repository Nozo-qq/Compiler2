package ASTJinja2withHTMLandCSS.Render;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.ProgramNode;
import ASTJinja2withHTMLandCSS.HTML.*;
import ASTJinja2withHTMLandCSS.HTML.Expressions.*;

import java.util.List;
import java.util.Map;

/**
 * Walks a Jinja/HTML AST together with one template's context data map and
 * produces the final rendered HTML string. Undefined variables render as an
 * empty string (matching real Jinja2's default Undefined behavior) rather
 * than throwing, and every such case is written to the RenderLog instead of
 * being silently swallowed.
 */
public class HtmlRenderer {

    public String render(ASTNode root, Map<String, Object> context, String templateName, RenderLog log) {
        StringBuilder out = new StringBuilder();
        renderNode(root, RenderScope.root(context), templateName, log, out);
        return out.toString();
    }

    private void renderNode(ASTNode node, RenderScope scope, String templateName, RenderLog log, StringBuilder out) {
        if (node == null) {
            return;
        }
        if (node instanceof ProgramNode prog) {
            for (ASTNode child : prog.getChildren()) {
                renderNode(child, scope, templateName, log, out);
            }
        } else if (node instanceof HtmlDocumentNode doc) {
            for (ASTNode child : doc.getChildren()) {
                renderNode(child, scope, templateName, log, out);
            }
        } else if (node instanceof DoctypeNode doctype) {
            out.append(doctype.getNodeValue());
        } else if (node instanceof TextNode text) {
            out.append(text.getText());
        } else if (node instanceof HtmlElementNode element) {
            renderElement(element, scope, templateName, log, out);
        } else if (node instanceof ForNode forNode) {
            renderFor(forNode, scope, templateName, log, out);
        } else if (node instanceof ExpressionNode expression) {
            out.append(stringify(evaluate(expression.getInner(), scope, templateName, log)));
        }
    }

    private void renderElement(HtmlElementNode element, RenderScope scope, String templateName, RenderLog log, StringBuilder out) {
        out.append('<').append(element.getTagName());
        for (AttributeNode attribute : element.getAttributes()) {
            out.append(' ');
            if (attribute.isBoolean()) {
                out.append(attribute.getName());
                continue;
            }
            out.append(attribute.getName()).append("=\"");
            for (ASTNode part : attribute.getValue().getParts()) {
                if (part instanceof TextNode text) {
                    out.append(text.getText());
                } else if (part instanceof ExpressionNode expression) {
                    out.append(stringify(evaluate(expression.getInner(), scope, templateName, log)));
                }
            }
            out.append('"');
        }
        if (element.isSelfClosing()) {
            out.append(" />");
            return;
        }
        out.append('>');
        for (ASTNode child : element.getContent()) {
            renderNode(child, scope, templateName, log, out);
        }
        out.append("</").append(element.getTagName()).append('>');
    }

    private void renderFor(ForNode forNode, RenderScope scope, String templateName, RenderLog log, StringBuilder out) {
        Object iterable = scope.lookup(forNode.getIterableName());
        if (!(iterable instanceof List<?> list)) {
            log.append(templateName + ": for-loop '" + forNode.getLoopVar() + " in " + forNode.getIterableName()
                    + "' skipped - '" + forNode.getIterableName() + "' is not a list ("
                    + (iterable == null ? "undefined" : iterable.getClass().getSimpleName()) + ")");
            return;
        }
        for (Object item : list) {
            RenderScope iterationScope = scope.child(forNode.getLoopVar(), item);
            for (ASTNode child : forNode.getBody()) {
                renderNode(child, iterationScope, templateName, log, out);
            }
        }
    }

    private Object evaluate(ASTNode expr, RenderScope scope, String templateName, RenderLog log) {
        if (expr instanceof MemberAccessNode memberAccess) {
            return evaluateMemberAccess(memberAccess, scope, templateName, log);
        }
        if (expr instanceof FunctionCallNode call) {
            return evaluateFunctionCall(call, scope, templateName, log);
        }
        return null;
    }

    private Object evaluateMemberAccess(MemberAccessNode memberAccess, RenderScope scope, String templateName, RenderLog log) {
        List<String> path = memberAccess.getPath();
        Object current = scope.lookup(path.get(0));
        for (int i = 1; i < path.size() && current != null; i++) {
            if (current instanceof Map<?, ?> map) {
                current = map.get(path.get(i));
            } else {
                current = null;
            }
        }
        if (current == null) {
            log.append(templateName + ": '" + String.join(".", path) + "' is undefined, rendered as empty string");
        }
        return current;
    }

    // url_for('static', filename=X) -> "/static/" + X, matching Flask's default
    // static-file endpoint (the only shape any of the fixture templates use).
    // Any other callee, or url_for with a different first argument, logs a
    // warning and renders as empty string rather than failing the whole page.
    private Object evaluateFunctionCall(FunctionCallNode call, RenderScope scope, String templateName, RenderLog log) {
        String calleeName = call.getCallee() != null ? String.join(".", call.getCallee().getPath()) : "?";
        if (!"url_for".equals(calleeName)) {
            log.append(templateName + ": unsupported function call '" + calleeName + "(...)', rendered as empty string");
            return null;
        }

        String endpoint = null;
        String filename = null;
        List<ArgumentNode> args = call.getArguments();
        for (int i = 0; i < args.size(); i++) {
            ArgumentNode arg = args.get(i);
            Object value = evaluateArgValue(arg.getValue(), scope, templateName, log);
            if (arg.getName() == null && i == 0) {
                endpoint = value != null ? String.valueOf(value) : null;
            } else if ("filename".equals(arg.getName())) {
                filename = value != null ? String.valueOf(value) : null;
            }
        }

        if ("static".equals(endpoint) && filename != null) {
            return "/static/" + filename;
        }
        log.append(templateName + ": url_for(" + endpoint + ", ...) not supported (only url_for('static', filename=...) is), rendered as empty string");
        return null;
    }

    private Object evaluateArgValue(ASTNode value, RenderScope scope, String templateName, RenderLog log) {
        if (value instanceof LiteralNode literal) {
            return literal.getValue();
        }
        if (value instanceof MemberAccessNode memberAccess) {
            return evaluateMemberAccess(memberAccess, scope, templateName, log);
        }
        return null;
    }

    private String stringify(Object value) {
        return value == null ? "" : String.valueOf(value);
    }
}
