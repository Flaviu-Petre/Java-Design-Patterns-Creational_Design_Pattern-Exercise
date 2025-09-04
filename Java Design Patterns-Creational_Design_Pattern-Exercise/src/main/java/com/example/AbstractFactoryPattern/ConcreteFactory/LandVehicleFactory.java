package com.example.AbstractFactoryPattern.ConcreteFactory;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicleFactory;
import com.example.AbstractFactoryPattern.AbstractFactory.LandVehicleFactoryInterface;
import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;
import com.example.AbstractFactoryPattern.LandVehicle.Car;
import com.example.AbstractFactoryPattern.LandVehicle.Bike;

public class LandVehicleFactory implements AbstractVehicleFactory, LandVehicleFactoryInterface {
    @Override
    public AbstractVehicle createVehicle() {
        return createCar(); // Default to creating a car
    }

    @Override
    public AbstractVehicle createCar() {
        return new Car("Default Car", "Medium", 0);
    }

    @Override
    public AbstractVehicle createBike() {
        return new Bike("Default Bike", "Small", 0);
    }

    public AbstractVehicle createLandVehicle(String type, String name, String size, int speed) {
        return switch (type.toLowerCase()) {
            case "car" -> new Car(name, size, speed);
            case "bike" -> new Bike(name, size, speed);
            default -> throw new IllegalArgumentException("Invalid land vehicle type: " + type);
        };
    }

}
