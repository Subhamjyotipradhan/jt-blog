package com.dotado.di;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(value = "singleton") // This is the default scope, so it can be omitted

public class Car {
    //DI - It is a mechanism through which spring asssign the address of the been to a referance variable.

    // @Autowired //It gives the instruction to the spring container to assig the address of the engine class in the engine reference variable.
    private Engine engine;

    //setter based injection
    // @Autowired
    // public void setEngine(Engine engine) {
    //     System.out.println("Setter method called -DI");
    //     this.engine = engine;
    // }

// Constructor based injection
    @Autowired
    public Car(Engine engine) {
        System.out.println("Constructor method called -DI");
        this.engine = engine;
    }
    public Car() {
        
    }
    public  void runCar() {

        engine.startEngine();
        System.out.println("Car is running");
    }
}