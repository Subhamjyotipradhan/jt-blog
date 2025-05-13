package com.example.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class Leo {
    private tiger greeting;
    public Leo() {
        System.out.println("Greet Object is Constructed");
    }

    @Autowired
    public void setGreeting(tiger greeting) {
        System.out.println("Dependency  Injected");
        this.greeting = greeting;
    }

    public void seyHello(){
        System.out.println("Hello from greet");
    }

    @PreDestroy
    public void destroyGreet(){
        System.out.println("Greet object is destroy");
    }
}
