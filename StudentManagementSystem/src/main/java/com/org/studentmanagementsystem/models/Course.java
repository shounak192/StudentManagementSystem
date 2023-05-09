package com.org.studentmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;

	@ManyToOne(targetEntity = Student.class)
	@JsonBackReference
	private Student student;

	public Course() {
	}

	public Course(Integer id, String name, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public Course setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Course setName(String name) {
		this.name = name;
		return this;
	}
	
	public Student getStudent() {
		return student;
	}

	public Course setStudent(Student student) {
		this.student = student;
		return this;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", student=" + student + "]";
	}

}
