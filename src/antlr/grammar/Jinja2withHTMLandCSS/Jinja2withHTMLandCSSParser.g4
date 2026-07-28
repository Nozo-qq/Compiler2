parser grammar Jinja2withHTMLandCSSParser;

options { tokenVocab=Jinja2withHTMLandCSSLexer; }

// HTML5 void elements never carry a closing tag, even without an explicit
// "/>". They must be resolved as such right at the tag-name token (before
// any recursive elementContent* is attempted) - ANTLR's adaptive prediction
// cannot safely evaluate a predicate positioned after a recursive closure,
// so the void/non-void decision has to happen this early to be reliable.
@parser::members {
    private static final java.util.Set<String> VOID_ELEMENTS = new java.util.HashSet<>(java.util.Arrays.asList(
        "area", "base", "br", "col", "embed", "hr", "img", "input",
        "link", "meta", "param", "source", "track", "wbr"
    ));
    private boolean isVoidElementName(String name) {
        return name != null && VOID_ELEMENTS.contains(name.toLowerCase());
    }
}

// --- نقطة البداية للملف ---
prog
    : jinja2Prog #jinja2
    | cssProg    #css
    ;

// قاعدة لحل تعارض الكلمات المحجوزة مع أسماء الخصائص
anyId
    : IDENTIFIER | FOR | IN | BOOL | END_FOR
    ;

// ================= JINJA2 & HTML =================

jinja2Prog
    : doctype? elementContent* EOF
    ;

doctype
    : OPEN_TAG NOT anyId anyId CLOSE_TAG  // مثال: <!DOCTYPE html>
    ;

// The void-element predicate must be the very first element of the alt, with
// zero tokens consumed beforehand - ANTLR's adaptive prediction only gates
// alternative selection on a predicate that guards the alt from its start.
// A predicate placed after already consuming tokens (e.g. after OPEN_TAG
// anyId) is invisible to prediction and only surfaces as a hard failure once
// parsing has already committed to the wrong alternative. _input.LT(2) reads
// the tag-name token via pure lookahead, without consuming it.
htmlelement
    : {isVoidElementName(_input.LT(2).getText())}?  OPEN_TAG anyId attribute* (SELF_CLOSD | CLOSE_TAG)                          #selfClosingTag
    | {!isVoidElementName(_input.LT(2).getText())}? OPEN_TAG anyId attribute* CLOSE_TAG elementContent* endTag[$anyId.text]     #openCloseTag
    ;

// The `expectedName` predicate rejects an endTag whose name doesn't match its
// startTag's. Without it, ANTLR happily pairs an unclosed void element (e.g.
// <input ...> with no </input> anywhere) with some unrelated later closing
// tag, since a bare CFG has no notion that open/close tag names must agree -
// silently producing a badly mis-nested tree instead of a syntax error.
endTag[String expectedName]
    : OPEN_TAG_SLASH anyId {$anyId.text.equals($expectedName)}? CLOSE_TAG
    ;

attribute
    : anyId ASSIGN attributeValue #fullAttr
    | anyId                       #booleanAttr
    ;

attributeValue
    : STRING
    ;

elementContent
    : htmlelement  #nestedElement
    | expression   #jinjaExpression
    | block        #jinjaBlock
    | statement    #textContent
    ;

statement
    : (anyId | COLON | LPAREN | RPAREN | DOT | COMMA | PLUS | MINUS | STAR | DIVISION)+
    ;

expression
    : LCURLY LCURLY exprContent RCURLY RCURLY
    ;

exprContent
    : memberAccess (LPAREN argList? RPAREN)?
    ;

// Orphan start rule - never reached via `prog`. Called directly from Java
// (parser.exprContentOnly()) to re-parse a `{{ ... }}` fragment extracted
// from inside an attribute value string.
exprContentOnly
    : exprContent EOF
    ;

argList
    : argItem (COMMA argItem)*
    ;

argItem
    : (anyId ASSIGN)? argValue
    ;

argValue
    : STRING
    | NUMBER
    | memberAccess
    ;

memberAccess
    : anyId (DOT anyId)*
    ;

block
    : BLOCK_START FOR anyId IN anyId BLOCK_END
      elementContent*
      BLOCK_START END_FOR BLOCK_END
    ;


// ================= CSS =================

cssProg
    : cssRule+ EOF
    ;

cssRule
    : cssSelectorList LCURLY cssDeclaration* RCURLY
    ;

cssSelectorList
    : cssSelector (COMMA cssSelector)*
    ;

cssSelector
    : simpleSelector (simpleSelector)* (COLON anyId)?
    ;

simpleSelector
    : anyId           #ElementSelector    // مثل: h1, div
    | DOT anyId       #ClassSelector      // مثل: .my-class
    | HASH anyId      #IdSelector         // مثل: #header
    ;

cssDeclaration
    : anyId COLON cssValue SEMICOLON      // هنا نلتقط اسم الخاصية (مثل: color)
    ;

cssValue
    : cssValueAtom+
    ;

cssValueAtom
    : NUMBER        #cssNumber
    | CSS_UNIT      #cssUnit
    | CSS_COLOR     #cssColor
    | anyId         #cssIdentifier
    | COMMA         #cssComma
    | MINUS         #cssMinus
    | STRING        #cssString
    | LPAREN        #cssLParen
    | RPAREN        #cssRParen
    ;