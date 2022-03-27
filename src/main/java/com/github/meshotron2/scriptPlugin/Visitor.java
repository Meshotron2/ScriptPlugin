package com.github.meshotron2.scriptPlugin;

public class Visitor extends ScriptPluginBaseVisitor<Integer> {

    @Override
    public Integer visitMain(ScriptPluginParser.MainContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitModule(ScriptPluginParser.ModuleContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitConstructor(ScriptPluginParser.ConstructorContext ctx) {
        return visitChildren(ctx);
    }
}
