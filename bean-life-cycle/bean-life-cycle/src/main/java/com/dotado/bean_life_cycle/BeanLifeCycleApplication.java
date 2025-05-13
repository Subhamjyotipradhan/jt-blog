package com.dotado.bean_life_cycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {

    // private final Greet greet;

    // BeanLifeCycleApplication(Greet greet) {
    //     this.greet = greet;
    // }

	public static void main(String[] args) {
		System.out.println("mane start");
		Greet greet = SpringApplication.run(BeanLifeCycleApplication.class, args).getBean(Greet.class);
		
		// ApplicationContext context = SpringApplication.run(BeanLifeCycleApplication.class, args);
		// Greet greet = context.getBean(Greet.class);

		greet.seyHello();
		System.out.println("mane end");
	}

}



//Bean instravtion 
//Di
//Intialization
//bean Usage
//Bean destory