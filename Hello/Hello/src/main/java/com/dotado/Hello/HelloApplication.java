package com.dotado.Hello;

import com.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class HelloApplication {

    private final Employee employee;

    HelloApplication(Employee employee) {
        this.employee = employee;
    }

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(HelloApplication.class, args);
		Person person = context.getBean(Person.class);
		person.seyHello();

			Student student = context.getBean(Student.class);
			student.seyHello();

		Employee employee = context.getBean(Employee.class);
		employee.seyHello();

		Teacher teacher = context.getBean(Teacher.class);
		teacher.seyHello();
	}

}
