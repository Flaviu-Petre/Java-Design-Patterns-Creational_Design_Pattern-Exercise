package com.example.AbstractFactoryPattern.ConcreteFactory;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;
import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicleFactory;
import com.example.AbstractFactoryPattern.AbstractFactory.AirVehicleFactoryInterface;
import com.example.AbstractFactoryPattern.AirVehicle.Airplane;
import com.example.AbstractFactoryPattern.AirVehicle.Helicopter;

public class AirVehicleFactory implements AbstractVehicleFactory, AirVehicleFactoryInterface {

    @Override
    public AbstractVehicle createVehicle() {
        return createAirplane();
    }
    @Override

    public AbstractVehicle createAirplane() {
        return new Airplane("Default Airplane", "Large", 0);
    }

    @Override
    public AbstractVehicle createHelicopter() {
        return new Helicopter("Default Helicopter", "Medium", 0);
    }

    public AbstractVehicle createAirVehicle(String type, String name, String size, int speed) {
        return switch (type.toLowerCase()) {
            case "airplane" -> new Airplane(name, size, speed);
            case "helicopter" -> new Helicopter(name, size, speed);
            default -> throw new IllegalArgumentException("Invalid air vehicle type: " + type);
        };
    }


}
