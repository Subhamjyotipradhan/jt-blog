package com.example.animal;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class tiger {
    public tiger(){
        System.out.println("Greeting object is constructed");
    }
   
     @PreDestroy
    public void destroytiger(){
        System.out.println("hello object is destroy");
    }
}