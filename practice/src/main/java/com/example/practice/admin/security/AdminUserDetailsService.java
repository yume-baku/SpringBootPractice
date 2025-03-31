package com.example.practice.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.practice.admin.entity.Admin;
import com.example.practice.admin.repository.AdminRepository;

@Service
public class AdminUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Admin admin = adminRepository.findByEmailEquals(username)
				.orElseThrow(() -> new UsernameNotFoundException("Admin Not Found"));

		return User
				.withUsername(admin.getEmail())
				.password(admin.getPassword())
				.roles("ADMIN")
				.build();
	}
}
