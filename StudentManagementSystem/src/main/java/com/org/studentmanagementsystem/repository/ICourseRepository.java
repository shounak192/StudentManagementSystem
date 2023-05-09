package com.org.studentmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.studentmanagementsystem.models.Course;
import com.org.studentmanagementsystem.models.Student;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByStudent(Student student);

}
