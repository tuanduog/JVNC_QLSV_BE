package com.edu.student_management_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementBackendApplication.class, args);
	}

}
// Sử dụng kiến trúc mvc
// Client request -> Controller -> service -> repo -> model

