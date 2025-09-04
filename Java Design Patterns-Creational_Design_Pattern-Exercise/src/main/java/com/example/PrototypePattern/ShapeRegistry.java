package com.example.PrototypePattern;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private ShapeRegistry() {
    }

    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static void addShape(String key, Shape shape) {
        shapeMap.put(key, shape);
    }

    public static Shape getShape(String key) {
        Shape shape = shapeMap.get(key);
        return (Shape) shape.clone();
    }
}
