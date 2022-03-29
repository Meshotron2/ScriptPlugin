package com.github.meshotron2.scriptPlugin.shapes;

public class Sphere extends Shape {
    public Sphere(char coefficient) {
        super(coefficient);
        super.add("x", "y", "z", "r");
    }

    @Override
    public void draw(String file) {
        final int xc = getProperties().get("x");
        final int yc = getProperties().get("y");
        final int zc = getProperties().get("z");
        final int r = getProperties().get("r");

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
