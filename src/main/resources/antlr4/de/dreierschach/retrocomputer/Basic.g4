grammar Basic;

program: line (NL+ line)* NL* EOF ;

line: NUMBER statement (':' statement )* ;

statement:
    COMMENT
    | forStatement
    | nextStatement
    | assignment
    | ifStatement
    | print
    | println
    | printNewline
    | goto
    | gosub
    | return
    | end
    | list
    | clear
    | cls
    | new
    | input
    | leftScroll
    | rightScroll
    | delay
    | load | save | dir | del
    | setMode
    | set
    | color
    | drawLine
    | drawEllipse
    | drawFEllipse
    | drawRect
    | drawFRect
    | drawText
    | drawCText
    | arcade
    | flip
    | help
    ;

forStatement: 'FOR' identifier '=' expression 'TO' expression ('STEP' expression)? ;
nextStatement: 'NEXT' ;
assignment: identifier '=' expression ;
ifStatement: 'IF' expression 'THEN' thenStatement ('ELSE' elseStatement)? ;
thenStatement: (statement | NUMBER) ;
elseStatement: (statement | NUMBER) ;
print: ('PRINT' | '?') ('@' at=expression ',')? expression (';' expression)* ';' ;
println: ('PRINT' | '?') ('@' at=expression ',')? expression (';' expression)* ;
printNewline: 'PRINT';
goto: 'GOTO' expression ;
gosub: 'GOSUB' expression ;
return: 'RETURN' ;
end: 'END' ;
list: listAll | listOne | listFrom | listTo | listFromTo ;
listAll: 'LIST' ;
listOne: 'LIST' NUMBER ;
listFrom: 'LIST' NUMBER '-';
listTo: 'LIST' '-' NUMBER ;
listFromTo: 'LIST' from=NUMBER '-' to=NUMBER ;
clear: 'CLEAR' ;
cls: 'CLS' ;
new: 'NEW' ;
input: 'INPUT' identifier ;
leftScroll: 'SCROLL' 'LEFT' ;
rightScroll: 'SCROLL' 'RIGHT' ;
delay: 'DELAY' expression ;
load: 'LOAD' expression ;
save: 'SAVE' expression ;
dir: 'DIR' ;
del: 'DEL' expression ;
setMode: 'MODE' expression ;
color: 'COLOR' expression ;
set: 'SET' expression ',' expression ;
drawLine: 'LINE' expression ',' expression 'TO' expression ',' expression ;
drawEllipse: 'ELLIPSE' expression ',' expression 'TO' expression ',' expression ;
drawFEllipse: 'FELLIPSE' expression ',' expression 'TO' expression ',' expression ;
drawRect: 'RECT' expression ',' expression 'TO' expression ',' expression ;
drawFRect: 'FRECT' expression ',' expression 'TO' expression ',' expression ;
drawText: 'TEXT' expression 'AT' expression ',' expression;
drawCText: 'CTEXT' expression 'AT' expression ',' expression;
arcade: 'ARCADE' ;
flip: 'FLIP' ;
help: 'HELP' (topic=STRING_LITERAL)? ;

identifier: IDENTIFIER ('[' expression (',' expression)* ']')? ;

expression:
    '(' expression ')'                                        #paranthesisExpr
    | left=expression POW right=expression                    #powExpr
    | left=expression op=(ASTERISK | SLASH | PERCENT)
                                        right=expression      #mulDivModExpr
    | left=expression op=(PLUS | MINUS) right=expression      #plusMinusExpr
    | left=expression op=(LESS | LESS_OR_EQUAL | EQUAL | NOT_EQUAL | GREATER | GREATER_OR_EQUAL)
                                        right=expression      #compExpr
    | left=expression op=(AND | OR | XOR) right=expression    #logicalExpr
    | NOT right=expression                                    #notExpr
    | MINUS right=expression                                  #negativeExpression
    | NUMBER                                                  #numExpr
    | DOUBLE_NUMBER                                           #doubleExpr
    | STRING_LITERAL                                          #stringExpr
    | BOOL_LITERAL                                            #boolExpr
    | '[' expression (',' expression)* ']'                    #arrayExpr
    | functionCall                                            #funcCallExpr
    | keyboard                                                #keyboardExpr
    | identifier                                              #idExp
    ;

keyboard            : 'KEY' '(' (expression)? ')' ;

IDENTIFIER          : [A-Z]([A-Z])?([0-9])? ;

functionCall:
    fn=(FN_SIN | FN_COS | FN_TAN | FN_ASIN | FN_ACOS | FN_ATAN
    | FN_SQR | FN_LOG | FN_ABS | FN_SGN | FN_CHR | FN_VAL | FN_INT | FN_DBL | FN_STR | FN_RND | FN_SPC | FN_SUBSTR
    | FN_HEX | FN_AHEX | FN_WIDTH | FN_HEIGHT ) '(' (expression (',' expression)*)? ')' ;

NOT                 : 'NOT' ;

NUMBER              : [0-9]+ ;
DOUBLE_NUMBER       : NUMBER '.' NUMBER ;
STRING_LITERAL      : '"' (~["])* '"' ;
BOOL_LITERAL        : 'TRUE' | 'FALSE' ;

ASTERISK            : '*' ;
SLASH               : '/' ;
PERCENT             : '%' ;
PLUS                : '+' ;
MINUS               : '-' ;
POW                 : '^' ;

EQUAL               : '=' ;
NOT_EQUAL           : '<>' ;
LESS                : '<' ;
LESS_OR_EQUAL       : '<=' ;
GREATER             : '>' ;
GREATER_OR_EQUAL    : '>=' ;

AND                 : 'AND' ;
OR                  : 'OR' ;
XOR                 : 'XOR' ;

FN_SIN              : 'SIN' ;
FN_COS              : 'COS' ;
FN_TAN              : 'TAN' ;
FN_ASIN             : 'ASIN' ;
FN_ACOS             : 'ACOS' ;
FN_ATAN             : 'ATAN' ;
FN_SQR              : 'SQR' ;
FN_LOG              : 'LOG' ;
FN_ABS              : 'ABS' ;
FN_SGN              : 'SGN' ;
FN_CHR              : 'CHR' ;
FN_VAL              : 'VAL' ;
FN_INT              : 'INT' ;
FN_DBL              : 'DBL' ;
FN_STR              : 'STR' ;
FN_RND              : 'RND' ;
FN_SPC              : 'SPC' ;
FN_SUBSTR           : 'SUBSTR' ;
FN_HEX              : 'HEX' ;
FN_AHEX             : 'AHEX' ;
FN_WIDTH            : 'WIDTH' ;
FN_HEIGHT           : 'HEIGHT' ;

NL                  : [\n\r] ;
SPACE               : [ \t]+ -> skip ;
COMMENT             : 'REM' ~[\n\r]* ;
