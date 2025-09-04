package com.example.AbstractFactoryPattern.AbstractFactory;

public interface LandVehicleFactoryInterface extends AbstractVehicleFactory {
    AbstractVehicle createCar();
    AbstractVehicle createBike();
}
