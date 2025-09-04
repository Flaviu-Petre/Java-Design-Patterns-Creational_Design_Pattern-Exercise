package com.example.AbstractFactoryPattern.AbstractFactory;

public interface AirVehicleFactoryInterface extends AbstractVehicleFactory {
    AbstractVehicle createAirplane();
    AbstractVehicle createHelicopter();
}
