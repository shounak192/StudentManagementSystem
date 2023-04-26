package com.org.studentmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.models.Student;

@Service
public interface IStudentService {
	
	public Student create(Student student); 
	
	public Student view(Integer id);
	
	public List<Student> viewAll();
	
	public Student update(Integer id, Student student);
	
	public Student delete(Integer id);
	
	public Student enrollCourse(Integer studentId, Integer courseId);
	
	public Student discardCourse(Integer studentId, Integer courseId);
	
	public List<Student> viewAllStudentsByCourse(Integer courseId);

}
