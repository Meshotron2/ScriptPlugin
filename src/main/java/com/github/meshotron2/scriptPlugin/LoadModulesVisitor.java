package com.github.meshotron2.scriptPlugin;

import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LoadModulesVisitor extends ScriptPluginBaseVisitor<String> {

    private final String fileName;
    private final String pluginFile;

    private final AtomicInteger cnt = new AtomicInteger(0);
    private final Map<String, String[]> nameAttributesMap = new HashMap<>();

    public LoadModulesVisitor(String fileName) throws URISyntaxException {
        this.fileName = fileName;
        this.pluginFile = new File(ScriptPluginParser.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getPath();
    }

    @Override
    public String visitMain(ScriptPluginParser.MainContext ctx) {
        ctx.module().forEach(this::visit);
        return visit(ctx.main_mod());
    }

    @Override
    public String visitMain_mod(ScriptPluginParser.Main_modContext ctx) {
        final StringBuilder sb = new StringBuilder("{");

        sb
                .append("\"xg\": \"").append(ctx.NUM(0)).append("\",")
                .append("\"yg\": \"").append(ctx.NUM(1)).append("\",")
                .append("\"zg\": \"").append(ctx.NUM(2)).append("\",")
                .append("\"f\": \"").append(ctx.NUM(3)).append("\",")
                .append("\"file\": \"").append(fileName).append("\",")
                .append("\"plugin_file\": \"").append(pluginFile).append("\",");

        sb.append("\"shapes\": {");

        for (ScriptPluginParser.InstantiationContext instantiationContext : ctx.instantiation()) {
            sb.append("\"").append(cnt.getAndIncrement()).append("\": {");
            sb.append(visit(instantiationContext));
            sb.append("},");
        }

        sb.append("}}");

        return sb.toString();
    }

    @Override
    public String visitModule(ScriptPluginParser.ModuleContext ctx) {
        final String[] array = new String[ctx.ID().size() - 1];

        final String[] attributes = ctx.ID().subList(1, ctx.ID().size()).stream()
                .map(ParseTree::getText)
                .collect(Collectors.toList()).toArray(array);

        nameAttributesMap.put(ctx.ID(0).getText(), attributes);

        return "";
    }

    @Override
    public String visitCoefficient(ScriptPluginParser.CoefficientContext ctx) {
        char c = ctx.getText().charAt(0);
        if (!isCoefficientValid(c))
            return "\0";
        return ctx.getText().substring(0, 0);
    }

    @Override
    public String visitInstantiation(ScriptPluginParser.InstantiationContext ctx) {
        final StringBuilder sb = new StringBuilder();
        final int[] values = ctx.NUM().stream()
                .mapToInt(value -> Integer.parseInt(value.getText()))
                .toArray();
        final String nameToInstantiate = ctx.ID().getText();

        sb.append("\"type\": \"").append(ctx.ID().getText().toLowerCase(Locale.ROOT)).append("\",");

        nameAttributesMap.forEach((name, attributes) -> {
            if (name.equals(nameToInstantiate))
                for (int i = 0; i < attributes.length; i++)
                    sb.append("\"").append(attributes[i]).append("\": ")
                            .append("\"").append(values[i]).append("\",");
        });

        sb.append("\"coefficient\": \"").append(visit(ctx.coefficient())).append("\"");

        return sb.toString();
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

