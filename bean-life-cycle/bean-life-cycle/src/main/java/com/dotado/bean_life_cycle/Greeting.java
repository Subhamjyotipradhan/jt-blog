package com.dotado.bean_life_cycle;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class Greeting {
    public Greeting(){
        System.out.println("Greeting object is constructed");
    }
   
     @PreDestroy
    public void destroyGreeting(){
        System.out.println("hello object is destroy");
    }
}

