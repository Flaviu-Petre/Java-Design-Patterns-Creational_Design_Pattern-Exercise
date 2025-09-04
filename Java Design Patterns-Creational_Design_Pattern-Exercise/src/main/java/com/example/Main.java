package com.example;

import com.example.AbstractFactoryPattern.AbstractFactory.AbstractVehicle;
import com.example.AbstractFactoryPattern.ConcreteFactory.AirVehicleFactory;
import com.example.AbstractFactoryPattern.ConcreteFactory.LandVehicleFactory;
import com.example.AbstractFactoryPattern.ConcreteFactory.WaterVehicleFactory;
import com.example.FactoryPattern.Interface.VehicleInterface;
import com.example.FactoryPattern.VehicleFactory.VehicleFactory;
import com.example.PrototypePattern.ConcreteClasses.Circle;
import com.example.PrototypePattern.ConcreteClasses.Rectangle;
import com.example.PrototypePattern.Shape;
import com.example.PrototypePattern.ShapeRegistry;
import com.example.SingletonPattern.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    //declare scanner for user input
    private static final Scanner scanner = new Scanner(System.in);

    private static final LandVehicleFactory landFactory = new LandVehicleFactory();
    private static final WaterVehicleFactory waterFactory = new WaterVehicleFactory();
    private static final AirVehicleFactory airFactory = new AirVehicleFactory();

    public static void main(String[] args) {
//        testBasicSingleton();
//        testThreadSafety();
//        testClonePrevention();
//        testSerializationSafety();
//        testLoggingMethods();
//        testFactoryPattern();

//        try {
//            while (true) {
//                displayMenu();
//                int choice = getUserChoice();
//
//                if (choice == 0) {
//                    System.out.println("Thank you for using the Vehicle Creation System!");
//                    break;
//                }
//
//                processUserChoice(choice);
//
//                System.out.println("\nWould you like to create another vehicle? (y/n): ");
//                String continueChoice = scanner.nextLine().trim().toLowerCase();
//                if (!continueChoice.equals("y") && !continueChoice.equals("yes")) {
//                    System.out.println("Thank you for using the Vehicle Creation System!");
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("An error occurred: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }

        initializeShapeRegistry();

        demonstrateBasicCloning();

        demonstrateShapeModification();

        demonstrateCustomPrototypes();

        demonstratePerformanceBenefits();

    }

    private static void initializeShapeRegistry() {
        System.out.println("1. Initializing Shape Registry with Prototypes");
        System.out.println("-".repeat(50));

        Circle defaultCircle = new Circle(0, 0, 10);
        Rectangle defaultRectangle = new Rectangle(20, 15);
        Circle largeCircle = new Circle(50, 50, 25);
        Rectangle square = new Rectangle(10, 10);

        ShapeRegistry.addShape("circle", defaultCircle);
        ShapeRegistry.addShape("rectangle", defaultRectangle);
        ShapeRegistry.addShape("large_circle", largeCircle);
        ShapeRegistry.addShape("square", square);
    }

    private static void demonstrateBasicCloning() {
        System.out.println("2. Demonstrating Basic Cloning");
        System.out.println("-".repeat(50));

        Shape clonedCircle1 = ShapeRegistry.getShape("circle");
        Shape clonedCircle2 = ShapeRegistry.getShape("circle");
        Shape clonedRectangle = ShapeRegistry.getShape("rectangle");
        Shape clonedSquare = ShapeRegistry.getShape("square");

        System.out.println("Cloned shapes from registry:");
        System.out.print("Circle Clone 1: ");
        clonedCircle1.draw();

        System.out.print("Circle Clone 2: ");
        clonedCircle2.draw();

        System.out.print("Rectangle Clone: ");
        clonedRectangle.draw();

        System.out.print("Square Clone: ");
        clonedSquare.draw();

        System.out.println("\nVerifying clones are separate objects:");
        System.out.println("Circle clone 1 == Circle clone 2: " + (clonedCircle1 == clonedCircle2));
        System.out.println("Circle clone 1 hash: " + clonedCircle1.hashCode());
        System.out.println("Circle clone 2 hash: " + clonedCircle2.hashCode());
        System.out.println();
    }

    private static void demonstrateShapeModification() {
        System.out.println("3. Demonstrating Shape Modification");
        System.out.println("-".repeat(50));

        Shape originalCircle = ShapeRegistry.getShape("circle");
        System.out.print("Original circle state: ");
        originalCircle.draw();

        Shape modifiedCircle = ShapeRegistry.getShape("circle");
        if (modifiedCircle instanceof Circle) {
            Circle circle = (Circle) modifiedCircle;
            circle.setX(100);
            circle.setY(200);
            circle.setRadius(30);
        }

        System.out.print("Modified clone state: ");
        modifiedCircle.draw();

        Shape freshClone = ShapeRegistry.getShape("circle");
        System.out.print("Fresh clone (should match original): ");
        freshClone.draw();

        Shape modifiedRectangle = ShapeRegistry.getShape("rectangle");
        if (modifiedRectangle instanceof Rectangle) {
            Rectangle rect = (Rectangle) modifiedRectangle;
            rect.setLength(50);
            rect.setWidth(30);
        }

        System.out.print("Modified rectangle clone: ");
        modifiedRectangle.draw();
        System.out.println();
    }

    private static void demonstrateCustomPrototypes() {
        System.out.println("4. Demonstrating Custom Prototypes");
        System.out.println("-".repeat(50));

        Circle customCircle = new Circle(75, 85, 40);
        Rectangle customRectangle = new Rectangle(100, 5);

        ShapeRegistry.addShape("custom_circle", customCircle);
        ShapeRegistry.addShape("thin_rectangle", customRectangle);

        System.out.println("Added custom prototypes to registry");

        Shape clonedCustomCircle = ShapeRegistry.getShape("custom_circle");
        Shape clonedThinRectangle = ShapeRegistry.getShape("thin_rectangle");

        System.out.print("Custom circle clone: ");
        clonedCustomCircle.draw();

        System.out.print("Thin rectangle clone: ");
        clonedThinRectangle.draw();
        System.out.println();
    }

    private static void demonstratePerformanceBenefits() {
        System.out.println("5. Demonstrating Performance Benefits");
        System.out.println("-".repeat(50));

        int iterations = 1000;

        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            Shape clonedShape = ShapeRegistry.getShape("circle");
        }
        long cloneTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            Circle newCircle = new Circle(0, 0, 10);
        }
        long createTime = System.nanoTime() - startTime;

        System.out.println("Performance comparison (" + iterations + " iterations):");
        System.out.println("Cloning time: " + (cloneTime / 1000000.0) + " ms");
        System.out.println("Creation time: " + (createTime / 1000000.0) + " ms");

        if (cloneTime < createTime) {
            System.out.println("Cloning was faster!");
        } else {
            System.out.println("Direct creation was faster (in this simple case)");
        }
    }


    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Select a vehicle category:");
        System.out.println("1. Land Vehicles (Car, Bike)");
        System.out.println("2. Water Vehicles (Boat, Submarine)");
        System.out.println("3. Air Vehicles (Airplane, Helicopter)");
        System.out.println("0. Exit");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (0-3): ");
    }

    private static int getUserChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid choice. Please enter 0-3.");
                return getUserChoice();
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number (0-3).");
            return getUserChoice();
        }
    }

    private static void processUserChoice(int choice) {
        switch (choice) {
            case 1 -> createLandVehicle();
            case 2 -> createWaterVehicle();
            case 3 -> createAirVehicle();
        }
    }

    private static void createLandVehicle() {
        System.out.println("\n--- Land Vehicle Creation ---");
        System.out.println("Available types: Car, Bike");
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine().trim();

        VehicleDetails details = getVehicleDetails();

        try {
            AbstractVehicle vehicle = landFactory.createLandVehicle(type, details.name, details.size, details.speed);
            demonstrateVehicle(vehicle);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Please try again with a valid land vehicle type (Car, Bike).");
        }
    }

    private static void createWaterVehicle() {
        System.out.println("\n--- Water Vehicle Creation ---");
        System.out.println("Available types: Boat, Submarine");
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine().trim();

        VehicleDetails details = getVehicleDetails();

        try {
            AbstractVehicle vehicle = waterFactory.createWaterVehicle(type, details.name, details.size, details.speed);
            demonstrateVehicle(vehicle);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Please try again with a valid water vehicle type (Boat, Submarine).");
        }
    }

    private static void createAirVehicle() {
        System.out.println("\n--- Air Vehicle Creation ---");
        System.out.println("Available types: Airplane, Helicopter");
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine().trim();

        VehicleDetails details = getVehicleDetails();

        try {
            AbstractVehicle vehicle = airFactory.createAirVehicle(type, details.name, details.size, details.speed);
            demonstrateVehicle(vehicle);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Please try again with a valid air vehicle type (Airplane, Helicopter).");
        }
    }

    private static VehicleDetails getVehicleDetails() {
        System.out.print("Enter vehicle name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter vehicle size (Small/Medium/Large): ");
        String size = scanner.nextLine().trim();

        System.out.print("Enter initial speed: ");
        int speed;
        try {
            speed = Integer.parseInt(scanner.nextLine().trim());
            speed = Math.max(0, speed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid speed entered. Setting speed to 0.");
            speed = 0;
        }

        return new VehicleDetails(name, size, speed);
    }

    private static void demonstrateVehicle(AbstractVehicle vehicle) {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("Vehicle Created Successfully!");
        System.out.println("-".repeat(40));

        // Start the engine
        System.out.println(vehicle.startEngine());

        // Show initial state
        System.out.println("Initial state: " + vehicle.toString());

        // Demonstrate acceleration
        System.out.println("\nAccelerating by 50...");
        vehicle.accelerate(50);
        System.out.println("Current speed: " + vehicle.getSpeed());

        // Demonstrate more acceleration
        System.out.println("Accelerating by 30...");
        vehicle.accelerate(30);
        System.out.println("Current speed: " + vehicle.getSpeed());

        // Demonstrate braking
        System.out.println("Braking by 20...");
        vehicle.brake(20);
        System.out.println("Current speed after braking: " + vehicle.getSpeed());

        // Show final state
        System.out.println("Final state: " + vehicle.toString());
        System.out.println("-".repeat(40));
    }

    private static void testFactoryPattern() {
        System.out.println("Factory Pattern Example");
        try{
            while(true){
                System.out.print("Enter car type (Car, Bike, Truck): ");

                String type = scanner.nextLine();
                System.out.println("Enter car name: ");
                String name = scanner.nextLine();

                System.out.println("Enter car size: ");
                String size = scanner.nextLine();

                System.out.println("Enter car current speed: ");
                int speed = Integer.parseInt(scanner.nextLine());

                VehicleInterface vehicle = VehicleFactory.getVehicle(type, name, size, speed);

                System.out.println("Vehicle created: " + vehicle.startEngine());

                vehicle.accelerate(500);
                System.out.println("Current speed after acceleration: " + vehicle.getSpeed());

                vehicle.brake(200);
                System.out.println("Current speed after braking: " + vehicle.getSpeed());


                System.out.println("Do you want to create another vehicle? (yes/no): ");
                String answer = scanner.nextLine();
                if(answer.equalsIgnoreCase("no")){
                    System.out.println("Exiting...");
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void testBasicSingleton() {
        System.out.println("1. Testing Basic Singleton Behavior:");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger1 hash: " + logger1.hashCode());
        System.out.println("Logger2 hash: " + logger2.hashCode());
        System.out.println("Same instance? " + (logger1 == logger2));
        System.out.println();
    }

    private static void testThreadSafety() {
        System.out.println("2. Testing Thread Safety:");

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(() -> {
                Logger logger = Logger.getInstance();
                logger.log("Thread " + threadNum + " got logger instance: " + logger.hashCode());
            }, "Worker-" + threadNum);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    private static void testClonePrevention() {
        System.out.println("3. Testing Clone Prevention:");

        Logger logger = Logger.getInstance();

        try {
            Logger clonedLogger = (Logger) logger.clone();
            System.out.println("ERROR: Cloning succeeded (this shouldn't happen)");
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone prevention working: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testSerializationSafety() {
        //Serialize the logger to a file
        System.out.println("4. Testing Serialization Safety:");
        Logger logger1 = Logger.getInstance();
        String filename = "logger.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(logger1);
            System.out.println("Logger serialized to " + filename);
        } catch (java.io.IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }

        //Deserialize the logger from the file
        try (ObjectInputStream in = new java.io.ObjectInputStream(new FileInputStream(filename))) {
            Logger logger2 = (Logger) in.readObject();
            System.out.println("Logger deserialized from " + filename);
            System.out.println("Logger1 hash: " + logger1.hashCode());
            System.out.println("Logger2 hash: " + logger2.hashCode());
            System.out.println("Same instance? " + (logger1 == logger2));
        } catch (java.io.IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
    }

    private static void testLoggingMethods() {
        System.out.println("5. Testing Different Logging Methods:");

        Logger logger = Logger.getInstance();

        logger.log("This is a basic log message");

        logger.logError("This is an error message");

        logger.logInfo("This is an info message with timestamp");

        simulateApplicationEvents();
    }

    private static void simulateApplicationEvents() {
        Logger logger = Logger.getInstance();

        logger.logInfo("Application starting...");

        try {
            Thread.sleep(100);
            logger.log("User authentication successful");

            Thread.sleep(50);
            logger.log("Database connection established");

            Thread.sleep(75);
            logger.logInfo("Processing user request");

            Thread.sleep(25);
            logger.log("Request processed successfully");

        } catch (InterruptedException e) {
            logger.logError("Application interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        logger.logInfo("Application workflow completed");
    }

    private static class VehicleDetails {
        final String name;
        final String size;
        final int speed;

        VehicleDetails(String name, String size, int speed) {
            this.name = name;
            this.size = size;
            this.speed = speed;
        }
    }
}

