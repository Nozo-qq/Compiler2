lexer grammar FlaskExprLexer;

@header {
    import org.antlr.v4.runtime.*;
    import java.util.*;
}

@lexer::members {
    java.util.Stack<Integer> indents = new java.util.Stack<>();
    java.util.LinkedList<Token> pending = new java.util.LinkedList<>();
    boolean blockExpected = false;

    int parenLevel = 0;
    int bracketLevel = 0;
    int braceLevel = 0;

    private CommonToken virtual(int type, String text) {
        CommonToken t = new CommonToken(type, text);
        t.setStartIndex(_input.index());
        t.setStopIndex(_input.index() - 1);
        t.setLine(getLine());
        t.setCharPositionInLine(getCharPositionInLine());
        return t;
    }

    void handleNewline() {
        String indent = "";
        int c;
        while ((c = _input.LA(1)) == ' ' || c == '\t') {
            indent += (char)c;
            _input.consume();
        }
        int indentLevel = indent.length();
        if (_input.LA(1) == '\r' || _input.LA(1) == '\n' || _input.LA(1) == -1) return;

        int prev = indents.isEmpty() ? 0 : indents.peek();

        if (blockExpected) {
            indents.push(indentLevel);
            pending.add(virtual(BLOCKSTART, "<BLOCKSTART>"));
            blockExpected = false;
        } else if (indentLevel > prev) {
            throw new RuntimeException("Unexpected indentation");
        } else {
            while (!indents.isEmpty() && indents.peek() > indentLevel) {
                indents.pop();
                pending.add(virtual(BLOCKEND, "<BLOCKEND>"));
            }
            if (!indents.isEmpty() && indents.peek() != indentLevel) {
                    throw new RuntimeException("Inconsistent indentation");
            }
        }
    }

    @Override
    public Token nextToken() {
        while (true) {
            if (!pending.isEmpty()) return pending.pollFirst();

            Token t = super.nextToken();
            if (t.getType() == EOF) {
                while (!indents.isEmpty()) {
                    indents.pop();
                    pending.add(virtual(BLOCKEND, "<BLOCKEND>"));
                }
                if (!pending.isEmpty()) continue;
                return t;
            }
            if (t.getType() == NEWLINE) {
                if (parenLevel == 0 && bracketLevel == 0 && braceLevel == 0) {
                    handleNewline();
                }
                continue;
            }
            return t;
        }
    }
}

//Tokens
LPAREN  : '('  { parenLevel++; } ;
RPAREN  : ')'  { parenLevel--; } ;
LBRACK  : '['  { bracketLevel++; } ;
RBRACK  : ']'  { bracketLevel--; } ;
LBRACE  : '{'  { braceLevel++; } ;
RBRACE  : '}'  { braceLevel--; } ;

ATSIGN  : '@' ;
DOT     : '.' ;
COMMA   : ',' ;
COLON   : ':' {
    if (parenLevel == 0 && bracketLevel == 0 && braceLevel == 0) {
        blockExpected = true;
    }
};
ASSIGN  : '=' ;
EQ      : '==' ;
PLUS    : '+' ;
MINUS   : '-' ;
STAR    : '*' ;
SLASH   : '/' ;
BREAK   : 'break';
CONTINUE: 'continue';


DEF     : 'def' ;
IF      : 'if' ;
ELSE    : 'else' ;
FOR     : 'for' ;
IN      : 'in' ;
FROM    : 'from' ;
IMPORT  : 'import' ;
RETURN  : 'return' ;
TRUE    : 'True' ;
FALSE   : 'False' ;
NONE    : 'None' ;

NAME    : [a-zA-Z_][a-zA-Z0-9_]* ;
NUMBER  : '-'? [0-9]+ ('.' [0-9]+)? ;
STRING  : '"'  (~["\\] | '\\' .)* '"'
        | '\'' (~['\\] | '\\' .)* '\'' ;

NEWLINE : '\r'? '\n' ;
WS      : [ \t]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;

BLOCKSTART : '<BLOCKSTART>' ;
BLOCKEND   : '<BLOCKEND>' ;


GT   : '>' ;
LT   : '<' ;
GTE  : '>=' ;
LTE  : '<=' ;
NEQ  : '!=' ;


