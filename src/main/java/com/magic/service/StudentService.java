package com.magic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.model.Student;
import com.magic.repository.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	StudentDao sDao;

	public Student insert(Student s) {
		// TODO Auto-generated method stub
		return sDao.save(s);
	}

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return sDao.findAll();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		sDao.deleteById(id);
	}

}
