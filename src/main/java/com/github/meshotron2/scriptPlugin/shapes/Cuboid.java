package com.github.meshotron2.scriptPlugin.shapes;

public class Cuboid extends Shape {
    public Cuboid(char coefficient) {
        super(coefficient);
        super.add("x1", "x2", "y1", "y2", "z1", "z2");
    }

    @Override
    public void draw(String file) {
        for (int x = getProperties().get("x1"); x < getProperties().get("x2"); x++)
            for (int y = getProperties().get("y1"); y < getProperties().get("y2"); y++)
                for (int z = getProperties().get("z1"); z < getProperties().get("z2"); z++)
                    return; // todo
    }
}
