package com.github.meshotron2.scriptPlugin.shape;

import com.github.meshotron2.scriptPlugin.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShapeClass {
    private final String name;
    private final List<String> attributes;
    private final Map<ShapeClass, List<String>> constructor = new HashMap<>();

    public ShapeClass(String name, List<String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public void initialize(List<Integer> values, char coefficient) {
        final Map<String, Integer> variable_values = new HashMap<>();

        for (int i = 0; i < values.size(); i++)
            variable_values.put(attributes.get(i), values.get(i));

        constructor.forEach(
                (clazz, params) -> {
                    final List<Integer> vals = params.stream()
                            .map(variable_values::get)
                            .collect(Collectors.toList());

                    clazz.initialize(vals, coefficient);
                }
        );
    }

    public String getJsonData(List<Integer> values, char coefficient) {
        final Map<String, Integer> variable_values = new HashMap<>();

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++)
//            variable_values.put(attributes.get(i), values.get(i));
            sb.append("\"").append(attributes.get(i)).append("\": ").append("\"").append(values.get(i)).append("\",\n");

        sb.append("\"").append("coefficient").append("\": ").append("\"").append(coefficient).append("\"\n");
        return "\"" + Visitor.getShapeName() + "\": {\n" + sb + "}";
    }

    public String getName() {
        return name;
    }

    public List<String> getAttributes() {
        return attributes;
    }
}
