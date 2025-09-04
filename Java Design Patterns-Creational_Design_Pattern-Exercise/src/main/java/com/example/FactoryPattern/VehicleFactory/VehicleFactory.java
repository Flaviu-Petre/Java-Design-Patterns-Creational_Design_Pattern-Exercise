package com.example.FactoryPattern.VehicleFactory;

import com.example.FactoryPattern.Interface.VehicleInterface;
import com.example.FactoryPattern.Vehicles.Bike;
import com.example.FactoryPattern.Vehicles.Car;
import com.example.FactoryPattern.Vehicles.Truck;

public class VehicleFactory {

    public static VehicleInterface getVehicle(String type, String name, String size, int speed){
        return switch (type) {
            case "Car" -> new Car(name, size, speed);
            case "Bike" -> new Bike(name, size, speed);
            case "Truck" -> new Truck(name, size, speed);
            default -> throw new IllegalArgumentException("Invalid type of vehicle");
        };
    }
}
