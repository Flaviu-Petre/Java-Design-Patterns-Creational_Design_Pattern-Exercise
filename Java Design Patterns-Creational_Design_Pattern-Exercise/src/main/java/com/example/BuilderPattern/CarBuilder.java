package com.example.BuilderPattern;

public class CarBuilder {
    private String brand;
    private String model;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;


    public static CarBuilder newBuilder() {
        return new CarBuilder();
    }


    public CarBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder withTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder withFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public Car build() {
        return new Car(this);
    }
}
