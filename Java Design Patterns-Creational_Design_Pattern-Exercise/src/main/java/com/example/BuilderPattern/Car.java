package com.example.BuilderPattern;

public class Car {
    //region fields
    private String brand;
    private String model;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    //endregion

    //region constructors
    public Car(CarBuilder builder) {
        this.brand = builder.getBrand();
        this.model = builder.getModel();
        this.color = builder.getColor();
        this.engine = builder.getEngine();
        this.transmission = builder.getTransmission();
        this.fuelType = builder.getFuelType();
    }
    //endregion

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }


}
