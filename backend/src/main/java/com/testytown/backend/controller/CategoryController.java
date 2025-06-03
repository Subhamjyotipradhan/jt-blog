package com.testytown.backend.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testytown.backend.dto.CategoryRequestDTO;
import com.testytown.backend.entity.Category;
import com.testytown.backend.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

   @PostMapping
   @ApiResponse(responseCode = "201", description = "Category Created")
   @Operation(summary = "Create a new Category")
   @Tag(name = "Category API", description = "This Controller manager crud operation for category entity")
   public ResponseEntity <Category> creatCategory(@RequestBody CategoryRequestDTO requestDTO) {
        // return categoryService.savCategory(requestDTO);

        return new ResponseEntity<>(categoryService.saveCategory(requestDTO),HttpStatus.CREATED);
   }
   @GetMapping
   public List<Category> getAllCategories(){
     return categoryService.findAllCategories();
   }

}
