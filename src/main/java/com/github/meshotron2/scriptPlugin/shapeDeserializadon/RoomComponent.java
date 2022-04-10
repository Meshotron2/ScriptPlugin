package com.github.meshotron2.scriptPlugin.shapeDeserializadon;

import java.util.Map;

public class RoomComponent {
    private final String type;
    private final Map<String, String> properties;

    public RoomComponent(String type, Map<String, String> properties) {
        this.type = type;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
