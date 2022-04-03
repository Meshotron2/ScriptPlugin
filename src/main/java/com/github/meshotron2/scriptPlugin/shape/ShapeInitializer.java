package com.github.meshotron2.scriptPlugin.shape;

@FunctionalInterface
public interface ShapeInitializer {
    void initialize(char coefficient, int... arguments);
}
