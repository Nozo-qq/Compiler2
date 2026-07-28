import ASTJinja2withHTMLandCSS.Jinja2Runner;
import antlr.grammar.flask.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import FlaskStatement.*;
import output.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        //        // Load the input file
        String code = Files.readString(Paths.get("Testing Project/FlaskTestingApp/app.py"));
//
//        // Create lexer
        FlaskExprLexer lexer = new FlaskExprLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

//        // Create parser
        FlaskExprParser parser = new FlaskExprParser(tokens);
//
//        // Parse using the top rule
        ParseTree tree = parser.program();

        AntlrToProgram programVisitor = new AntlrToProgram();
        Program program = (Program) programVisitor.visit(tree);
        System.out.println("=== AST ===");
        ASTPrettyPrinter.print(program);

        Path outputDir = Paths.get("compiler_output");
        Files.createDirectories(outputDir);

        SemanticAnalyzer analyzer = new SemanticAnalyzer();

        try {
            System.out.println("Running Semantic Analysis Checks...");
            analyzer.analyze(program.statements);
            System.out.println("Semantic Analysis Passed! Moving to Code Generation.");

            Files.writeString(outputDir.resolve("semantic_report.txt"),
                    SemanticReportWriter.buildSuccessReport(analyzer.getCurrentScope()));

        } catch (RuntimeException semanticException) {
            System.err.println("Compilation Failed due to Semantic Fault!");
            System.err.println(semanticException.getMessage());

            try {
                Files.writeString(outputDir.resolve("semantic_report.txt"),
                        SemanticReportWriter.buildFailureReport(semanticException.getMessage()));
            } catch (IOException ioe) {
                System.err.println("Additionally failed to write semantic_report.txt: " + ioe.getMessage());
            }
            System.exit(1);
        }

        // Only reached on semantic-analysis success.
        try {
            Files.writeString(outputDir.resolve("ast_python.json"), AstJsonSerializer.serialize(program, true));

            ContextDataGenerator contextGen = new ContextDataGenerator();
            Map<String, Object> contextData = contextGen.generate(program.statements);
            Files.writeString(outputDir.resolve("context_data.json"), JsonWriter.write(contextData, true));
            Files.writeString(outputDir.resolve("generation_log.txt"), contextGen.getLogText());

            System.out.println("Context data generation complete.");
            System.out.println("Artifacts written to: " + outputDir.toAbsolutePath());

            try {
                Jinja2Runner.renderAll(contextData, true);
                System.out.println("Template rendering complete. Output written to: " + Paths.get("output").toAbsolutePath());
            } catch (Exception renderException) {
                // A rendering hiccup shouldn't be fatal to a pipeline that already
                // succeeded through semantic analysis and context data generation.
                System.err.println("Template rendering failed: " + renderException.getMessage());
                renderException.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("Compilation Failed: Could not write output artifacts to compiler_output/.");
            e.printStackTrace();
            System.exit(1);
        }
    }

}