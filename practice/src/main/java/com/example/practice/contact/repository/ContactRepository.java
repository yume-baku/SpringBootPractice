package com.example.practice.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.contact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
