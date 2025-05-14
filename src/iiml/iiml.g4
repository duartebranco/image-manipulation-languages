grammar iiml;

program
    : statement* EOF
    ;

statement
    : variableDeclaration
    | assignment
    | imageStatement
    | placeStatement
    | outputStatement
    | COMMENT
    ;

variableDeclaration
    : type ID 'is' expression
    ;

assignment
    : ID 'is' expression
    ;

outputStatement
    : 'output' expression
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
    : primary                                              #primaryExpr
    | 'read' STRING                                        #readExpr
    | 'number' '(' expression ')'                          #numberConversionExpr
    | 'string' '(' expression ')'                          #stringConversionExpr
    | '(' expression ')'                                   #parenExpr
    | left=expression operator=('*'|'/') right=expression  #arithmeticMulDivExpr
    | left=expression operator=('+'|'-') right=expression  #arithmeticAddSubExpr
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
