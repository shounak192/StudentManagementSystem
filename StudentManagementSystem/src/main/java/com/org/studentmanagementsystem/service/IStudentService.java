package com.org.studentmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.models.Course;
import com.org.studentmanagementsystem.models.Student;

@Service
public interface IStudentService {
	
	public Student create(Student student); 
	
	public Student view(Integer id);
	
	public List<Student> viewAll();
	
	public Student update(Integer id, Student student);
	
	public Student delete(Integer id);
	
	public Course enrollCourse(Integer studentId, Integer courseId);
	
	public Course discardCourse(Integer studentId, Integer courseId);
	
	public List<Course> viewAllCourseByStudent(Integer studentId);

}
