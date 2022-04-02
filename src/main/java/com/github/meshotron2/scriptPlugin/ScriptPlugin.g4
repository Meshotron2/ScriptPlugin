grammar ScriptPlugin;

@header {
package com.github.meshotron2.scriptPlugin;
}

main: module* instantiation* EOF;

module: 'module' ID ('('ID (ID )+')')? '{' expr* '}';

expr: ID'<'coefficient'>'('('ID+')')?    #CreateShape
    ;

instantiation: ID'<'coefficient'>''('NUM+')';

coefficient: ID|NUM|' ';

ID: [a-zA-Z]+;
NUM: [0-9]+;

WS: [ \t\r\n] -> skip;