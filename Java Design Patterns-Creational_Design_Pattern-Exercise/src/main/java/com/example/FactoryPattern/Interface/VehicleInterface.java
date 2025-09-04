package com.example.FactoryPattern.Interface;

public interface VehicleInterface {
    void accelerate(int increment);
    void brake(int decrement);
    String startEngine();
    int getSpeed();
}
