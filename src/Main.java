import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.BaseVisitor;
import ASTJinja2withHTMLandCSS.FrontendRootNode;
import antlr.grammar.Jinja2withHTMLandCSS.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            // 1. تحديد مسار مجلد قوالب HTML ومسار ملف CSS
            Path templatesDirPath = args.length > 0
                    ? Path.of(args[0])
                    : Path.of("Testing Project/FlaskTestingApp/templates");
            Path cssFilePath = args.length > 1
                    ? Path.of(args[1])
                    : Path.of("Testing Project/FlaskTestingApp/static/style.css");

            // 2. إنشاء الزائر (Visitor) المشترك
            BaseVisitor visitor = new BaseVisitor();

            // العقدة الجذرية للمشروع الواجهي
            ASTNode frontendTree = new FrontendRootNode(0);

            // ==========================================
            // 3. تحليل جميع ملفات HTML / Jinja2 في المجلد
            // ==========================================
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(templatesDirPath, "*.html")) {
                for (Path htmlFilePath : stream) {
                    CharStream htmlStream = CharStreams.fromPath(htmlFilePath);
                    Jinja2withHTMLandCSSLexer htmlLexer = new Jinja2withHTMLandCSSLexer(htmlStream);
                    CommonTokenStream htmlTokens = new CommonTokenStream(htmlLexer);
                    Jinja2withHTMLandCSSParser htmlParser = new Jinja2withHTMLandCSSParser(htmlTokens);

                    Jinja2withHTMLandCSSParser.Jinja2ProgContext htmlTree = htmlParser.jinja2Prog();
                    ASTNode jinjaAst = visitor.visitJinja2Prog(htmlTree);

                    // إضافة كل شجرة HTML كابن للجذر
                    if (jinjaAst != null) {
                        frontendTree.addChild(jinjaAst);
                    }
                }
            }

            // ==========================================
            // 4. تحليل ملف CSS (بعد أن امتلأ جدول الرموز بكل كلاسات HTML)
            // ==========================================
            CharStream cssStream = CharStreams.fromPath(cssFilePath);
            Jinja2withHTMLandCSSLexer cssLexer = new Jinja2withHTMLandCSSLexer(cssStream);
            CommonTokenStream cssTokens = new CommonTokenStream(cssLexer);
            Jinja2withHTMLandCSSParser cssParser = new Jinja2withHTMLandCSSParser(cssTokens);

            Jinja2withHTMLandCSSParser.CssProgContext cssParseTree = cssParser.cssProg();
            ASTNode cssAst = visitor.visitCssProg(cssParseTree);

            if (cssAst != null) {
                frontendTree.addChild(cssAst);
            }

            // ==========================================
            // 5. الطباعة واستخراج الأخطاء
            // ==========================================
            System.out.println("=== 🌳 Frontend Abstract Syntax Tree (AST) 🌳 ===\n");
            System.out.println(frontendTree.toTree());

            System.out.println("\n=== 🚨 Semantic Analysis Report 🚨 ===");
            if (!visitor.semanticErrors.isEmpty()) {
                for (String error : visitor.semanticErrors) {
                    System.out.println("❌ " + error);
                }
            } else {
                System.out.println("✅ Clean Frontend! No semantic errors found.");
            }

        } catch (IOException e) {
            System.err.println("❌ Could not find or read the files. Please check the paths.");
            System.err.println("Details: " + e.getMessage());
        }
    }
}