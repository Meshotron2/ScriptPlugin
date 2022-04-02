package com.github.meshotron2.scriptPlugin.shapes;

import java.util.ArrayList;
import java.util.List;

public class Cuboid extends ShapeClass {

    public Cuboid() {
        super("Cuboid", List.of("x1", "x2", "y1", "y2", "z1", "z2"));
    }

    @Override
    public void initialize(List<Integer> values, char coefficient) {
        for (int x = values.get(0); x < values.get(1); x++)
            for (int y = values.get(2); y < values.get(3); y++)
                for (int z = values.get(4); z < values.get(5); z++)
                    return; // todo
    }
}
