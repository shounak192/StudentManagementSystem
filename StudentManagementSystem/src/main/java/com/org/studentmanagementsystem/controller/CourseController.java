package com.org.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.studentmanagementsystem.models.Course;
import com.org.studentmanagementsystem.service.ICourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	private ICourseService courseService;

	@Autowired
	public CourseController(ICourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Course> create(@RequestBody Course course) {
		
		return new ResponseEntity<>(courseService.create(course), HttpStatus.OK);
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Course> view(@PathVariable Integer id) {
		
		return new ResponseEntity<>(courseService.view(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<Course>> viewAll() {
		
		return new ResponseEntity<>(courseService.viewAll(), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Course> update(@PathVariable Integer id, @RequestBody Course course) {
		
		return new ResponseEntity<>(courseService.update(id, course), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Course> delete(@PathVariable Integer id) {
		
		return new ResponseEntity<>(courseService.delete(id), HttpStatus.OK);
	}
}
