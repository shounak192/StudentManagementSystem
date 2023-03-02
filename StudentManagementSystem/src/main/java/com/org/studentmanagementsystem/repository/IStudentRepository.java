package com.org.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.studentmanagementsystem.models.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
