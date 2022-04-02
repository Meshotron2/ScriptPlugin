package com.github.meshotron2.scriptPlugin;

import com.github.meshotron2.scriptPlugin.shapes.Shape;
import com.github.meshotron2.scriptPlugin.shapes.ShapeClass;
import com.github.meshotron2.scriptPlugin.shapes.ShapeFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Visitor extends ScriptPluginBaseVisitor<Object> {

    private final String fileName;
    private final Map<String, Shape> modules = new HashMap<>();

    private static final AtomicInteger cnt = new AtomicInteger(0);

    public static String getShapeName() {
        return String.valueOf(cnt.getAndIncrement());
    }

    public Visitor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object visitMain(ScriptPluginParser.MainContext ctx) {
        final StringBuilder sb = new StringBuilder();
        ctx.instantiation().forEach(instantiationContext -> sb.append(visit(instantiationContext)));
        System.out.println(sb);
    }

    @Override
    public Object visitModule(ScriptPluginParser.ModuleContext ctx) {
        final String name = ctx.ID(0).getText();
        final char c = (char) visit(ctx.coefficient());

        if (!isCoefficientValid(c)) {
            System.err.println("Coefficient for " + name + " is not valid");
            return null;
        }

        final Shape s = new Shape(c);

        final int startIdx = Character.isDigit(c) ? 1 : 2;
        ctx.ID().subList(startIdx, ctx.ID().size()).forEach(
                k -> s.add(k.getText())
        );

        final List<Shape> shapes = new ArrayList<>();

        ctx.expr().forEach(node -> shapes.add((Shape) visit(node)));

        return visitChildren(ctx);
    }

    @Override
    public Object visitCreateShape(ScriptPluginParser.CreateShapeContext ctx) {
        final char c = (char) visit(ctx.coefficient());
        final ShapeClass s = ShapeFactory.fromName(ctx.ID(0).getText(), new ArrayList<>());

        final Object[] array = ctx.ID().stream()
                .map(terminalNode -> Integer.parseInt(terminalNode.getText()))
                .toArray();
        final String[] params = new String[array.length];
        for (int i = 1; i < array.length; i++)
            params[i] = (String) array[i];

//        s.add(params);
//        s.draw(fileName);

        return s;
    }

    @Override
    public Object visitCoefficient(ScriptPluginParser.CoefficientContext ctx) {
        char c = ctx.getText().charAt(0);
        if (!isCoefficientValid(c))
            return '\0';
        return c;
    }

    @Override
    public Object visitInstantiation(ScriptPluginParser.InstantiationContext ctx) {
        final char c = (char) visit(ctx.coefficient());
        final ShapeClass s = ShapeFactory.fromName(ctx.ID().getText(), new ArrayList<>());

        final Object[] array = ctx.NUM().stream()
                .map(terminalNode -> Integer.parseInt(terminalNode.getText()))
                .toArray();
        final List<Integer> params = new ArrayList<>();
        for (int i = 1; i < array.length; i++)
            params.add((int) array[i]);

//        s.initialize(params);
//        s.draw(fileName);

        return s.getJsonData(params, c);
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
