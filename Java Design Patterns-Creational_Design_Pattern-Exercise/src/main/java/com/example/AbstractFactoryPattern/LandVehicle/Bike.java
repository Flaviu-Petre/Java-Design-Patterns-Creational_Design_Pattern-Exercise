package com.example.AbstractFactoryPattern.LandVehicle;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;

public class Bike extends AbstractVehicle {
    //region Fields
    private String name;
    private String size;
    private int speed;
    //endregion

    //region Constructors
    public Bike(String name, String size, int speed) {
        this.name = name;
        this.size = size;
        this.speed = speed;
    }
    //endregion

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
        return "Bike engine started";
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }
}
