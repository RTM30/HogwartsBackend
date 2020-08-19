package com.magic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.model.Student;
import com.magic.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentsController {
	
	@Autowired
	StudentService ss;
	
	// Save
	@PostMapping("/insert")
	Student insert(@RequestBody Student s) {
		System.out.println("Controller: Saving a user to the database");
		return ss.insert(s);
	}
	
	// Find All
	@GetMapping("/findall")
	List<Student> getAll(@RequestBody(required = false) Student s) {
		System.out.println("Controller: Getting all users from the database");
		return ss.getAll();
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable String id) {
		System.out.println("Controller: Deleting a user from the database");
		int studentId = Integer.parseInt(id);
		ss.deleteById(studentId);
	}
	
	// This successfully reads studentId and password from request
	@PostMapping("/login")
	Student test(@RequestBody String loginCredentials) {
		
		// Convert JSON to a seperate student ID and password
		String[] credentialsArray = loginCredentials.split(",");
		
		// Convert JSON to readable strings
		String studentId = credentialsArray[0].substring(14,22).trim();
		String password = credentialsArray[1].substring(12,16).trim();
		
		//Output the studentId and password (testing purposes)
		System.out.println("StudentID in the controller is: " + studentId);
		System.out.println("Password in the controller is: " + password);
		
		// Compare studentId and password
		Student s = ss.login(studentId, password);
		
		return s;
	}

}
