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

import com.org.studentmanagementsystem.models.Student;
import com.org.studentmanagementsystem.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private IStudentService studentService;

	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/create")
	public ResponseEntity<Student> create(@RequestBody Student student) {

		return new ResponseEntity<>(studentService.create(student), HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Student> view(@PathVariable Integer id) {

		return new ResponseEntity<>(studentService.view(id), HttpStatus.OK);
	}

	@GetMapping("/viewall")
	public ResponseEntity<List<Student>> viewAll() {

		return new ResponseEntity<>(studentService.viewAll(), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {

		return new ResponseEntity<>(studentService.update(id, student), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> delete(@PathVariable Integer id) {

		return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
	}

	@PostMapping("/enrollcourse/{studentId}/{courseId}")
	public ResponseEntity<Student> enrollCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {

		return new ResponseEntity<>(studentService.enrollCourse(studentId, courseId), HttpStatus.OK);
	}

	@DeleteMapping("/discardcourse/{studentId}/{courseId}")
	public ResponseEntity<Student> discardCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {

		return new ResponseEntity<>(studentService.discardCourse(studentId, courseId), HttpStatus.OK);
	}

	@GetMapping("/viewallbycourse/{courseId}")
	public ResponseEntity<List<Student>> viewAllStudentsByCourse(@PathVariable Integer courseId) {

		return new ResponseEntity<>(studentService.viewAllStudentsByCourse(courseId), HttpStatus.OK);
	}

}
