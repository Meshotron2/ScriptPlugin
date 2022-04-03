package com.github.meshotron2.scriptPlugin;

import com.github.meshotron2.scriptPlugin.shape.Shape;
import com.github.meshotron2.scriptPlugin.shape.ShapeClass;
import com.github.meshotron2.scriptPlugin.shape.ShapeFactory;
import com.github.meshotron2.scriptPlugin.shape.ShapeInitializer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DWMVisitor extends ScriptPluginBaseVisitor<Object> {

    private final String fileName;
    private final ShapeFactory shapeFactory;

    public DWMVisitor(String fileName, ShapeFactory shapeFactory) {
        this.fileName = fileName;
        this.shapeFactory = shapeFactory;
    }

    @Override
    public Object visitMain(ScriptPluginParser.MainContext ctx) {
//        final Room r = (Room) visit(ctx.main_mod());
        ctx.module().forEach(mod -> {
            final Object[] res = (Object[]) visit(mod);
            shapeFactory.registerModule((String) res[0], (ShapeInitializer) res[1]);
        });

        return visitChildren(ctx);
    }

    @Override
    public Object visitMain_mod(ScriptPluginParser.Main_modContext ctx) {
        final Room r = new Room(fileName, Integer.parseInt(ctx.NUM(0).getText()), Integer.parseInt(ctx.NUM(1).getText()),
                Integer.parseInt(ctx.NUM(3).getText()), Integer.parseInt(ctx.NUM(3).getText()));

        return r;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitModule(ScriptPluginParser.ModuleContext ctx) {
        final List<String> variables = ctx.ID().stream()
                .map(ParseTree::getText)
                .collect(Collectors.toList());

        final ShapeInitializer init = (coefficient, arguments) -> {
            ctx.expr().stream().map(exprContext -> (List<String>) visit(exprContext)).forEach(nameAndParams -> {
                final int[] args = new int[nameAndParams.size() - 1];
                for (int i = 0; i < nameAndParams.subList(1, nameAndParams.size()).size(); i++)
                    args[i] = arguments[variables.indexOf(nameAndParams.get(i))];

                shapeFactory.getInitializerFromClass(nameAndParams.get(0))
                        .initialize(coefficient, args);
            });
        };

        return new Object[]{ctx.ID(0), init};
    }

    @Override
    public Object visitCreateShape(ScriptPluginParser.CreateShapeContext ctx) {
        return ctx.ID().stream().map(ParseTree::getText).collect(Collectors.toList());
    }

    @Override
    public Object visitCoefficient(ScriptPluginParser.CoefficientContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitInstantiation(ScriptPluginParser.InstantiationContext ctx) {
        return visitChildren(ctx);
    }

    private boolean isCoefficientValid(char c) {
        if (c >= 'a' && c <= 'h')
            return true;

        if (c >= 'A' && c <= 'H')
            return true;

        if (c >= '0' && c <= '9')
            return true;

        if (c == ' ' || c == 's' || c == 'S' || c == 'r' || c == 'R' || c == 'z' || c == 'Z')
            return true;

        if (c == '\0') // uninitialized
            return true;

        return false;
    }
}
