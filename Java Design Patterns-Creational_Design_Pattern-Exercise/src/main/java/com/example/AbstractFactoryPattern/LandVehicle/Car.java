package com.example.AbstractFactoryPattern.LandVehicle;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;

public class Car extends AbstractVehicle {
    //region Fields
    private String name;
    private String size;
    private int speed;
    //endregion

    //region Constructors
    public Car(String name, String size, int speed) {
        this.name = name;
        this.size = size;
        this.speed = speed;
    }
    //endregion

    //region Getters
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
    //endregion

    //region Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //endregion

    //region Methods
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
        return "Car engine started";
    }
    //endregion
}
