package com.org.studentmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.studentmanagementsystem.models.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{
	
	Optional<Student> findByUsername(String username);

}
