package com.example.practice.admin.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.admin.entity.Admin;
import com.example.practice.admin.form.AdminForm;
import com.example.practice.admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	// 管理者情報の保存
	@Override
	public void saveAdmin(AdminForm adminForm) {

		Admin admin = new Admin();

		admin.setLastName(adminForm.getLastName());
		admin.setFirstName(adminForm.getFirstName());
		admin.setEmail(adminForm.getEmail());
		admin.setPassword(adminForm.getPassword());
		admin.setCurrentSignInAt(new Date());
		admin.setCreatedAt(new Date());
		admin.setUpdatedAt(new Date());

		adminRepository.save(admin);
	}
}
