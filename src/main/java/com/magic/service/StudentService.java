package com.magic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.model.Student;
import com.magic.repository.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	StudentDao sDao;

	public Student insert(Student s) {
		return sDao.save(s);
	}

	public List<Student> getAll() {
		return sDao.findAll();
	}

	public void deleteById(int id) {
		sDao.deleteById(id);
	}
	
	// login
	// If not found then s = null
	public Student login(String studentId, String password) {
		Student s = null;
		
		try {
		s = sDao.findFirstBystudentIdAndPassword(studentId, password);
		}
		
		catch(NullPointerException e) {
			System.out.println("THE NULL POINTER EXCEPTION WAS THROWN OH NOES!!!");
		}
		
		Boolean eval;
		
		// Check if studentID and password match
		if(s != null && s.getStudentId().equals(studentId) && s.getPassword().equals(password)) {
			eval = true;
			System.out.println(eval);
			
			return s;
		}
		else {
			eval = false;
			System.out.println(eval);
			
			return s;
		}
	}
}
