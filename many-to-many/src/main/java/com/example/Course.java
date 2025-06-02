package com.example;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
    @Id
    private int courseId;
    private String courseName;

    @ManyToMany(mappedBy = "courses" , fetch = FetchType.EAGER)
    private List<Student> students;

}
