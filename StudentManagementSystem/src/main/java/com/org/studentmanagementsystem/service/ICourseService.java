package com.org.studentmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.models.Course;

@Service
public interface ICourseService {
	
	public Course create(Course course);
	
	public Course view(Integer id);
	
	public List<Course> viewAll();
	
	public Course update(Integer id, Course course);
	
	public Course delete(Integer id);
}
