package com.example.AbstractFactoryPattern.ConcreteFactory;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;
import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicleFactory;
import com.example.AbstractFactoryPattern.AbstractFactory.WaterVehicleFactoryInterface;
import com.example.AbstractFactoryPattern.WaterVehicles.Boat;
import com.example.AbstractFactoryPattern.WaterVehicles.Submarine;
import com.example.FactoryPattern.VehicleFactory.VehicleFactory;

public class WaterVehicleFactory implements AbstractVehicleFactory, WaterVehicleFactoryInterface {
    @Override
    public AbstractVehicle createVehicle() {
        return null;
    }

    @Override
    public AbstractVehicle createBoat() {
        return new Boat("Default Boat", "Medium", 0);
    }

    @Override
    public AbstractVehicle createSubmarine() {
        return new Submarine("Default Submarine", "Large", 0);
    }

    public AbstractVehicle createWaterVehicle(String type, String name, String size, int speed) {
        return switch (type.toLowerCase()) {
            case "boat" -> new Boat(name, size, speed);
            case "submarine" -> new Submarine(name, size, speed);
            default -> throw new IllegalArgumentException("Invalid water vehicle type: " + type);
        };
    }
}
