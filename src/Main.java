import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.BaseVisitor;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) throws IOException {

        Path cssFilePath = Path.of(
                "D:\\Nozo\\Projects\\Compiler2\\Testing Project\\FlaskTestingApp\\static\\style.css"
        );

        CharStream charStream = CharStreams.fromPath(cssFilePath);

        Jinja2withHTMLandCSSLexer lexer =
                new Jinja2withHTMLandCSSLexer(charStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Jinja2withHTMLandCSSParser parser =
                new Jinja2withHTMLandCSSParser(tokens);

        Jinja2withHTMLandCSSParser.CssProgContext cssTree =
                parser.cssProg();

        BaseVisitor visitor = new BaseVisitor();

        ASTNode astRoot = visitor.visitCssProg(cssTree);

        System.out.println("=== Abstract Syntax Tree (AST) ===");

        if (astRoot != null) {
            astRoot.print("");
        } else {
            System.out.println("فشل بناء الشجرة!");
        }
    }


}
