package antlr.grammar.flask;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {

    // The LEGB categories that Python actually cares about
    public enum ScopeType {
        GLOBAL,         // The top-level module/file environment (M)
        FUNCTION,       // Created by 'def' or 'lambda' (L)
        CLASS,          // Created inside a class statement
        COMPREHENSION,  // Temporary scope for [x for x in ...]
        BUILT_IN        // The absolute fallback layer (print, len, etc.)
    }

    private final Scope parent;
    private final String name;
    private final ScopeType type;
    private final Map<String, Object> symbols = new LinkedHashMap<>();

    public Scope(Scope parent, String name, ScopeType type) {
        this.parent = parent;
        this.name = name;
        this.type = type;
    }

    /**
     * Python Assignment: Defines or updates a variable in the CURRENT local scope.
     * Note: 'if' and 'for' blocks write directly here without creating a new scope object.
     */
    public void define(String name, Object value) {
        symbols.put(name, value);
    }

    /**
     * Python Lookup (The LEGB Rule): Recursively looks upward through the
     * environment chain to find where a variable was originally declared.
     */
    public Object lookup(String name) {
        // 1. Check Local (or current Enclosing layer)
        if (symbols.containsKey(name)) {
            return symbols.get(name);
        }

        // 2. Delegate up to Enclosing or Global layers
        if (parent != null) {
            return parent.lookup(name);
        }

        // 3. Not found anywhere in the scope chain
        return null;
    }

    // --- Getters & Utility Methods ---

    public Scope getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public ScopeType getType() {
        return type;
    }

    public Map<String, Object> getSymbols() {
        return java.util.Collections.unmodifiableMap(symbols);
    }

    /**
     * Generates standard Python qualified paths (e.g., "my_module.my_func")
     */
    public String getFullPath() {
        if (parent == null || type == ScopeType.GLOBAL) {
            return name;
        }
        return parent.getFullPath() + "." + name;
    }
}