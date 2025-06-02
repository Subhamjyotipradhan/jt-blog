package com.example.intro_to_rest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.var;



// @RestController
@Controller
@RequiredArgsConstructor
public class StudentController {
    private final ObjectMapper objectMapper;
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(101,"Raja");
    }

    @GetMapping("/student2")
    @ResponseBody
    public void getStudent2() throws JsonProcessingException {
        var student = new Student(102,"Rana");
        objectMapper.writeValueAsString(student);
    }
    
    @GetMapping("/student3")
    @ResponseBody
    public Student getStudent3() throws JsonProcessingException{
        String json = """
                {
                    "roll" : 101,
                    "Name" : "Raka"
                }
                """;

        Student jsonStudent = objectMapper.readValue(json, Student.class);
        System.out.println(jsonStudent);
        return jsonStudent;
    }
    
}
