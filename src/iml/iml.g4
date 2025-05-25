grammar iml;

program
    : statement* EOF
    ;

statement
    : variableDeclaration
    | assignment
    | ifStatement
    | forStatement
    | untilStatement
    | outputStatement
    | drawStatement
    | storeStatement
    | appendStatement
    | COMMENT
    ;

variableDeclaration
    : type ID ('is' expression)?
    ;

assignment
    : ID 'is' expression
    ;

ifStatement
    : 'if' expression 'then' thenStmts+=statement+ ('else' elseStmts+=statement+)? 'done'
    ;

forStatement
    : 'for' type ID 'within' expression 'do' statement+ 'done'
    ;

untilStatement
    : 'until' expression 'do' statement+ 'done'
    ;

outputStatement
    : 'output' expression
    ;

drawStatement
    : 'draw' expression
    ;

storeStatement
    : expression 'store' 'into' STRING
    ;

appendStatement
    : ID 'append' expression
    ;

expression
    : primary                                                       #primaryExpr
    | expression 'open' 'by' expression                             #openExpr
    | expression 'close' 'by' expression                            #closeExpr
    | expression 'dilate' 'by' expression                           #dilateExpr
    | expression 'erode' 'by' expression                            #erodeExpr

    | expression 'top' 'hat' 'by' expression                        #topHatExpr
    | expression 'black' 'hat' 'by' expression                      #blackHatExpr

    | 'load' 'from' expression                                      #loadExpr
    | 'run' 'from' expression                                       #runExpr

    | 'read' STRING                                                 #readExpr
    | 'count' 'pixel' expression 'in' expression                    #countPixelExpr
    | 'any' 'pixel' expression operator=('>'|'.>') NUMBER           #anyPixelExpr
    | 'columns' 'of' expression                                     #columnsExpr
    | 'rows' 'of' expression                                        #rowsExpr
    | 'string' '(' expression ')'                                   #stringConversionExpr
    | 'number' '(' expression ')'                                   #numberConversionExpr
    | '(' expression ')'                                            #parenExpr

    // unary flip op (vertical, horizontal, both, respectivaly)
    | operator=('-'|'|'|'+') expression                             #flipExpr
    // scale op (vertical, horizontal, both, respectivaly)       
    | left=expression operator=('|*'|'-*'|'+*') right=expression    #scaleExpr
    // pixel by pixel operations
    | left=expression operator=('.*'|'.+'|'.-'|'.|') right=expression    #pixelOperationExpr
    // unary pixel operations
    | operator='.-' expression                                      #unaryPixelOperationExpr
    | left=expression operator=('!='|'==') right=expression         #comparisonExpr
    | left=expression operator=('+'|'-'|'*'|'/') right=expression   #arithmeticExpr
    ;

primary
    : ID
    | NUMBER
    | PERCENTAGE
    | STRING
    | BOOLEAN
    | list
    ;

list
    : '[' (expression (',' expression)*)? ']'
    ;

type
    : 'image'
    | 'number'
    | 'string'
    | 'percentage'
    | 'boolean'
    | 'list' 'of' type
    ;

PERCENTAGE
    : [0-9]+ '%'
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

STRING
    : '"' ~["\r\n]* '"'
    ;

ID
    : [a-zA-Z][a-zA-Z0-9_]*
    ;

BOOLEAN
    : 'true'
    | 'false'
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;