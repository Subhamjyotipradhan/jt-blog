package com.example.miscellaneous_topics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiscellaneousTopicsApplication {  //implements CommandLineRunner
	private Animal animal;

	public MiscellaneousTopicsApplication(@Qualifier("dog")Animal animal){
		this.animal = animal;
	}

	public static void main(String[] args) {
		SpringApplication.run(MiscellaneousTopicsApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	// TODO Auto-generated method stub
	// 	System.out.println("Hello form Commandline Runner");
	// 	System.out.println("this method is executed just after the container is fully prepared  ");
	// }


	@Bean
	public CommandLineRunner commandLineRunner(){
		return args->{
            System.out.println("Hello form Commandline Runner");
            System.out.println("this method is executed just after the container is fully prepared  ");

			animal.eat();
        };
	}

	
}
/*
 * commandline-runner
 * //preloading of data in the database
 * //to log some startup info
 * interface beans concept
 */