package com.dotado.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class depencyInjectionDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(depencyInjectionDemoApplication.class, args);
        // context.getBean(Car.class);
        Car car = context.getBean(Car.class);
        car.runCar();


        // Car car2 = context.getBean(Car.class);

        // System.out.println(car.hashCode());
        // System.out.println(car2.hashCode());
	}

}
