package com.magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.magic.model.Student;

// Added @Transactional for the delete method
@Transactional
public interface StudentDao extends JpaRepository<Student, Integer>{


}
