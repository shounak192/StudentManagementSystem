package com.org.studentmanagementsystem.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exceptions.CourseNotFoundException;
import com.org.studentmanagementsystem.models.Course;
import com.org.studentmanagementsystem.repository.ICourseRepository;
import com.org.studentmanagementsystem.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

	private ICourseRepository courseRepository;

	@Autowired
	public CourseServiceImpl(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course create(Course course) {

		return courseRepository.save(course);
	}

	@Override
	public Course view(Integer id) {

		return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));
	}

	@Override
	public List<Course> viewAll() {

		return courseRepository.findAll();
	}

	@Override
	public Course update(Integer id, Course course) {

		return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"))
				.setName(course.getName());
	}

	@Override
	public Course delete(Integer id) {

		Optional<Course> optionalCourse = Optional.ofNullable(
				courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found")));

		courseRepository.deleteById(id);
		return optionalCourse.get();

	}

}
