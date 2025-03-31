package com.example.practice.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.practice.admin.form.AdminForm;
import com.example.practice.admin.service.AdminService;
import com.example.practice.contact.entity.Contact;
import com.example.practice.contact.form.ContactForm;
import com.example.practice.contact.service.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private AdminService adminService;

	@GetMapping("/signin")
	public String signin() {

		return "/admin/signin";
	}

	@GetMapping("/signup")
	public String signup(Model model) {

		model.addAttribute("adminForm", new AdminForm());

		return "/admin/signup";
	}

	@PostMapping("/register")
	public String register(@RequestParam(required = false) String action,
			@Validated @ModelAttribute("adminForm") AdminForm adminForm, BindingResult errorResult) {

		if ("back".equals(action)) { // 戻るボタン押下時
			return String.format("redirect:/admin/signin");

		}

		if (errorResult.hasErrors()) {
			return "redirect:/admin/signup";
		}

		adminService.saveAdmin(adminForm);

		return String.format("/admin/signin");
	}

	@GetMapping("/contacts")
	public String contacts(Model model) {

		List<Contact> contactList = contactService.getAllContacts();
		model.addAttribute("contactList", contactList);
		return "/admin/contactList";
	}

	@GetMapping("/contact/{id}")
	public String displayContactView(@PathVariable Long id, Model model) {

		Contact contact = contactService.findById(id);
		model.addAttribute("contact", contact);
		return "/admin/contactView";
	}

	@GetMapping("/contact/{id}/edit")
	public String displayContactEdit(@PathVariable Long id, @RequestParam(required = false) String action,
			Model model) {

		if ("back".equals(action)) { // 戻るボタン押下時
			return "redirect:/admin/contacts";
		}

		Contact contact = contactService.findById(id);
		ContactForm contactForm = contactService.toContactForm(contact); // 編集フォーム用に変換

		model.addAttribute("contactForm", contactForm);
		return "/admin/contactEdit";
	}

	@PostMapping("/contact/{id}/update")
	public String updateContact(@PathVariable Long id, @RequestParam(required = false) String action,
			@ModelAttribute("contactForm") ContactForm contactForm) {

		if ("back".equals(action)) { // 戻るボタン押下時
			return String.format("redirect:/admin/contact/%d", id);

		} else if ("delete".equals(action)) {// 削除ボタン押下時
			return String.format("redirect:/admin/contact/%d/delete", id);
		}

		contactService.updateContact(contactForm);

		return String.format("redirect:/admin/contact/%d", id);
	}

	@GetMapping("/contact/{id}/delete")
	public String deleteContact(@PathVariable Long id) {

		contactService.deleteContactById(id);

		return String.format("redirect:/admin/contacts");
	}
}
