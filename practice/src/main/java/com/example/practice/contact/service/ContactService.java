package com.example.practice.contact.service;

import java.util.List;

import com.example.practice.contact.entity.Contact;
import com.example.practice.contact.form.ContactForm;

public interface ContactService {

	void saveContact(ContactForm contactForm);

	List<Contact> getAllContacts();
}
