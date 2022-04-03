grammar ScriptPlugin;

//@header {
//package com.github.meshotron2.scriptPlugin;
//}

main: module* main_mod EOF;

main_mod: 'main' '('NUM',' NUM',' NUM',' NUM')' '{' instantiation* '}';

module: 'module 'ID'('(ID',')* ID')' '{' expr* '}';

expr: ID'<'coefficient'>''('(ID',')* ID')'    #CreateShape
    ;

instantiation: ID'<'coefficient'>''('(NUM',')* NUM')';

coefficient: ID|NUM;

ID: [a-zA-Z_]+;
NUM: [0-9]+;

WS: [ \t\r\n]+ -> skip;