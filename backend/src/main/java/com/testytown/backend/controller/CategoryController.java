package com.testytown.backend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testytown.backend.dto.CategoryRequestDTO;
import com.testytown.backend.entity.Category;
import com.testytown.backend.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

   @PostMapping
   public ResponseEntity <Category> creatCategory(@RequestBody CategoryRequestDTO requestDTO) {
        // return categoryService.savCategory(requestDTO);

        return new ResponseEntity<>(categoryService.saveCategory(requestDTO),HttpStatus.CREATED);
   }
}
