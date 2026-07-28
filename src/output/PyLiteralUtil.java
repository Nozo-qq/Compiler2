package output;

public final class PyLiteralUtil {

    private PyLiteralUtil() {}

    /**
     * Strips the outer quote char and does minimal unescaping of a raw STRING
     * token as produced by AntlrToExpression.visitString / visitDict
     * (e.g. `"\"Fast\""` -> `Fast`). Unrecognized backslash sequences are left
     * as-is (not a full Python string-literal grammar).
     */
    public static String unquoteString(String raw) {
        if (raw == null || raw.length() < 2) {
            return raw;
        }
        char first = raw.charAt(0);
        char last = raw.charAt(raw.length() - 1);
        if ((first != '"' && first != '\'') || first != last) {
            return raw;
        }
        String inner = raw.substring(1, raw.length() - 1);
        StringBuilder sb = new StringBuilder(inner.length());
        for (int i = 0; i < inner.length(); i++) {
            char c = inner.charAt(i);
            if (c == '\\' && i + 1 < inner.length()) {
                char next = inner.charAt(i + 1);
                switch (next) {
                    case '"' -> { sb.append('"'); i++; }
                    case '\'' -> { sb.append('\''); i++; }
                    case '\\' -> { sb.append('\\'); i++; }
                    case 'n' -> { sb.append('\n'); i++; }
                    case 't' -> { sb.append('\t'); i++; }
                    case 'r' -> { sb.append('\r'); i++; }
                    default -> sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
