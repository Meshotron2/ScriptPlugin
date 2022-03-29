package com.github.meshotron2.scriptPlugin.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Shape {
    private final Map<String, Integer> properties = new TreeMap<>();
    private final char coefficient;
    private final List<Shape> shapes = new ArrayList<>();

    public Shape(char coefficient) {
        this.coefficient = coefficient;
    }

    public void add(String... ks) {
        for (String k : ks)
            properties.put(k, -1);
    }

    public void initialize(int... values) {
        final AtomicInteger cnt = new AtomicInteger(0);

        properties.forEach((k, v) -> {
            final int toAdd = values[cnt.getAndIncrement()];
            properties.put(k, toAdd);
        });
    }

    public void draw(String file) {
        // TODO: 3/28/22 Make integrity checks
        for (Shape shape : shapes) {
            shape.draw(file);
        }
    }

    public Map<String, Integer> getProperties() {
        return properties;
    }
}
