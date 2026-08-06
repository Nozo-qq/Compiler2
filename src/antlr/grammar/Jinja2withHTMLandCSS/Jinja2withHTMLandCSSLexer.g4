lexer grammar Jinja2withHTMLandCSSLexer;


/*=====================================================
 =  1) Skipped: Whitespace & Comments                  =
 =====================================================*/
WS              : [ \t\r\n]+      -> skip ;
JINJA_COMMENT   : '{#' .*? '#}'   -> skip ;
CSS_COMMENT     : '/*' .*? '*/'   -> skip ;
HTML_COMMENT    : '<!--' .*? '-->' -> skip ;

/*=====================================================
 =  2) Jinja2 Section                                  =
 =====================================================*/
BLOCK_START     : '{%' ;
BLOCK_END       : '%}' ;
FOR             : 'for' ;
END_FOR         : 'endfor' ;
IN              : 'in' ;
BOOL            : 'true' | 'false' ;

/*=====================================================
 =  3) HTML Section                                    =
 =====================================================*/
// --- Tag delimiters ---
OPEN_TAG_SLASH  : '</' ;   // closing tag start:  </div
OPEN_TAG        : '<'  ;   // opening tag start:  <div
SELF_CLOSED     : '/>' ;   // self-closing end:   <br/>
CLOSE_TAG       : '>'  ;   // tag end:            <div>

// --- Attributes ---
ASSIGN          : '=' ;    // attr="value"

// --- Entities ---
HTML_ENTITY     : '&' [a-zA-Z]+ ';'      // &nbsp;  &amp;
                | '&#' [0-9]+ ';'        // &#160;
                ;

/*=====================================================
 =  4) CSS Section                                     =
 =====================================================*/
CSS_UNIT        : 'px' | 'em' | 'rem' | '%' | 'vh' | 'vw' ;

fragment HEX    : [0-9a-fA-F] ;
CSS_COLOR       : '#' HEX HEX HEX (HEX HEX HEX)? ;
HASH            : '#' ;    // id selector: #main

/*=====================================================
 =  5) Shared Symbols & Operators                      =
 =====================================================*/
LCURLY          : '{' ;
RCURLY          : '}' ;
COLON           : ':' ;
SEMICOLON       : ';' ;
COMMA           : ',' ;
LPAREN          : '(' ;
RPAREN          : ')' ;
DOT             : '.' ;
NOT             : '!' ;
PLUS            : '+' ;
MINUS           : '-' ;
STAR            : '*' ;
DIVISION        : '/' ;

/*=====================================================
 =  6) Literals & Identifiers                          =
 =====================================================*/
STRING          : '"'  (~["\r\n])* '"'
                | '\'' (~['\r\n])* '\''
                ;
NUMBER          : ('-' | '+')? [0-9]+ ('.' [0-9]+)? ;

TAG_META        : 'meta' ;
TAG_LINK        : 'link' ;
TAG_INPUT       : 'input' ;
TAG_IMG         : 'img' ;

IDENTIFIER      : [a-zA-Z_$] [-a-zA-Z0-9_$]* ;
