package com.testytown.backend.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.testytown.backend.dto.CategoryRequestDTO;
import com.testytown.backend.entity.Category;
import com.testytown.backend.repository.CategoryRepository;


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
