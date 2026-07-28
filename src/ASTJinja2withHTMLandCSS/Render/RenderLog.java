package ASTJinja2withHTMLandCSS.Render;

public class RenderLog {
    private final StringBuilder log = new StringBuilder();

    public void append(String line) {
        log.append(line).append('\n');
    }

    public String getLogText() {
        return log.toString();
    }
}
