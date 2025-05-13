package com.example.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class AnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
	}

	private final tiger Tiger;
    public AnimalApplication(tiger Tiger){
        System.out.println("Hello ");
        this.Tiger = Tiger;
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
