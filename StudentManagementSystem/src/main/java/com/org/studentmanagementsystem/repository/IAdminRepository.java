package com.org.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.studentmanagementsystem.models.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	
}
