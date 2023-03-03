package com.org.studentmanagementsystem.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.studentmanagementsystem.dto.AdminDto;
import com.org.studentmanagementsystem.models.Admin;
import com.org.studentmanagementsystem.repository.IAdminRepository;
import com.org.studentmanagementsystem.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
	
	private IAdminRepository adminRepository;
	
	private AdminServiceImpl(IAdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin register(AdminDto adminDto) {
		
	
		
		adminRepository.save(admin);
	}

	
	@Override
	public Admin login(AdminDto adminDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
