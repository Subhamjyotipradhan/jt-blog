package com.tastytown.backend.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.repository.CategoryRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Object findAllCategory;
    public Category saveCategory(CategoryRequestDTO requestDTO){
        var category = Category.builder().categoryName(requestDTO.getCategoryName()).build();
        return categoryRepository.save(category);

    }
    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }
    
}
