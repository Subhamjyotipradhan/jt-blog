package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return  args -> {
			var course1 = Course.builder().courseId(101).courseName("c").build();
			var course2 = Course.builder().courseId(102).courseName("c++").build();
			var course3 = Course.builder().courseId(103).courseName("Java").build();
			var course4 = Course.builder().courseId(104).courseName("JavaScript").build();
			var course5 = Course.builder().courseId(105).courseName("Python").build();

			var student1 = Student.builder().studentId(1).studentName("Raja").studentEmail("raja@gmail.com").courses(List.of(course1,course2,course3
					)).build();
			var student2 = Student.builder().studentId(2).studentName("Raka").studentEmail("raka@gmail.com").courses(List.of(course3,course4,course5
			)).build();
			var student3 = Student.builder().studentId(3).studentName("Rana").studentEmail("rana@gmail.com").courses(List.of(course4,course2,course3
			)).build();

//			studentRepository.saveAll(List.of(student1,student2,student3));

			//FETCH STUDENT ALONG WITH ITS COURSE
//			var students = studentRepository.findAll();
//			for (Student student : students){
//				System.out.println(student.getStudentId()+"\t"+student.getStudentName()+"\t"+student.getStudentEmail());
//				var courses = student.getCourses();
//
//				for (Course course : courses){
//					System.out.println("courseInfo->\t"+course.getCourseId()+"\t"+ course.getCourseName());
//				}
//			}


			//FETCH COURSES ALONG WITH IT'S ASSOCIATED

			courseRepository.findAll().forEach(course -> {
				System.out.println(course.getCourseId()+"\t"+ course.getCourseName());

				course.getStudents().forEach(student -> {
					System.out.println(student.getStudentId()+"\t"+student.getStudentName()+"\t"+student.getStudentEmail());
				});
			});



		};
	}

}
