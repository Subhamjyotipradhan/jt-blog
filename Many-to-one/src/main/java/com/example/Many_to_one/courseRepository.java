package com.example.Many_to_one;

import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<Course,Integer>{
    
}
