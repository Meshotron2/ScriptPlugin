package com.github.meshotron2.scriptPlugin.shapes;

import java.util.List;

public class ShapeFactory {
    public static ShapeClass fromName(String shapeName, List<String> params) {
        switch (shapeName) {
            case "Cuboid":
                return new Cuboid();
            case "Sphere":
                return new Sphere();
            default:
                return new ShapeClass(shapeName, params);
        }
    }
}
