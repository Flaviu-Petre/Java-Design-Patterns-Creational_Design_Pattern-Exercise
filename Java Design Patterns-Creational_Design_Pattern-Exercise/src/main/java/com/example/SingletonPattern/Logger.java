package com.example.SingletonPattern;

import java.io.Serializable;

public class Logger implements Cloneable, Serializable {
    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this object is not allowed");
    }

    private Object readResolve() {
        return instance;
    }

    public synchronized void log(String message) {
        System.out.println("Log: " + message);
    }

    public synchronized void logError(String message) {
        System.err.println("[" + Thread.currentThread().getName() + "] ERROR: " + message);
    }

    public synchronized void logInfo(String message) {
        System.out.println("[" + Thread.currentThread().getName() + "] INFO: " +
                java.time.LocalDateTime.now() + " - " + message);
    }
}
