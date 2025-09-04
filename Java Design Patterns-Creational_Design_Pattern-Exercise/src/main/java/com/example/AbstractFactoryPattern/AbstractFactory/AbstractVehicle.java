package com.example.AbstractFactoryPattern.AbstractFactory;

public abstract class AbstractVehicle {
    public abstract void accelerate(int increment);
    public abstract void brake(int decrement);
    public abstract String startEngine();
    public abstract int getSpeed();
    public abstract String getName();
    public abstract String getSize();
}
