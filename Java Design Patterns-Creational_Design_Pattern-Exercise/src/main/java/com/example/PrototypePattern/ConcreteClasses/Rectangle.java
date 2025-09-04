package com.example.PrototypePattern.ConcreteClasses;

import com.example.PrototypePattern.Shape;

public class Rectangle implements Shape {
    //region fields
    private int length;
    private int width;
    //endregion

    //region constructors
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    //endregion

    //region getters
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
    //endregion

    //region setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    //endregion


    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length: " + length + " and width: " + width);
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
