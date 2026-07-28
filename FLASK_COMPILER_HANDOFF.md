# Flask Compiler — Handoff Document (Generation Phase)

**Written:** 2026-07-28
**Source project:** `C:\Projects\CompilerProject` (the Flask/Python compiler half of the multi-team compiler project)
**Audience:** whoever is working on the Jinja/HTML/CSS compiler half of the same overall project, in a separate repo/session.

This document describes what was built in this session so that work on the other half of the project can continue with full context, without needing access to this conversation.

---

## 1. Project background

The overall course project ("مشروع المترجمات 2") is built by (at least) two cooperating teams/parts:

1. **Flask/Python side** (this repo) — parses a Flask-style `app.py`, validates it, and extracts the data that gets handed to Jinja templates.
2. **Jinja/HTML/CSS side** (the other repo/session this document is for) — parses `.jinja`/`.html`/`.css` templates and, using the data produced by side 1, generates the final rendered HTML.

Per the course announcement, the conceptual pipeline is:

```
app.py → Python Parser → Python AST → Semantic Analysis → Generator → Context Data
                                                                          ↓
                                                                  render_template()
                                                                          ↓
templates/*.jinja → Jinja Parser → Jinja AST → variable substitution → HTML → browser
```

The key point: the Flask side's "Generator" does **not** produce a runnable program. It produces **Context Data** — the concrete variable values that would be passed into `render_template()` — which is exactly the artifact this session built.

The announcement also specifies a `compiler_output/` folder holding the analysis/generation artifacts:
- `ast_python.json` (Flask side — **done, this session**)
- `ast_jinja.json` (Jinja side — **not our responsibility, not built here**)
- `semantic_report.txt` (Flask side — **done, this session**)
- `generation_log.txt` (Flask side — **done, this session**)

This session also produces a file not explicitly named in the announcement but required for the actual hand-off to work: **`compiler_output/context_data.json`** — see Section 4, this is the file the Jinja side should consume.

---

## 2. What existed before this session

The Flask-side repo already had (untouched by this session, considered "done" per the project owner):
- An ANTLR grammar + AST for the Flask/Python subset (`src/FlaskStatement/*`, `src/antlr/grammar/flask/AntlrToProgram.java`, `ASTStatementsBuilderVisitor.java`, `AntlrToExpression.java`)
- A semantic analyzer (`src/antlr/grammar/flask/SemanticAnalyzer.java` + `Scope.java`) that validates the AST (undefined names, redefinitions, non-callable calls, etc.) and throws on the first error (fail-fast)
- A `SymbolsTable` singleton (`src/SymbolsTable/SymbolsTable.java`) — populated during AST-building but not actually consulted by anything downstream (effectively dead/debug-only)

What did **not** exist and was replaced/added this session: the "generation phase" previously translated the AST into a full runnable PHP program (`PHPCodeGenerator.java`) and wrote it to the Desktop. That approach did not match what the announcement describes, so it was replaced.

---

## 3. What this session built

### 3.1 New package `src/output/`

| Class | Responsibility |
|---|---|
| `JsonWriter.java` | Generic hand-rolled JSON emitter (the project has no Maven/Gradle and no JSON library — only a manually-added `antlr-4.13.2-complete.jar` — so JSON serialization is written from scratch). Handles `Map`, `List`, `String` (proper `\"`/`\\`/control-char escaping), `Long`/`Integer`/`Double`/`BigInteger`/`Boolean`, `null`. Pretty-printed, 2-space indent, empty containers render as `{}`/`[]`. |
| `PyLiteralUtil.java` | Works around a known quirk in the existing AST layer: string literals and dict keys retain their raw source quote characters and unprocessed escape sequences (e.g. a Python `"Phone"` literal is stored internally as the 7-character string `"Phone"` including the quotes). `unquoteString()` strips the quotes and does minimal unescaping. This is the **only** place that quirk is worked around — the AST classes themselves were **not modified**. |
| `StaticValueResolver.java` | Recursively evaluates an AST `Expression` into a plain Java value (`String`/`Long`/`Integer`/`Double`/`BigInteger`/`Boolean`/`null`/`List<Object>`/`LinkedHashMap<String,Object>`), resolving `Name` references against a map of already-known top-level static assignments. Throws `UnresolvableException` for anything that can't be known at compile time (function calls, binary operations, attribute/subscript access, undefined names). |
| `ContextDataGenerator.java` | **The core deliverable.** Walks each top-level route-handler function, finds every `render_template(...)` call anywhere in its body (not just direct returns), resolves the template name and each keyword argument statically where possible, and produces a map of `template name → resolved kwargs`. Also produces a human-readable generation log explaining every skipped/unresolvable value and any key collisions. See Section 4 for the exact output contract. |
| `AstJsonSerializer.java` | Serializes the full, semantically-validated AST (`Program`) into JSON — every node type in `src/FlaskStatement/*` becomes a `{"type": ..., "line": ..., ...fields}` object, recursively. String literal values and dict keys are cleaned via `PyLiteralUtil` so this JSON file does not leak the raw-quote AST quirk. |
| `SemanticReportWriter.java` | Builds `semantic_report.txt` text: on success, `Status: PASSED` plus a list of top-level function/variable names; on failure, `Status: FAILED` plus the single error message (semantic analysis is still fail-fast — see Section 5). |

### 3.2 Modified files (minimal, additive only)

- **`src/antlr/grammar/flask/Scope.java`** — added one read-only getter: `public Map<String,Object> getSymbols()`. No existing logic changed.
- **`src/antlr/grammar/flask/SemanticAnalyzer.java`** — added one read-only getter: `public Scope getCurrentScope()`. No existing logic changed. (Safe to call after `analyze()` returns successfully — verified that on success, `currentScope` is always back at the global scope.)
- **`src/Main.java`** — rewired the tail end of the pipeline:
  - Removed the blocking `Trees.inspect(tree, parser)` Swing GUI popup (not headless-safe, superseded by `ast_python.json`).
  - Removed the call to `PHPCodeGenerator` and the Desktop write of `output.php`.
  - Now creates `compiler_output/` (project-relative) and writes all four artifacts described below.
  - Kept the existing stdout debug dumps (`SymbolsTable.printFlaskSymbols()`, `ASTPrettyPrinter.print()`).

### 3.3 Explicitly NOT changed

- **`src/antlr/grammar/flask/PHPCodeGenerator.java`** — left in the repo untouched, just no longer called from `Main`. (Project owner's explicit choice — not deleted in case it's wanted for reference later.)
- No bug fixes were applied to the AST-building or semantic-analysis layers, even though several pre-existing issues were found and reported (see Section 6). The project owner deferred those explicitly ("we will come to that later").
- Nothing under `src/ASTJinja2withHTMLandCSS/` or `src/antlr/grammar/Jinja2withHTMLandCSS/` was touched — that is the other team's grammar/AST and is out of scope for this repo's work.

---

## 4. The hand-off contract: `compiler_output/context_data.json`

**This is the file the Jinja/HTML side should read.**

### Shape

A JSON object keyed by **template filename exactly as it appears as the first argument to `render_template(...)` in the source `app.py`** (a string literal — e.g. `"index.html"`, not necessarily `.jinja`; whatever the actual Flask app passes). Each value is a flat JSON object: keyword-argument name → resolved value, i.e. exactly the kwargs that specific `render_template()` call site passed.

- If a template is rendered with no kwargs, or all its kwargs are unresolvable, it still appears in the file with an **empty object** `{}` (so the Jinja side can tell "this template exists and was reached" apart from "this template was never rendered at all").
- If the *same* template name is rendered from multiple call sites, their kwargs are merged into one entry; a later call's key overwrites an earlier one with the same name (logged as a collision in `generation_log.txt`, see Section 4.2).
- Values can be: JSON string, number, boolean, `null`, nested JSON array, or nested JSON object — mirroring whatever Python literal structure was in the source (lists of dicts, nested dicts, etc.), recursively.

### Real example (from this repo's test fixture, `Testing Project/FlaskTestingApp/app.py`)

```json
{
  "index.html": {
    "products": [
      { "id": 1, "name": "Laptop", "price": 999, "description": "Fast and reliable laptop.", "image": "laptop.jpg" },
      { "id": 2, "name": "Phone", "price": 499, "description": "High-quality \\camera smartphone.", "image": "phone.jpg" },
      { "id": 3, "name": "Headphones", "price": 199, "description": "Noise-cancelling headphones.", "image": "headphones.jpg" }
    ]
  },
  "product.html": {},
  "add_product.html": {}
}
```

Note `product.html` is `{}` here because that route renders `render_template("product.html", product=product)` where `product` is a **loop-local** variable (not a top-level static value) — it cannot be known without actually running the Python code, so it's correctly omitted rather than guessed. This is documented in `generation_log.txt` (see below), and is an **expected, common case** — not a bug.

### 4.1 What is and isn't included — important for the other side to understand

This is a **static** extractor, not an interpreter. Only values that are knowable purely from reading the source (without executing it) appear in `context_data.json`:

**Included:**
- Literal values (strings, numbers, booleans, `None`→`null`)
- Lists/dicts of literals, arbitrarily nested
- References (`Name` nodes) to **top-level module-level variables** whose right-hand side was itself statically resolvable (e.g. `products = [...]` at module scope)

**Excluded (silently, but logged):**
- Anything computed at request time — `request.form[...]`, function calls, arithmetic/comparison expressions, subscripts/attributes on non-static values
- Local variables (function parameters, loop variables, anything assigned inside a route handler) — these are not in scope for the static top-level lookup
- Any `render_template()` call whose template-name argument itself isn't a static string

**Practical implication for the Jinja side:** if a template variable you expect isn't present in `context_data.json`, check `generation_log.txt` first — it will almost always explain exactly why (see below) rather than it being a missing feature.

### 4.2 `compiler_output/generation_log.txt` — companion log

Plain text, one line per event, plus a summary footer. Real example from the same run:

```
info: top-level assignment 'app' skipped (not statically resolvable: FunctionCall)
product.html: skipped kwarg 'product' — not statically resolvable (Name 'product' (not a known top-level static assignment))
---
Summary: templates=3, resolvedKwargs=1, skippedKwargs=1, collisions=0
```

Line types:
- `info: top-level assignment '<name>' skipped (...)` — a module-level `name = ...` wasn't statically resolvable (e.g. `app = Flask(__name__)`); expected/normal, not an error.
- `warning: render_template call in function '<fn>' at line <N> — ...` — a whole `render_template()` call was skipped (missing or non-static template-name argument).
- `<template>: skipped kwarg '<key>' — not statically resolvable (<reason>)` — one specific kwarg for one specific template couldn't be resolved.
- `<template>: kwarg '<key>' overwritten by later render_template call in function '<fn>' at line <N>` — a collision between two call sites rendering the same template.
- Final `Summary:` line — counts of templates found, kwargs resolved, kwargs skipped, collisions.

---

## 5. `compiler_output/semantic_report.txt`

Semantic analysis is (deliberately, per project-owner decision) still **fail-fast** — it stops at the first error, unchanged from before this session. The report reflects that:

**On success:**
```
Semantic Analysis Report
Generated: <timestamp>
Status: PASSED

Top-level functions (4):
  - images
  - home
  - product_details
  - add_product

Top-level variables (2):
  - app
  - products
```

**On failure** (verified with an injected undefined-variable error):
```
Semantic Analysis Report
Generated: <timestamp>
Status: FAILED

Error: SemanticError: NameError: Variable 'undefined_var_reference_test' is not defined at line 83
```

On failure, `Main` still exits with code 1 (unchanged behavior) and `ast_python.json`/`context_data.json`/`generation_log.txt` are **not** (re)written for that run — only `semantic_report.txt` is updated. Any stale files from a previous successful run remain on disk.

---

## 6. `compiler_output/ast_python.json`

The full AST, one JSON object per node with `"type"`, `"line"`, and node-specific fields, recursing through children. Every class in `src/FlaskStatement/` is covered (`Program`, `Assignment`, `FunctionDef`, `IfStatement`, `ForStatement`, `Name`, `Literal`, `ListExpr`, `DictExpr`, `BinaryOperation`, `Attribute`, `Subscript`, `FunctionCall`, `ImportStatement`, `Decorator`, `ReturnStatement`, `Break`/`ContinueStatement`, `ExpressionStatement`). String values and dict keys are cleaned (unquoted/unescaped) the same way as in `context_data.json`. This is mainly useful for debugging/cross-checking; the Jinja side most likely only needs `context_data.json`.

Only written when semantic analysis passes.

---

## 7. Known pre-existing issues in the Flask AST/semantic layers (not fixed, reported only)

These existed before this session and were explicitly left alone per the project owner's instruction ("do not touch anything in them... we will come to that later"). Listed here so the Jinja side isn't surprised by related edge cases if `app.py` ever hits them:

- String literals and dict keys in the AST retain raw quote characters/unescaped backslashes at the source (`AntlrToExpression.java`) — worked around downstream in this session's new code, not fixed at the source.
- `if/elif/else` is not actually supported by the grammar — `else`/`elif` branches are silently dropped (`IfStatement.getElseBody()` is always empty).
- `ContinueStatement` and `ImportStatement` are not handled by generic statement-walking code (including the new `ContextDataGenerator`) — they're effectively no-ops.
- No boolean `and`/`or`/`not`, no ternary expressions, no comprehensions, no f-strings, no tuple unpacking, no augmented assignment (`+=`) — the grammar is a limited Python subset.
- `Attribute.toString()` is broken (returns the literal string `"Attribute"`), and `SemanticAnalyzer`'s assignment-target-name derivation (`assign.getLeft().toString()`) is fragile for non-`Name` left-hand sides.
- Three separate/overlapping symbol-tracking mechanisms exist in the codebase (`SymbolsTable`, a write-only `Scope` inside the AST builder, and `SemanticAnalyzer`'s own real `Scope` chain) — only the last one is actually functional.

None of this affects the correctness of `context_data.json` for `app.py` files that stick to a simple, flat style (module-level data + straightforward route handlers, as in the current test fixture) — it's flagged here mainly for awareness if more complex Flask apps are tested later.

---

## 8. How to (re)generate the artifacts

The project has no Maven/Gradle — it's a plain source tree compiled manually with `javac` against the one dependency jar. From the repo root (`C:\Projects\CompilerProject`):

```bash
# compile
javac -encoding UTF-8 -cp "dependencies/antlr-4.13.2-complete.jar" -d build_out $(find src -name "*.java")

# run (reads Testing Project/FlaskTestingApp/app.py by default — hardcoded relative path in Main.java)
java -cp "build_out;dependencies/antlr-4.13.2-complete.jar" Main
```

Output appears in `compiler_output/` at the repo root: `ast_python.json`, `context_data.json`, `semantic_report.txt`, `generation_log.txt`.

To point at a different `app.py`, edit the hardcoded path in `Main.java` (`Files.readString(Paths.get("Testing Project/FlaskTestingApp/app.py"))`) — this was not made configurable in this session.

---

## 9. Open questions for the two teams to resolve together (not decided in this session)

1. **File hand-off mechanism**: `context_data.json` is written to this repo's local `compiler_output/` folder. Since the Jinja/HTML side lives in a *separate* repo/project, the two sides need to agree on how the file actually gets from one to the other in the full end-to-end build (shared working directory? one side copies/reads the other's output path? a monorepo layout for the final submission?). This wasn't addressed here — flagging it as the main integration gap.
2. **`output/` folder** (final rendered HTML + copied `app.py`/`style.css`/`script.js`, per the announcement) was not built by this session — unclear which side (or a third orchestration step) is responsible for assembling it.
3. **`ast_jinja.json`** is the Jinja side's own artifact, not produced here.
4. Template filenames in `context_data.json` come directly from whatever string literal appears in the `render_template(...)` call in `app.py` (currently `"index.html"`/`"product.html"`/`"add_product.html"` in the test fixture) — worth confirming this naming matches whatever the Jinja side's template files are actually called, since the original announcement's example used `.jinja` extensions.
