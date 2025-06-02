package com.example.Many_to_one;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication implements CommandLineRunner{
	private final courseRepository courseRepository;
	private final teacherRepository teacherRepository;
	public static void main(String[] args) {
		SpringApplication.run(ManyToOneApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Teacher existingTeacher = teacherRepository.findById("5b8a8654-e7a5-4fad-affd-a601e692be4c").orElseThrow();
		System.out.println("See the teacher details");
		System.out.println(existingTeacher.getTeacherName());
		System.out.println(existingTeacher.getTeacherEmail());
		
	}

	public void unidirectional(){

	
		Course course1 = Course.builder().courseName("C").build();
		Course course2 = Course.builder().courseName("C++").build();
		Course course3 = Course.builder().courseName("Java").build();
		Course course4 = Course.builder().courseName("JavaScript").build();
		Course course5 = Course.builder().courseName("Python").build();
		Course course6 = Course.builder().courseName("Php").build();

		Teacher teacher1 = Teacher.builder().teacherName("Amiya Sir").teacherEmail("a@gmail.com").build();
		Teacher teacher2 = Teacher.builder().teacherName("Rahul Sir").teacherEmail("r@gmail.com").build();
		Teacher teacher3 = Teacher.builder().teacherName("Rohan Sir").teacherEmail("ro@gmail.com").build();

		course1.setTeacher(teacher1);
		course2.setTeacher(teacher1);

		course3.setTeacher(teacher2);
		course4.setTeacher(teacher2);

		course5.setTeacher(teacher3);
		course6.setTeacher(teacher3);

		// courseRepository.saveAll(List.of(course1, course2, course3, course4, course5, course6));

		Course existingCourse = courseRepository.findById(1).orElseThrow();
		existingCourse.setCourseName("C1");
		existingCourse.getTeacher().setTeacherName("Amiya1");
		// courseRepository.save(existingCourse);

		//Extract -> Course (many-to-one) => EAGER
		System.out.println("See the course details");
		System.out.println(existingCourse.getCourseName());

		Teacher existingCourseTeacher = existingCourse.getTeacher();
		System.out.println(existingCourseTeacher.getTeacherName());
		System.out.println(existingCourseTeacher.getTeacherEmail());
	}

	
}