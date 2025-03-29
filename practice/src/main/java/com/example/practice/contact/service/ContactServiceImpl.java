package com.example.practice.contact.service;

import java.util.Date;
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

	// 問合せ情報の更新
	@Override
	public void updateContact(ContactForm contactForm) {

		Contact contact = findById(contactForm.getId());

		contact.setLastName(contactForm.getLastName());
		contact.setFirstName(contactForm.getFirstName());
		contact.setEmail(contactForm.getEmail());
		contact.setPhone(contactForm.getPhone());
		contact.setZipCode(contactForm.getZipCode());
		contact.setAddress(contactForm.getAddress());
		contact.setBuildingName(contactForm.getBuildingName());
		contact.setContactType(contactForm.getContactType());
		contact.setBody(contactForm.getBody());
		contact.setUpdatedAt(new Date());

		contactRepository.save(contact);
	}

	// 問合せ情報の削除
	@Override
	public void deleteContactById(Long id) {

		contactRepository.deleteById(id);
	}

	// 問合せフォーム用の形式に変換
	public ContactForm toContactForm(Contact contact) {

		ContactForm contactForm = new ContactForm();

		contactForm.setId(contact.getId());
		contactForm.setLastName(contact.getLastName());
		contactForm.setFirstName(contact.getFirstName());
		contactForm.setEmail(contact.getEmail());
		contactForm.setPhone(contact.getPhone());
		contactForm.setZipCode(contact.getZipCode());
		contactForm.setAddress(contact.getAddress());
		contactForm.setBuildingName(contact.getBuildingName());
		contactForm.setContactType(contact.getContactType());
		contactForm.setBody(contact.getBody());

		return contactForm;
	}

	// 問合せ情報の全件取得
	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	// 問合せ情報の検索
	@Override
	public Contact findById(Long id) {
		return contactRepository.findById(id).get();
	}

}
