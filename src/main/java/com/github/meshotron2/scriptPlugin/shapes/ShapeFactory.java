package com.github.meshotron2.scriptPlugin.shapes;

public class ShapeFactory {
    public static Shape fromName(String shapeName, char coefficient, String... params) {
        switch (shapeName) {
            case "Cuboid":
                return new Cuboid(coefficient);
            case "Sphere":
                return new Sphere(coefficient);
            default:
                final Shape shape = new Shape(coefficient);
                shape.add(params);
                return shape;
        }
    }
}
