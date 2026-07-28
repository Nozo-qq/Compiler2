package output;

import FlaskStatement.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class StaticValueResolver {

    private StaticValueResolver() {}

    /** Thrown when an expression cannot be resolved to a static value. */
    public static class UnresolvableException extends RuntimeException {
        public final String nodeDescription;

        public UnresolvableException(String nodeDescription) {
            super(nodeDescription);
            this.nodeDescription = nodeDescription;
        }
    }

    /**
     * Recursively evaluate an Expression into a plain Java value
     * (String / Long / Integer / Double / BigInteger / Boolean / null /
     * List<Object> / LinkedHashMap<String,Object>), resolving Name
     * references against staticAssignments. Throws UnresolvableException
     * if any part of the tree can't be resolved.
     */
    public static Object evaluate(Expression expr, Map<String, Object> staticAssignments) {
        if (expr instanceof Literal lit) {
            if (lit.isString()) {
                return PyLiteralUtil.unquoteString((String) lit.value);
            }
            return lit.value;
        }
        if (expr instanceof Name n) {
            if (staticAssignments.containsKey(n.id)) {
                return staticAssignments.get(n.id);
            }
            throw new UnresolvableException("Name '" + n.id + "' (not a known top-level static assignment)");
        }
        if (expr instanceof ListExpr le) {
            List<Object> out = new ArrayList<>();
            for (Expression e : le.expressions) {
                out.add(evaluate(e, staticAssignments));
            }
            return out;
        }
        if (expr instanceof DictExpr de) {
            LinkedHashMap<String, Object> out = new LinkedHashMap<>();
            for (Map.Entry<String, Expression> entry : de.pairs.entrySet()) {
                out.put(PyLiteralUtil.unquoteString(entry.getKey()), evaluate(entry.getValue(), staticAssignments));
            }
            return out;
        }
        throw new UnresolvableException(expr.getClass().getSimpleName());
    }
}
