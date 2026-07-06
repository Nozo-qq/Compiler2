package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.ASTNode;
//import SymbolsTable.SymbolsTable;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Test {

    public static void main(String[] args) throws Exception {
//        String t1 = "Testing Project/FlaskTestingApp/templates/add_product.html";
//        String t2 = "Testing Project/FlaskTestingApp/templates/index.html";
//        String t3 = "Testing Project/FlaskTestingApp/templates/product.html";
//        String Css = "Testing Project/FlaskTestingApp/static/style.css";
//        SymbolsTable symbolsTable= SymbolsTable.getHtmlInstance();
//        Map<String, Object> inner = new LinkedHashMap<>();
//        inner.put("products","all the product");
//        inner.put("product","like 1");
//        symbolsTable.addHtmlSymbol("data_sent",inner);
//        List<String> allErrors = new ArrayList<>();
//        // Run for HTML/Jinja2
//        System.out.println("--- Processing HTML/Jinja2 ---");
//
//        allErrors.addAll(runParser(t1));
//        allErrors.addAll(runParser(t2));
//        allErrors.addAll(runParser(t3));
//        // Run for CSS
//        System.out.println("\n--- Processing CSS ---");
//        allErrors.addAll(runParser(Css));
//        for( String erro :allErrors)
//        {System.err.println(erro);}
//        IO.println();
//        symbolsTable.printjinja2Symbols();
//    }
//    public static List<String> runParser(String filePath) throws Exception {
//        MYErrorListener.hasError=false;
//        CharStream cs = fromFileName(filePath);
//        Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(cs);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);
//        parser.removeErrorListeners();
//        parser.addErrorListener(new MYErrorListener(filePath));
//
//        ParseTree tree = parser.prog();
//
//        if (!MYErrorListener.hasError){
//            BaseVisitor builder = new BaseVisitor();
//            ASTNode root = builder.visit(tree);
//
//            System.out.println("\n"+filePath);
//            root.print("",true,0,false);
//            if (!builder.semanticErrors.isEmpty())
//                builder.semanticErrors.addFirst("ERRORS for the file: "+filePath);
//            return builder.semanticErrors;
//        }
//        return new ArrayList<>();
    }
}