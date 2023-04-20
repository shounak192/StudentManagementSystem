package com.org.studentmanagementsystem.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exceptions.DuplicateAdminException;
import com.org.studentmanagementsystem.exceptions.InvalidAdminException;
import com.org.studentmanagementsystem.models.Admin;
import com.org.studentmanagementsystem.repository.IAdminRepository;
import com.org.studentmanagementsystem.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	/*
	 * constructor based DI
	 */
	private IAdminRepository adminRepository;

	@Autowired
	private AdminServiceImpl(IAdminRepository adminRepositoryparam) {
		this.adminRepository = adminRepositoryparam;
	}

	@Override
	public Admin register(Admin admin) {

		Optional<Admin> optionalAdmin = adminRepository.findByUsername(admin.getUsername());
		if (optionalAdmin.isPresent())
			throw new DuplicateAdminException("Duplicate Admin present");
		
		return adminRepository.save(admin);
	}

	@Override
	public Admin login(Admin admin) {
		
		Example<Admin> exampleAdmin = Example.of(admin);
		
		Optional<Admin> optionalAdmin = adminRepository.findOne(exampleAdmin);
		
		if(optionalAdmin.isEmpty())
			throw new InvalidAdminException("Admin not found");
		
		return optionalAdmin.get();
		
	}

}
