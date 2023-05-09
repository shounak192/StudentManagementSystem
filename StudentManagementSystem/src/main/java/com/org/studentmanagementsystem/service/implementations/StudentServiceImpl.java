package com.org.studentmanagementsystem.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exceptions.CourseNotFoundException;
import com.org.studentmanagementsystem.exceptions.DuplicateStudentException;
import com.org.studentmanagementsystem.exceptions.StudentNotFoundException;
import com.org.studentmanagementsystem.models.Course;
import com.org.studentmanagementsystem.models.Student;
import com.org.studentmanagementsystem.repository.ICourseRepository;
import com.org.studentmanagementsystem.repository.IStudentRepository;
import com.org.studentmanagementsystem.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	private IStudentRepository studentRepository;
	private ICourseRepository courseRepository;

	@Autowired
	public StudentServiceImpl(IStudentRepository studentRepository, ICourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	public Student create(Student student) {

		Optional<Student> optionalStudent = studentRepository.findByUsername(student.getUsername());
		if (optionalStudent.isPresent())
			throw new DuplicateStudentException("Duplicate Student present");

		return studentRepository.save(student);
	}

	@Override
	public Student view(Integer id) {

		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
	}

	@Override
	public List<Student> viewAll() {

		return studentRepository.findAll();
	}

	@Override
	public Student update(Integer id, Student student) {

		Student updatedStudent = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found")).setUsername(student.getUsername())
				.setPassword(student.getPassword());

		return studentRepository.save(updatedStudent);
	}

	@Override
	public Student delete(Integer id) {

		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isEmpty())
			throw new StudentNotFoundException("Student not found");

		studentRepository.deleteById(id);
		return optionalStudent.get();
	}

	@Override
	public Course enrollCourse(Integer studentId, Integer courseId) {

		Student foundStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));

		Course foundCourse = courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course not found")).setStudent(foundStudent);

		return courseRepository.save(foundCourse);

	}

	@Override
	public Course discardCourse(Integer studentId, Integer courseId) {

		Student foundStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));

		Course foundCourse = courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course not found")).setStudent(null);

		return courseRepository.save(foundCourse);
	}

	@Override
	public List<Course> viewAllCourseByStudent(Integer studentId) {

		Student foundStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));
		return courseRepository.findByStudent(foundStudent);
	}

}
