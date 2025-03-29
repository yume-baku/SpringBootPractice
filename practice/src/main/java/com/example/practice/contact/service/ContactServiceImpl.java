package com.example.practice.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.contact.entity.Contact;
import com.example.practice.contact.form.ContactForm;
import com.example.practice.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// 問合せ情報の保存
	@Override
	public void saveContact(ContactForm contactForm) {

		Contact contact = new Contact();

		contact.setLastName(contactForm.getLastName());
		contact.setFirstName(contactForm.getFirstName());
		contact.setEmail(contactForm.getEmail());
		contact.setPhone(contactForm.getPhone());
		contact.setZipCode(contactForm.getZipCode());
		contact.setAddress(contactForm.getAddress());
		contact.setBuildingName(contactForm.getBuildingName());
		contact.setContactType(contactForm.getContactType());
		contact.setBody(contactForm.getBody());

		contactRepository.save(contact);
	}

	// 問合せ情報の検索
	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	public Contact findById(Long id) {
		return contactRepository.findById(id).get();
	}

}
