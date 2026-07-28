parser grammar FlaskExprParser;

options { tokenVocab=FlaskExprLexer; }

program : statement* EOF ;

// Statements can be decorated or plain
statement
    : importstatement          # Import
    | assignment          # Assign
    | returnStmt          # Return
    | expr                # ExprStmt
    | BREAK               # Break
    | CONTINUE            # Continue
    | decorator* functionDef          # FunctionDefstatementment
    | ifstatement               # Ifstatementment
    | forstatement                         # Forstatementment
    ;

// Decorator: @expr
decorator
    : ATSIGN expr
    ;

// Compound statementements
functionDef
    : DEF NAME LPAREN (NAME (COMMA NAME)*)? RPAREN COLON  BLOCKSTART statement* BLOCKEND
    ;

forstatement
    : FOR NAME IN expr COLON  BLOCKSTART statement* BLOCKEND
    ;

ifstatement
    : IF expr COLON  BLOCKSTART statement* BLOCKEND
    ;




// Import
importstatement  : FROM packageName IMPORT importList ;
packageName : NAME (DOT NAME)* ;
importList  : NAME (COMMA NAME)* ;

// Assignment and return
assignment  : expr ASSIGN expr ;
returnStmt  : RETURN expr? ;

// Expressions
expr
    : LPAREN expr RPAREN               # Parens
    | expr LPAREN ( (expr | NAME ASSIGN expr) (COMMA (expr | NAME ASSIGN expr))*)? RPAREN # FunctionCall
    | expr LBRACK expr RBRACK           # Subscript
    | expr STAR expr                    # Multiplication
    | expr SLASH expr                   # Division
    | expr PLUS expr                    # Addition
    | expr MINUS expr                   # Subtraction
    | expr (GT | LT | GTE | LTE | EQ | NEQ) expr   # Comparison
    |expr DOT NAME                     # Attribute
    | NAME                              # Var
    | NUMBER                            # Number
    | STRING                            # String
    | TRUE                              # TrueLit
    | FALSE                             # FalseLit
    | NONE                              # NoneLit
    | LBRACK (expr (COMMA expr)*)? RBRACK    # List
    | LBRACE (STRING COLON expr (COMMA STRING COLON expr)*)? RBRACE                         # Dict
    ;

