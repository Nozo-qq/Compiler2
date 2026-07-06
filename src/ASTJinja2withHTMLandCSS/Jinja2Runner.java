package ASTJinja2withHTMLandCSS;

//import SymbolsTable.SymbolsTable;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Jinja2Runner {
    public static void runDefaultSuite(Boolean detail) {
//        try {
//            SymbolsTable symbolsTable = SymbolsTable.getHtmlInstance();
////            Map<String, Object> inner = new LinkedHashMap<>();
////            inner.addHtmlSymbol("products", "all the product");
////            inner.addHtmlSymbol("product", "like 1");
////            symbolsTable.addHtmlSymbol("data_sent", inner);
//
//
//            String[] files = {
//                    "Testing Project/FlaskTestingApp/templates/add_product.html",
//                    "Testing Project/FlaskTestingApp/templates/index.html",
//                    "Testing Project/FlaskTestingApp/templates/product.html",
//                    "Testing Project/FlaskTestingApp/static/style.css"
//            };
//
//            List<String> allErrors = new ArrayList<>();
//
//            for (String file : files) {
//                System.out.println("\n--- Processing: " + file + " ---");
//                allErrors.addAll(executeFileParser(file,detail));
//            }
//
//
//            if (!allErrors.isEmpty()) {
//                System.err.println("\n=== SEMANTIC ERRORS ===");
//                allErrors.forEach(System.err::println);
//            }
//
//            System.out.println("\n=== Jinja2/HTML/CSS SYMBOL TABLE ===\n");
//            symbolsTable.printjinja2Symbols();
//
//        } catch (Exception e) {
//            System.err.println("Fatal error during execution: " + e.getMessage());
//        }
//    }
//
//    private static List<String> executeFileParser(String filePath,Boolean detail) throws Exception {
//        MYErrorListener.hasError = false;
//        CharStream cs = fromFileName(filePath);
//        Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(cs);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);
//
//        parser.removeErrorListeners();
//        parser.addErrorListener(new MYErrorListener(filePath));
//
//        ParseTree tree = parser.prog();
//
//        if (!MYErrorListener.hasError) {
//            BaseVisitor builder = new BaseVisitor();
//            ASTNode root = builder.visit(tree);
//
//            root.print("",true,0,detail);
//            if (!builder.semanticErrors.isEmpty()) {
//                builder.semanticErrors.addFirst("ERRORS for the file: " + filePath);
//            }
//            return builder.semanticErrors;
//        }
     //   return new ArrayList<>();
    }
}
