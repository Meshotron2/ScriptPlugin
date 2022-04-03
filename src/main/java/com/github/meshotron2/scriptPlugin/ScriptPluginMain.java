package com.github.meshotron2.scriptPlugin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import com.github.meshotron2.scriptPlugin.shape.ShapeFactory;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ScriptPluginMain {
    public static void main(String[] args) {
        try {
            // create a CharStream that reads from standard input:
            CharStream input = CharStreams.fromStream(System.in);
            // create a lexer that feeds off of input CharStream:
            ScriptPluginLexer lexer = new ScriptPluginLexer(input);
            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create a parser that feeds off the tokens buffer:
            ScriptPluginParser parser = new ScriptPluginParser(tokens);
            // replace error listener:
            //parser.removeErrorListeners(); // remove ConsoleErrorListener
            //parser.addErrorListener(new ErrorHandlingListener());
            // begin parsing at main rule:
            ParseTree tree = parser.main();
            if (parser.getNumberOfSyntaxErrors() == 0) {
                // print LISP-style tree:
                // System.out.println(tree.toStringTree(parser));
                if (Objects.equals(args[0], "lm")) {
                    final ScriptPluginBaseVisitor<String> visitor0 = new LoadModulesVisitor(args[1]);
                    final String result = visitor0.visit(tree);
                    System.out.println(result);
                } else if (Objects.equals(args[0], "dwm")) {
                    final ScriptPluginBaseVisitor<Object> visitor0 = new DWMVisitor(args[1], new ShapeFactory());
                    visitor0.visit(tree);
//                    final String result = visitor0.visit(tree);
//                    System.out.println(result);
                }
            }
        } catch (IOException /*| RecognitionException*/ e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
