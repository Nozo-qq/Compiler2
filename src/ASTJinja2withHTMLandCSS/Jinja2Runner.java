package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.Render.HtmlRenderer;
import ASTJinja2withHTMLandCSS.Render.RenderLog;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

/**
 * Renders each template referenced in the Flask side's context data map into
 * final HTML under output/, and copies the app's static assets alongside it.
 */
public class Jinja2Runner {

    private static final Path TEMPLATES_DIR = Paths.get("Testing Project/FlaskTestingApp/templates");
    private static final Path STATIC_DIR = Paths.get("Testing Project/FlaskTestingApp/static");
    private static final Path IMAGES_DIR = Paths.get("Testing Project/FlaskTestingApp/images");
    private static final Path APP_PY = Paths.get("Testing Project/FlaskTestingApp/app.py");
    private static final Path OUTPUT_DIR = Paths.get("output");

    public static void renderAll(Map<String, Object> contextData, boolean detail) throws IOException {
        Files.createDirectories(OUTPUT_DIR);
        RenderLog log = new RenderLog();
        HtmlRenderer renderer = new HtmlRenderer();

        for (Map.Entry<String, Object> entry : contextData.entrySet()) {
            @SuppressWarnings("unchecked")
            Map<String, Object> context = (Map<String, Object>) entry.getValue();
            renderTemplate(entry.getKey(), context, renderer, log, detail);
        }

        copyStaticAssets(log);
        Files.writeString(OUTPUT_DIR.resolve("render_log.txt"), log.getLogText());
    }

    private static void renderTemplate(String templateName, Map<String, Object> context, HtmlRenderer renderer,
                                        RenderLog log, boolean detail) {
        Path templatePath = TEMPLATES_DIR.resolve(templateName);
        try {
            if (!Files.exists(templatePath)) {
                log.append("error: template '" + templateName + "' not found at " + templatePath);
                return;
            }

            MYErrorListener.hasError = false;
            Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(fromFileName(templatePath.toString()));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MYErrorListener(templatePath.toString()));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new MYErrorListener(templatePath.toString()));

            ParseTree tree = parser.prog();
            if (MYErrorListener.hasError) {
                log.append("error: template '" + templateName + "' failed to parse, skipped");
                return;
            }

            BaseVisitor visitor = new BaseVisitor(templatePath.toString());
            ASTNode root = visitor.visit(tree);
            if (MYErrorListener.hasError) {
                // AttributeValueParser re-parses {{ ... }} fragments extracted from
                // attribute values using their own MYErrorListener instances; those
                // failures only surface via the shared flag once visiting completes.
                log.append("error: template '" + templateName + "' had an unparseable attribute expression, skipped");
                return;
            }

            if (detail) {
                root.print("", true, 0, true);
            }

            String html = renderer.render(root, context, templateName, log);
            Files.writeString(OUTPUT_DIR.resolve(templateName), html);
        } catch (Exception e) {
            log.append("error: template '" + templateName + "' failed to render (" + e + "), skipped");
        }
    }

    private static void copyStaticAssets(RenderLog log) {
        try {
            Path styleCss = STATIC_DIR.resolve("style.css");
            if (Files.exists(styleCss)) {
                Path staticOut = OUTPUT_DIR.resolve("static");
                Files.createDirectories(staticOut);
                Files.copy(styleCss, staticOut.resolve("style.css"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            log.append("error: failed to copy static/style.css (" + e + ")");
        }

        try {
            if (Files.isDirectory(IMAGES_DIR)) {
                Path imagesOut = OUTPUT_DIR.resolve("images");
                Files.createDirectories(imagesOut);
                List<Path> imageFiles;
                try (var stream = Files.list(IMAGES_DIR)) {
                    imageFiles = stream.collect(Collectors.toList());
                }
                for (Path image : imageFiles) {
                    Files.copy(image, imagesOut.resolve(image.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            log.append("error: failed to copy images/ (" + e + ")");
        }

        try {
            if (Files.exists(APP_PY)) {
                Files.copy(APP_PY, OUTPUT_DIR.resolve("app.py"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            log.append("error: failed to copy app.py (" + e + ")");
        }
    }
}
