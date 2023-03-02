package com.org.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.studentmanagementsystem.models.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
