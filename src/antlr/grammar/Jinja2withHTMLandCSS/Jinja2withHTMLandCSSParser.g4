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
    ;

// ================= JINJA2 & HTML =================

jinja2Prog
    : doctype? elementContent* EOF
    ;

doctype
    : OPEN_TAG NOT anyId anyId CLOSE_TAG  // مثال: <!DOCTYPE html>
    ;

htmlelement
    : startTag elementContent* endTag                          #openCloseTag
    | OPEN_TAG anyId attribute* (SELF_CLOSD | CLOSE_TAG)       #selfClosingTag
    ;

startTag
    : OPEN_TAG anyId attribute* CLOSE_TAG
    ;

endTag
    : OPEN_TAG_SLASH anyId CLOSE_TAG
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