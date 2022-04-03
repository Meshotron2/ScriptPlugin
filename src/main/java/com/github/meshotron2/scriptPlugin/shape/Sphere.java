package com.github.meshotron2.scriptPlugin.shape;

import java.util.List;

public class Sphere extends ShapeClass {
    public Sphere() {
        super("Sphere", List.of("x", "y", "z", "r"));
    }

    @Override
    public void initialize(List<Integer> values, char coefficient) {
        final int xc = values.get(0);
        final int yc = values.get(1);
        final int zc = values.get(2);
        final int r = values.get(3);

        for (int i = xc - r; i <= xc + r; i++)
            for (int j = yc - r; j <= yc + r; j++)
                for (int k = zc - r; k <= zc + r; k++)
                    if (distance(i, j, k, xc, yc, zc) <= r)
                        return; // TODO: 3/28/22
    }

    private int distance(int x1, int x2, int y1, int y2, int z1, int z2) {
        return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
    }
}
