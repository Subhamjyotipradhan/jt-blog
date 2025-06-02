package com.testytown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testytown.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
    
}
