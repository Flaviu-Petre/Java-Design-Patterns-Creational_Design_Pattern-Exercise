package com.example.AbstractFactoryPattern.AbstractFactory;

public interface WaterVehicleFactoryInterface extends AbstractVehicleFactory{
    AbstractVehicle createBoat();
    AbstractVehicle createSubmarine();
}
