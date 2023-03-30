package com.org.studentmanagementsystem.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.org.studentmanagementsystem.dto.AdminDto;
import com.org.studentmanagementsystem.exceptions.DuplicateAdminException;
import com.org.studentmanagementsystem.exceptions.InvalidAdminException;
import com.org.studentmanagementsystem.models.Admin;
import com.org.studentmanagementsystem.repository.IAdminRepository;
import com.org.studentmanagementsystem.service.IAdminService;
import com.org.studentmanagementsystem.util.ModelMapperGenerator;

public class AdminServiceImpl implements IAdminService {

	/*
	 * constructor based DI
	 */
	private IAdminRepository adminRepository;

	private AdminServiceImpl(IAdminRepository adminRepositoryparam) {
		this.adminRepository = adminRepositoryparam;
	}

	@Override
	public Admin register(AdminDto adminDto) {

		Admin admin = ModelMapperGenerator.getMapper().map(adminDto, Admin.class);
		Optional<Admin> optionalAdmin = adminRepository.findByUsername(adminDto.getUsername());
		if (optionalAdmin.isPresent())
			throw new DuplicateAdminException("Duplicate Admin present");

		return adminRepository.save(admin);
	}

	@Override
	public Admin login(AdminDto adminDto) {
		
		Admin admin = ModelMapperGenerator.getMapper().map(adminDto, Admin.class);
		Example<Admin> exampleAdmin = Example.of(admin);
		
		Optional<Admin> optionalAdmin = adminRepository.findOne(exampleAdmin);
		
		if(optionalAdmin.isEmpty())
			throw new InvalidAdminException("Admin not found");
		
		return admin;
		
	}

}
