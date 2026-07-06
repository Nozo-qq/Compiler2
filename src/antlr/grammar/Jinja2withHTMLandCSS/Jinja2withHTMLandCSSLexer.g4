lexer grammar Jinja2withHTMLandCSSLexer;

// --- تجاهل المسافات والتعليقات ---
WS                : [ \n\t\r]+ -> skip;
JINJA_COMMENT     : '{#' .*? '#}' -> skip ;
CSS_COMMENT       : '/*' .*? '*/' -> skip ;

// --- الكلمات المفتاحية لـ Jinja2 ---
BLOCK_START       : '{%';
BLOCK_END         : '%}';
FOR               : 'for';
END_FOR           : 'endfor';
IN                : 'in';
BOOL              : 'true' | 'false' ;

// --- الرموز والأقواس ---
LCURLY            : '{';
RCURLY            : '}';
ASSIGN            : '=';
NOT               : '!';
OPEN_TAG          : '<';
OPEN_TAG_SLASH    : '</';
CLOSE_TAG         : '>';
SELF_CLOSD        : '/>';
COLON             : ':';
SEMICOLON         : ';';
COMMA             : ',';
LPAREN            : '(';
RPAREN            : ')';
DOT               : '.';
PLUS              : '+';
MINUS             : '-';
STAR              : '*';
DIVISION          : '/';

// --- القيم (نصوص، أرقام، وحدات CSS) ---
STRING            : '"' (~["\r\n])* '"'
                  | '\'' (~["\r\n])* '\'' ;
NUMBER            : ('-' | '+')? [0-9]+ ('.' [0-9]+)? ;
CSS_UNIT          : 'px' | 'em' | 'rem'| '%' | 'vh' | 'vw';

// --- الألوان (Hex Colors) ---
fragment HEX      : [0-9a-fA-F];
CSS_COLOR         : '#' HEX HEX HEX (HEX HEX HEX)?;

HASH              : '#';

// --- المعرّف الشامل (الجوهر) ---
IDENTIFIER        : [a-zA-Z_$][-a-zA-Z0-9_$]*;