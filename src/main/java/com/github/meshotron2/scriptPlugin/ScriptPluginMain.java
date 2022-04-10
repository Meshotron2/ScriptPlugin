package com.github.meshotron2.scriptPlugin;

import com.github.meshotron2.scriptPlugin.shape.ShapeFactory;
import com.github.meshotron2.scriptPlugin.shapeDeserializadon.JSONRoom;
import com.google.gson.Gson;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class ScriptPluginMain {
    public static void main(String[] args) {
//        final StringBuilder sb = new StringBuilder("\"");
//        sb.append("name\"");
//        System.out.println(sb);
//        System.exit(0);
//        System.out.println("UPDATED " + Arrays.toString(args));
//        System.out.println("here");

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
                    final ShapeFactory shapeFactory = new ShapeFactory();
                    final ScriptPluginBaseVisitor<Object> visitor0 = new DWMVisitor(args[1], shapeFactory);
                    visitor0.visit(tree);
                    final String inputRoom = new String(Base64.getDecoder().decode(args[1].getBytes(StandardCharsets.UTF_8)));
//                            .replaceAll(":", "\":\"").replaceAll("^},", "\",\"");
                    System.out.println("PROCESSED ROOM " + inputRoom);
                    final JSONRoom room = new Gson().fromJson(inputRoom, JSONRoom.class);
                    room.write(shapeFactory);
//                    final String result = visitor0.visit(tree);
//                    System.out.println(result);
                }
            }
        } catch (IOException | URISyntaxException /*| RecognitionException*/ e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
