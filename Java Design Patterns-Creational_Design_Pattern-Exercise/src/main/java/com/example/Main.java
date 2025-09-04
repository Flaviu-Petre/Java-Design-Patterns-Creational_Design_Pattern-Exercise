package com.example;

import com.example.SingletonPattern.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Singleton Pattern Example");

        testBasicSingleton();

        testThreadSafety();

        testClonePrevention();

        testSerializationSafety();

        testLoggingMethods();
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
}

