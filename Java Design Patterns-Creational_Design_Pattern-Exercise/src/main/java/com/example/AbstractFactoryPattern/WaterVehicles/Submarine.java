package com.example.AbstractFactoryPattern.WaterVehicles;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;

public class Submarine extends AbstractVehicle {
    //region Fields
    private String name;
    private String size;
    private int speed;
    //endregion

    //region Constructors
    public Submarine(String name, String size, int speed) {
        this.name = name;
        this.size = size;
        this.speed = speed;
    }

    @Override
    public void accelerate(int increment) {
        this.speed += increment;
    }

    @Override
    public void brake(int decrement) {
        this.speed -= decrement;
    }

    @Override
    public String startEngine() {
        return "Submarine engine started";
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getSize() {
        return "";
    }
    //endregion


}


