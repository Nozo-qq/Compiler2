package server;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * In-memory mirror of app.py's module-level state ("products" plus any other
 * top-level static variable Context Data extraction found), mutated only
 * through the same operations app.py's routes perform (add / soft-delete).
 * All access is synchronized on one lock so a request can't observe or
 * persist a half-applied mutation from another concurrent request.
 */
public class ProductStore {

    private final Object lock = new Object();
    private final List<Map<String, Object>> products = new ArrayList<>();
    private final Map<String, Object> variables = new LinkedHashMap<>();

    @SuppressWarnings("unchecked")
    public void seed(Map<String, Object> staticAssignments) {
        synchronized (lock) {
            products.clear();
            variables.clear();
            for (Map.Entry<String, Object> entry : staticAssignments.entrySet()) {
                if ("products".equals(entry.getKey()) && entry.getValue() instanceof List<?> list) {
                    for (Object item : list) {
                        if (item instanceof Map<?, ?> map) {
                            products.add(new LinkedHashMap<>((Map<String, Object>) map));
                        }
                    }
                } else {
                    variables.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public List<Map<String, Object>> visibleProducts() {
        synchronized (lock) {
            List<Map<String, Object>> visible = new ArrayList<>();
            for (Map<String, Object> p : products) {
                if (!Boolean.TRUE.equals(p.get("deleted"))) {
                    visible.add(p);
                }
            }
            return visible;
        }
    }

    public Map<String, Object> findVisibleProduct(int id) {
        synchronized (lock) {
            for (Map<String, Object> p : products) {
                if (asInt(p.get("id")) == id) {
                    if (!Boolean.TRUE.equals(p.get("deleted"))) {
                        return p;
                    }
                    break;
                }
            }
            return null;
        }
    }

    /** Mirrors add_product()'s POST logic: next id = max existing id + 1. */
    public Map<String, Object> addProduct(Map<String, String> formFields) {
        synchronized (lock) {
            int newId = 1;
            if (!products.isEmpty()) {
                int maxId = asInt(products.get(0).get("id"));
                for (Map<String, Object> p : products) {
                    int id = asInt(p.get("id"));
                    if (id > maxId) {
                        maxId = id;
                    }
                }
                newId = maxId + 1;
            }

            Map<String, Object> newProduct = new LinkedHashMap<>();
            newProduct.put("id", newId);
            newProduct.put("name", formFields.get("name"));
            newProduct.put("price", parsePrice(formFields.get("price")));
            newProduct.put("description", formFields.get("description"));
            newProduct.put("image", formFields.get("image"));
            newProduct.put("deleted", false);

            products.add(newProduct);
            return newProduct;
        }
    }

    /** Mirrors the new delete_product() route: flags rather than removes. */
    public boolean deleteProduct(int id) {
        synchronized (lock) {
            for (Map<String, Object> p : products) {
                if (asInt(p.get("id")) == id) {
                    p.put("deleted", true);
                    return true;
                }
            }
            return false;
        }
    }

    public Map<String, Object> getVariables() {
        synchronized (lock) {
            return new LinkedHashMap<>(variables);
        }
    }

    private static int asInt(Object value) {
        if (value instanceof Number n) {
            return n.intValue();
        }
        return -1;
    }

    private static double parsePrice(String raw) {
        try {
            return Double.parseDouble(raw);
        } catch (NumberFormatException | NullPointerException e) {
            return 0.0;
        }
    }
}
