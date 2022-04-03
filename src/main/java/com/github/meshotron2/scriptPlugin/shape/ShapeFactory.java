package com.github.meshotron2.scriptPlugin.shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapeFactory {
    private final Map<String, ShapeInitializer> constructors = new HashMap<>();

    public ShapeFactory() {
        constructors.put("Cuboid", (coef, args) -> {
            for (int x = args[0]; x < args[1]; x++)
                for (int y = args[2]; y < args[3]; y++)
                    for (int z = args[4]; z < args[5]; z++)
                        return; // todo
        });

        constructors.put("Sphere", (coef, args) -> {
            final int xc = args[0];
            final int yc = args[1];
            final int zc = args[2];
            final int r = args[3];

            for (int i = xc - r; i <= xc + r; i++)
                for (int j = yc - r; j <= yc + r; j++)
                    for (int k = zc - r; k <= zc + r; k++)
                        if (distance(i, j, k, xc, yc, zc) <= r)
                            return; // TODO: 3/28/22
        });
    }

    public ShapeInitializer getInitializerFromClass(String name) {
        return constructors.get(name);
    }

    public void registerModule(String name, ShapeInitializer initializer) {
        constructors.put(name, initializer);
    }

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

    private int distance(int x1, int x2, int y1, int y2, int z1, int z2) {
        return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
    }
}
