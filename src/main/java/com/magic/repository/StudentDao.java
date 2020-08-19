package com.magic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.magic.model.Student;

// Added @Transactional for the delete method
@Transactional
public interface StudentDao extends JpaRepository<Student, Integer>{
	
	Student findFirstBystudentIdAndPassword(String studentId, String firstName) throws NullPointerException;


}
