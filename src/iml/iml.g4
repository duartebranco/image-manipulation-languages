grammar iml;

program
    : (functionDecl | statement)* EOF
    ;

functionDecl
    : 'function' ID '(' paramList? ')' ( 'returns' type )? 'is' statement* ('return' expression)? 'end'
    ;

paramList
    : param (',' param)*
    ;

param
    : type ID
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
    | tryCatchStatement
    | exitStatement
    | COMMENT
    ;

exitStatement
    : 'exit'
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

tryCatchStatement
    : 'try' tryBlock+=statement+ 'catch' catchBlock+=statement+ 'end'
    ;

expression
    : primary                                                       #primaryExpr
    | ID '(' (expression (',' expression)*)? ')'                    #functionCallExpr
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
    | 'all' 'pixel' expression operator=('>'|'.>') NUMBER           #allPixelExpr
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
    | left=expression operator=('!='|'=='|'>'|'<'|'>='|'<=' ) right=expression   #comparisonExpr
    | left=expression operator=('+'|'-'|'*'|'/') right=expression   #arithmeticExpr
    | left=expression operator=('.>'|'.<'|'.=='|'.!='|'.&'|'.|') right=expression   #pixelBoolOperationExpr
    | operator='.!' expression                                      #unaryPixelBoolOperationExpr
    ;

primary
    : ID
    | NUMBER
    | PERCENTAGE
    | STRING
    | BOOLEAN
    | list
    | primary '[' expression ']'
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
    | 'list ' 'of ' type
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

BOOLEAN
    : 'true'
    | 'false'
    ;
    
ID
    : [a-zA-Z][a-zA-Z0-9_]*
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;