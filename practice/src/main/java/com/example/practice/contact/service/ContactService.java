package com.example.practice.contact.service;

import java.util.List;

import com.example.practice.contact.entity.Contact;
import com.example.practice.contact.form.ContactForm;

public interface ContactService {

	void saveContact(ContactForm contactForm);

	void updateContact(ContactForm contactForm);

	void deleteContactById(Long id);

	ContactForm toContactForm(Contact contact);

	List<Contact> getAllContacts();

	Contact findById(Long id);
}
