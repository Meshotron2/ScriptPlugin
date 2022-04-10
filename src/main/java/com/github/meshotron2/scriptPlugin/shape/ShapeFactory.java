package com.github.meshotron2.scriptPlugin.shape;

import com.github.meshotron2.scriptPlugin.Room;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ShapeFactory {
    private final Map<String, ShapeInitializer> constructors = new HashMap<>();

    private Room r;

    public ShapeFactory() {
        constructors.put("cube", (coef, args) -> {
//            System.out.println("Cube constructor<" + coef + ">" + Arrays.toString(args));
            System.out.println("Cuboid");

            for (int x = args[0]; x < args[1]; x++)
                for (int y = args[2]; y < args[3]; y++)
                    for (int z = args[4]; z < args[5]; z++)
                        r.writeNode(coef, x, y, z);
        });

        constructors.put("sphere", (coef, args) -> {
//            System.out.println("Sphere constructor <" + coef + ">" + Arrays.toString(args));

            final int xc = args[0];
            final int yc = args[1];
            final int zc = args[2];
            final int r = args[3];

            System.out.println("Sphere " + Arrays.toString(args));

            for (int i = xc - r; i <= xc + r; i++)
                for (int j = yc - r; j <= yc + r; j++)
                    for (int k = zc - r; k <= zc + r; k++)
                        if (distance(i, j, k, xc, yc, zc) <= r)
                            this.r.writeNode(coef, i, j, k);
        });
    }

    public ShapeInitializer getInitializerFromClass(String name) {
        return constructors.get(name);
    }

    public void registerModule(String name, ShapeInitializer initializer) {
        constructors.put(name.toLowerCase(Locale.ROOT), initializer);
    }

    private int distance(int x1, int y1, int z1, int x2, int y2, int z2) {
        return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
    }

    public void setRoom(Room r) {
        this.r = r;
    }
}
