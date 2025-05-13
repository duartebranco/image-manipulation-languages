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
    | imageStatement
    | placeStatement
    | COMMENT
    ;

variableDeclaration
    : type ID 'is' expression
    ;

assignment
    : ID 'is' expression
    ;

ifStatement
    : 'if' expression 'then' statement+ ('else' statement+)? 'done'
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

imageStatement
    : 'image' 'size' expression 'by' expression 'background' expression
    ;

placeStatement
    : 'place' shape 'radius' expression 'at' expression expression 'with' 'intensity' expression
    ;

shape
    : 'circle'
    | 'rect'
    | 'cross'
    | 'plus'
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
    | left=expression operator=('*'|'/') right=expression           #arithmeticExpr
    | left=expression operator=('+'|'-') right=expression           #arithmeticExpr
    | left=expression operator=('.*'|'.+') right=expression         #imageArithmeticExpr
    | left=expression operator=('.-'|'-*'|'|*') right=expression    #imageArithmeticExpr
    | left=expression operator=('!='|'==') right=expression         #comparisonExpr
    ;

primary
    : ID
    | NUMBER
    | PERCENTAGE
    | STRING
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

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;