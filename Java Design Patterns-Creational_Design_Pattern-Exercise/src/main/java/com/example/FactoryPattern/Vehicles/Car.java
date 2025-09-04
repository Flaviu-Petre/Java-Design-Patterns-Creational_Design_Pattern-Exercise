package com.example.FactoryPattern.Vehicles;

import com.example.FactoryPattern.Interface.VehicleInterface;

public class Car implements VehicleInterface {
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

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    @Override
    public int getSpeed() {
        return speed;
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
        return "Car engine started: " + this.toString();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", currentVelocity=" + speed +
                '}';
    }
    //endregion
}
