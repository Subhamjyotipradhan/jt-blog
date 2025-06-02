package com.example.one_to_one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {
	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Student student =Student.builder()
								.studentName("raja")
								.studentEmail("Raja@gmail.com")
								.build();

			Address address = Address.builder()
								.city("BBSR")
								.state("Odisha")
								.country("India")
								.build();
			
			student.setAddress(address);
			// studentRepository.save(student);

			// Student existingStudent = studentRepository.findById(1).orElseThrow();
			// existingStudent.setStudentName("Subham");
			// existingStudent.getAddress().setCity("cuttack");

			// studentRepository.delete(existingStudent);
			


			//Retrieve

			// Student existingStudent = studentRepository.findById(2).orElseThrow();
			// System.out.println(existingStudent.getStudentRoll());
			// System.out.println(existingStudent.getStudentName());
			// System.out.println(existingStudent.getStudentEmail());


			// Address existingAddress = existingStudent.getAddress();


			// System.out.println(existingAddress.getCity());
			// System.out.println(existingAddress.getState());
			// System.out.println(existingAddress.getCountry()); //fetch for lazy




			//Retrieve student from Address
			// Address existingAddress = addressRepository.findById("23d2000d-701b-408d-9135-a8174f881f8a").orElseThrow();
			// Student existingAddresStudent = existingAddress.getStudent();
			// System.out.println(existingAddresStudent.getStudentRoll());
			// System.out.println(existingAddresStudent.getStudentName());
			// System.out.println(existingAddresStudent.getStudentEmail());

			Student student2 = Student.builder()
				.studentName("Subham")
				.studentEmail("Subham@gmail.com")
				.build();

			Address address2 = Address.builder()
				.city("puri")
				.state("Odisha")
				.country("ind")
				.student(student2)
				.build();

			student2.setAddress(address2);
			studentRepository.save(student2);
			// addressRepository.save(address2);
		};
	}

}
