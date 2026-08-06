package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.BaseVisitor;
import antlr.grammar.Jinja2withHTMLandCSS.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Test {
    public static void main(String[] args) {
        try {
            // 1. ضع هنا مسار ملف الـ HTML أو الـ Jinja2 الخاص بك
            Path htmlFilePath = Path.of(
                    "D:\\Nozo\\Projects\\Compiler2\\Testing Project\\FlaskTestingApp\\templates\\index.html"
            );

            // 2. القراءة والتحليل المعجمي
            CharStream charStream = CharStreams.fromPath(htmlFilePath);
            Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // 3. التحليل النحوي (هنا نطلب منه قراءة jinja2Prog بدلاً من cssProg)
            Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);
            Jinja2withHTMLandCSSParser.Jinja2ProgContext htmlTree = parser.jinja2Prog();

            // 4. بناء الـ AST
            BaseVisitor visitor = new BaseVisitor();
            ASTNode astRoot = visitor.visitJinja2Prog(htmlTree);

            // 5. الطباعة
            System.out.println("=== 🌳 HTML/Jinja2 Abstract Syntax Tree (AST) 🌳 ===\n");
            if (astRoot != null) {
                System.out.println(astRoot.toTree());
            }

            // 6. طباعة الأخطاء الدلالية الخاصة بالـ HTML
            System.out.println("\n=== 🚨 Semantic Analysis Report 🚨 ===");
            if (!visitor.semanticErrors.isEmpty()) {
                for (String error : visitor.semanticErrors) {
                    System.out.println("❌ " + error);
                }
            } else {
                System.out.println("✅ Clean HTML! No semantic errors found.");
            }

        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }
}