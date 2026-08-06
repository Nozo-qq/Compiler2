package SymbolsTable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolsTable {
    private static SymbolsTable htmlInstance;
    private final Map<String, Object> symbols = new LinkedHashMap<>();

    private SymbolsTable() {}

    public static synchronized SymbolsTable getHtmlInstance() {
        if (htmlInstance == null) htmlInstance = new SymbolsTable();
        return htmlInstance;
    }

    public Object getHtmlSymbol(String key) { return symbols.get(key); }

    public void addHtmlSymbol(String key, Object details) { symbols.put(key, details); }

    public void removeHtmlKey(String key) { symbols.remove(key); }

    /** @deprecated Use {@link #removeHtmlKey(String)} */
    @Deprecated
    public void removehtmlkey(String key) { removeHtmlKey(key); }

    public Map<String, Object> getAll() { return Collections.unmodifiableMap(symbols); }
}
