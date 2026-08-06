parser grammar Jinja2withHTMLandCSSParser;

options { tokenVocab=Jinja2withHTMLandCSSLexer; }


// --- نقطة البداية للملف ---
prog
    : jinja2Prog #jinja2
    | cssProg    #css
    ;

// قاعدة لحل تعارض الكلمات المحجوزة مع أسماء الخصائص
anyId
    : IDENTIFIER | FOR | IN | BOOL | END_FOR
    | TAG_META | TAG_LINK | TAG_INPUT | TAG_IMG
    ;
// ================= JINJA2 & HTML =================

jinja2Prog
    : doctype? elementContent* EOF
    ;

doctype
    : OPEN_TAG NOT anyId anyId CLOSE_TAG  // مثال: <!DOCTYPE html>
    ;

htmlelement
    : OPEN_TAG voidTagName attribute* (SELF_CLOSED | CLOSE_TAG)    #selfClosingTag
    | startTag elementContent* endTag                              #openCloseTag
    ;

startTag
    : OPEN_TAG tagName attribute* CLOSE_TAG
    ;

endTag
    : OPEN_TAG_SLASH tagName CLOSE_TAG
    ;

tagName
    : anyId
    ;

voidTagName
    : TAG_META | TAG_LINK | TAG_INPUT | TAG_IMG
    ;

attribute
    : attributeName ASSIGN attributeValue #fullAttr
    | attributeName                       #booleanAttr
    ;

attributeName
    : anyId
    ;

attributeValue
    : STRING
    ;

elementContent
    : htmlelement     #nestedElement
    | expression      #jinjaExpression
    | block           #jinjaBlock
    | jinjaStatement  #jinjaGenericStatement
    | statement       #textContent
    ;

// قاعدة عامة لتعليمات Jinja مثل: {% set x = 10 %}
jinjaStatement
    : BLOCK_START IDENTIFIER (anyId | ASSIGN | NUMBER | STRING | DOT | COMMA | LPAREN | RPAREN | PLUS | MINUS | STAR | DIVISION)* BLOCK_END
    ;

statement
    : (anyId | HTML_ENTITY | NUMBER | NOT | COLON | LPAREN | RPAREN | DOT | COMMA | PLUS | MINUS | STAR | DIVISION)+
    ;

expression
    : LCURLY LCURLY memberAccess RCURLY RCURLY
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