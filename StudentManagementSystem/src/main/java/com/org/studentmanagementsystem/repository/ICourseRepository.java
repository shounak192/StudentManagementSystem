package com.org.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.studentmanagementsystem.models.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer>{

}
