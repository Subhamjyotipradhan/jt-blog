package com.tastytown.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI(){
        return new OpenAPI().info(getInfo());

    }
    private Info getInfo(){
        var info = new Info().title("Tasty Town").version("v2").description("A web Application for ordering food");
        return info;
    }
}
