package output;

import antlr.grammar.flask.Scope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class SemanticReportWriter {

    private SemanticReportWriter() {}

    public static String buildSuccessReport(Scope globalScope) {
        StringBuilder sb = new StringBuilder();
        sb.append("Semantic Analysis Report\n");
        sb.append("Generated: ").append(LocalDateTime.now()).append("\n");
        sb.append("Status: PASSED\n\n");

        List<String> functions = new ArrayList<>();
        List<String> variables = new ArrayList<>();
        for (Map.Entry<String, Object> entry : globalScope.getSymbols().entrySet()) {
            if ("function".equals(entry.getValue())) {
                functions.add(entry.getKey());
            } else {
                variables.add(entry.getKey());
            }
        }

        sb.append("Top-level functions (").append(functions.size()).append("):\n");
        for (String name : functions) {
            sb.append("  - ").append(name).append("\n");
        }
        sb.append("\nTop-level variables (").append(variables.size()).append("):\n");
        for (String name : variables) {
            sb.append("  - ").append(name).append("\n");
        }

        return sb.toString();
    }

    public static String buildFailureReport(String errorMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append("Semantic Analysis Report\n");
        sb.append("Generated: ").append(LocalDateTime.now()).append("\n");
        sb.append("Status: FAILED\n\n");
        sb.append("Error: ").append(errorMessage).append("\n");
        return sb.toString();
    }
}
