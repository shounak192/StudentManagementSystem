package com.org.studentmanagementsystem.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Student {
	
	@Id
	private Integer id;
	private String username;
	private String password;

	@OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy = "student")
	private List<Course> courseList;

	private Student(Integer id, String username, String password, List<Course> courseList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.courseList = courseList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", courseList=" + courseList
				+ "]";
	}

}
