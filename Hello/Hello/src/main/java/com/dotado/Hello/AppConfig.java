package com.dotado.Hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //it is another to tell thespring that some beans are
                //registered within this file
public class AppConfig {
    @Bean
    public Teacher getTeacher(){
        System.out.println("Factory method  - returns beans");
        return new Teacher();
    }
}
