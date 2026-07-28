package ASTJinja2withHTMLandCSS.Render;

import java.util.Collections;
import java.util.Map;

/**
 * Parent-chained variable lookup. Each for-loop iteration gets a fresh child
 * scope holding only the loop variable, so the binding is discarded (and any
 * outer variable of the same name un-shadowed) once the loop body finishes.
 */
public class RenderScope {
    private final Map<String, Object> bindings;
    private final RenderScope parent;

    private RenderScope(Map<String, Object> bindings, RenderScope parent) {
        this.bindings = bindings;
        this.parent = parent;
    }

    public static RenderScope root(Map<String, Object> context) {
        return new RenderScope(context, null);
    }

    public RenderScope child(String name, Object value) {
        return new RenderScope(Collections.singletonMap(name, value), this);
    }

    public Object lookup(String name) {
        if (bindings.containsKey(name)) {
            return bindings.get(name);
        }
        return parent != null ? parent.lookup(name) : null;
    }
}
