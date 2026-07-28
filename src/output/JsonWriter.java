package output;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public final class JsonWriter {

    private JsonWriter() {}

    public static String write(Object value, boolean pretty) {
        StringBuilder sb = new StringBuilder();
        writeValue(sb, value, 0, pretty);
        return sb.toString();
    }

    private static void writeValue(StringBuilder sb, Object value, int indent, boolean pretty) {
        if (value == null) {
            sb.append("null");
        } else if (value instanceof Map<?, ?> map) {
            writeObject(sb, map, indent, pretty);
        } else if (value instanceof List<?> list) {
            writeArray(sb, list, indent, pretty);
        } else if (value instanceof String s) {
            writeString(sb, s);
        } else if (value instanceof Boolean || value instanceof Integer || value instanceof Long
                || value instanceof Double || value instanceof BigInteger) {
            sb.append(String.valueOf(value));
        } else {
            throw new IllegalStateException("JsonWriter: unsupported value type " + value.getClass());
        }
    }

    private static void writeObject(StringBuilder sb, Map<?, ?> map, int indent, boolean pretty) {
        if (map.isEmpty()) {
            sb.append("{}");
            return;
        }
        sb.append("{");
        if (pretty) sb.append("\n");
        int i = 0, size = map.size();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (pretty) indent(sb, indent + 1);
            writeString(sb, String.valueOf(entry.getKey()));
            sb.append(":");
            if (pretty) sb.append(" ");
            writeValue(sb, entry.getValue(), indent + 1, pretty);
            if (++i < size) sb.append(",");
            if (pretty) sb.append("\n");
        }
        if (pretty) indent(sb, indent);
        sb.append("}");
    }

    private static void writeArray(StringBuilder sb, List<?> list, int indent, boolean pretty) {
        if (list.isEmpty()) {
            sb.append("[]");
            return;
        }
        sb.append("[");
        if (pretty) sb.append("\n");
        int i = 0, size = list.size();
        for (Object element : list) {
            if (pretty) indent(sb, indent + 1);
            writeValue(sb, element, indent + 1, pretty);
            if (++i < size) sb.append(",");
            if (pretty) sb.append("\n");
        }
        if (pretty) indent(sb, indent);
        sb.append("]");
    }

    private static void writeString(StringBuilder sb, String s) {
        sb.append('"');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"' -> sb.append("\\\"");
                case '\\' -> sb.append("\\\\");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                case '\b' -> sb.append("\\b");
                case '\f' -> sb.append("\\f");
                default -> {
                    if (c < 0x20) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
                }
            }
        }
        sb.append('"');
    }

    private static void indent(StringBuilder sb, int level) {
        sb.append("  ".repeat(level));
    }
}
