grammar ScriptPlugin;

main: module* expr* EOF;

module: 'module' ID ('<'CHAR'>')? ('('NUM+')')? '{' expr '}';

expr: ID ('('NUM+')')?    #Constructor
    ;

ID: [a-z][a-zA-Z]*;
CHAR: [a-zA-Z0-9];
NUM: [0-9]+;

WS: [ \t\r\n] -> skip;