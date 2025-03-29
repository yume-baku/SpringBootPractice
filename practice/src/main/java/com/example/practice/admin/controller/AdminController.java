package com.example.practice.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.contact.entity.Contact;
import com.example.practice.contact.form.ContactForm;
import com.example.practice.contact.service.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public String contacts(Model model) {
		List<Contact> contactList = contactService.getAllContacts();
		model.addAttribute("contactList", contactList);
		return "/admin/contactList";
	}

	@GetMapping("/contact/{id}/edit")
	public String displayContactEdit(@PathVariable Long id, Model model) {
		Contact contact = contactService.findById(id);

		// ToDo サービスクラスに移動する
		ContactForm contactForm = new ContactForm();
		contactForm.setLastName(contact.getLastName());
		contactForm.setFirstName(contact.getFirstName());
		contactForm.setEmail(contact.getEmail());
		contactForm.setPhone(contact.getPhone());
		contactForm.setZipCode(contact.getZipCode());
		contactForm.setAddress(contact.getAddress());
		contactForm.setBuildingName(contact.getBuildingName());
		contactForm.setContactType(contact.getContactType());
		contactForm.setBody(contact.getBody());

		model.addAttribute("contactForm", contactForm);

		return "/admin/contactEdit";
	}
}
