package com.github.meshotron2.scriptPlugin;

import com.github.meshotron2.scriptPlugin.shapes.Shape;
import com.github.meshotron2.scriptPlugin.shapes.ShapeFactory;

public class Visitor extends ScriptPluginBaseVisitor<Object> {

    private final String fileName;

    public Visitor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object visitMain(ScriptPluginParser.MainContext ctx) {
        return visitChildren(ctx);
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

        ctx.expr().forEach(this::visit);

        return visitChildren(ctx);
    }

    @Override
    public Object visitCreateShape(ScriptPluginParser.CreateShapeContext ctx) {
        final char c = (char) visit(ctx.coefficient());
        final Shape s = ShapeFactory.fromName(ctx.ID().getText(), c);

        final Object[] array = ctx.NUM().stream().map(terminalNode -> Integer.parseInt(terminalNode.getText())).toArray();
        final int[] params = new int[array.length];
        for (int i = 0; i < array.length; i++)
            params[i] = (int) array[i];

        s.initialize(params);
        s.draw(fileName);

        return s;
    }

    @Override
    public Object visitCoefficient(ScriptPluginParser.CoefficientContext ctx) {
        char c = ctx.getText().charAt(0);
        if (!isCoefficientValid(c))
            return '\0';
        return c;
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
