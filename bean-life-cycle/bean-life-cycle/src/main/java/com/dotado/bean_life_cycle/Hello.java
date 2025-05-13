package com.dotado.bean_life_cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Hello {

    private final Greeting greeting;
    public Hello(Greeting greeting){
        System.out.println("Hello ");
        this.greeting = greeting;
    }

    @Autowired
    public void setGreeting() {
        System.out.println("dependency injacted");
        // this.greeting = greeting;
    }

    @PostConstruct
    public void init() {
        System.out.println("into method of greet  class");
        
    }

    public void seyHello(){
        System.out.println("Hello from greet");
    }

    @PreDestroy
    public void DestroyGreet(){
        System.out.println("Hello from pre Destroy");
    }
}
