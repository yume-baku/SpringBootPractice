package com.example.practice.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
