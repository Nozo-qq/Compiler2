package server;

import ASTJinja2withHTMLandCSS.Jinja2Runner;
import ASTJinja2withHTMLandCSS.Render.RenderLog;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Ordinary, ahead-of-time compiled Java HTTP server (not runtime-generated
 * code) that mirrors app.py's routes. It is seeded once from the batch
 * pipeline's Context Data and, from then on, answers real requests directly
 * against an in-memory ProductStore, re-running the existing Jinja/HTML
 * renderer (Jinja2Runner/HtmlRenderer) to regenerate the affected output/*.html
 * page after every mutation - the same "Context Data -> render_template" path
 * the batch pipeline already uses, just triggered per-request instead of once.
 */
public class AppServer {

    private static final Path TEMPLATES_STATIC_DIR = Paths.get("Testing Project/FlaskTestingApp/static");
    private static final Path IMAGES_DIR = Paths.get("Testing Project/FlaskTestingApp/images");
    private static final Path OUTPUT_DIR = Paths.get("output");
    private static final Path COMPILER_OUTPUT_DIR = Paths.get("compiler_output");

    private final ProductStore store;

    private AppServer(ProductStore store) {
        this.store = store;
    }

    public static AppServer start(ProductStore store, int port) throws IOException {
        AppServer server = new AppServer(store);
        HttpServer http = HttpServer.create(new InetSocketAddress(port), 0);
        http.setExecutor(Executors.newFixedThreadPool(4));

        http.createContext("/images/", server::handleImage);
        http.createContext("/static/", server::handleStatic);
        http.createContext("/product/", server::handleProductDetails);
        http.createContext("/delete/", server::handleDelete);
        http.createContext("/add", server::handleAdd);
        http.createContext("/", server::handleHome);

        http.start();
        System.out.println("AppServer listening on http://localhost:" + port + "/");
        return server;
    }

    /** Renders index.html from the current store state and writes it to disk. Used at startup and after every mutation. */
    public String regenerateIndex(String trigger) throws IOException {
        Map<String, Object> context = new LinkedHashMap<>();
        context.put("products", store.visibleProducts());
        return regenerate("index.html", context, trigger);
    }

    // ---- route handlers ----

    private void handleHome(HttpExchange exchange) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            sendPlainText(exchange, 405, "Method Not Allowed");
            return;
        }
        String html = regenerateIndex("GET /");
        sendHtml(exchange, 200, html);
    }

    private void handleProductDetails(HttpExchange exchange) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            sendPlainText(exchange, 405, "Method Not Allowed");
            return;
        }
        Integer id = pathId(exchange.getRequestURI().getPath(), "/product/");
        if (id == null) {
            sendPlainText(exchange, 400, "Invalid product id");
            return;
        }
        Map<String, Object> product = store.findVisibleProduct(id);
        Map<String, Object> context = new LinkedHashMap<>();
        context.put("product", product);
        String html = regenerate("product.html", context, "GET /product/" + id);
        sendHtml(exchange, 200, html);
    }

    private void handleAdd(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if ("GET".equalsIgnoreCase(method)) {
            String html = regenerate("add_product.html", new LinkedHashMap<>(), "GET /add");
            sendHtml(exchange, 200, html);
            return;
        }
        if (!"POST".equalsIgnoreCase(method)) {
            sendPlainText(exchange, 405, "Method Not Allowed");
            return;
        }

        Map<String, String> form = parseFormBody(exchange.getRequestBody());
        Object addedId;
        synchronized (store) {
            Map<String, Object> added = store.addProduct(form);
            addedId = added.get("id");
            regenerateIndex("POST /add, new product id=" + addedId);
        }
        redirectTo(exchange, "/");
    }

    private void handleDelete(HttpExchange exchange) throws IOException {
        if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            sendPlainText(exchange, 405, "Method Not Allowed");
            return;
        }
        Integer id = pathId(exchange.getRequestURI().getPath(), "/delete/");
        if (id == null) {
            sendPlainText(exchange, 400, "Invalid product id");
            return;
        }
        synchronized (store) {
            store.deleteProduct(id);
            regenerateIndex("POST /delete/" + id);
        }
        redirectTo(exchange, "/");
    }

    private void handleImage(HttpExchange exchange) throws IOException {
        serveStaticFile(exchange, IMAGES_DIR, "/images/");
    }

    private void handleStatic(HttpExchange exchange) throws IOException {
        serveStaticFile(exchange, TEMPLATES_STATIC_DIR, "/static/");
    }

    // ---- helpers ----

    private String regenerate(String templateName, Map<String, Object> context, String trigger) throws IOException {
        RenderLog log = new RenderLog();
        String html = Jinja2Runner.renderOne(templateName, context, false, log);
        appendToFile(OUTPUT_DIR.resolve("render_log.txt"), log.getLogText());
        appendGenerationLogEntry(templateName, trigger);
        return html != null ? html : "";
    }

    private void appendGenerationLogEntry(String templateName, String trigger) {
        try {
            Files.createDirectories(COMPILER_OUTPUT_DIR);
            String line = "[" + LocalDateTime.now() + "] regenerated " + templateName + " (trigger: " + trigger + ")\n";
            appendToFile(COMPILER_OUTPUT_DIR.resolve("generation_log.txt"), line);
        } catch (IOException e) {
            System.err.println("warning: failed to append to generation_log.txt: " + e.getMessage());
        }
    }

    private static void appendToFile(Path path, String text) throws IOException {
        Files.writeString(path, text, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private static Integer pathId(String path, String prefix) {
        try {
            String rest = path.substring(prefix.length());
            int slash = rest.indexOf('/');
            if (slash >= 0) {
                rest = rest.substring(0, slash);
            }
            return Integer.parseInt(rest);
        } catch (Exception e) {
            return null;
        }
    }

    private static Map<String, String> parseFormBody(InputStream body) throws IOException {
        String raw = new String(body.readAllBytes(), StandardCharsets.UTF_8);
        Map<String, String> fields = new LinkedHashMap<>();
        for (String pair : raw.split("&")) {
            if (pair.isEmpty()) continue;
            int eq = pair.indexOf('=');
            String key = eq >= 0 ? pair.substring(0, eq) : pair;
            String value = eq >= 0 ? pair.substring(eq + 1) : "";
            fields.put(URLDecoder.decode(key, StandardCharsets.UTF_8), URLDecoder.decode(value, StandardCharsets.UTF_8));
        }
        return fields;
    }

    private static void serveStaticFile(HttpExchange exchange, Path dir, String prefix) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            sendPlainText(exchange, 405, "Method Not Allowed");
            return;
        }
        String path = exchange.getRequestURI().getPath();
        String filename = path.substring(prefix.length());
        Path file = dir.resolve(filename).normalize();
        if (!file.startsWith(dir) || !Files.exists(file) || Files.isDirectory(file)) {
            sendPlainText(exchange, 404, "Not found");
            return;
        }
        byte[] bytes = Files.readAllBytes(file);
        String contentType = guessContentType(filename);
        exchange.getResponseHeaders().add("Content-Type", contentType);
        exchange.sendResponseHeaders(200, bytes.length);
        try (var os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private static String guessContentType(String filename) {
        String lower = filename.toLowerCase();
        if (lower.endsWith(".css")) return "text/css";
        if (lower.endsWith(".js")) return "application/javascript";
        if (lower.endsWith(".png")) return "image/png";
        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return "image/jpeg";
        if (lower.endsWith(".gif")) return "image/gif";
        return "application/octet-stream";
    }

    private static void sendHtml(HttpExchange exchange, int status, String html) throws IOException {
        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/html; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (var os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private static void sendPlainText(HttpExchange exchange, int status, String text) throws IOException {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (var os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private static void redirectTo(HttpExchange exchange, String location) throws IOException {
        exchange.getResponseHeaders().add("Location", location);
        exchange.sendResponseHeaders(302, -1);
        exchange.close();
    }
}
