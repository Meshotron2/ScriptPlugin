grammar ScriptPlugin;

@header {
package com.github.meshotron2.scriptPlugin;
}

main: module* expr* EOF;

module: 'module' ID ('<'coefficient'>')? ('('ID (ID )+')')? '{' expr* '}';

expr: ID'<'coefficient'>'('('NUM+')')?    #CreateShape
    ;

coefficient: ID|NUM|' ';

ID: [a-zA-Z]+;
NUM: [0-9]+;

WS: [ \t\r\n] -> skip;