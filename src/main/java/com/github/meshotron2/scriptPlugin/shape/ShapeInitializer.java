package com.github.meshotron2.scriptPlugin.shape;

import java.io.IOException;

@FunctionalInterface
public interface ShapeInitializer {
    void initialize(char coefficient, int... arguments) throws IOException;
}
