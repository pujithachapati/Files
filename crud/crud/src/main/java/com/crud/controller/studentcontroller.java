package com.crud.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.crud.model.Student;
import com.crud.service.studentservice;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class studentcontroller {
	@Autowired
	private studentservice studentservice;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/form")
	public String form() {
		return "Studentform";
	}
	@PostMapping("/save")
	public String savestudent(@ModelAttribute Student student) {
		studentservice.savestudent(student);
		return "redirect:/";
	}
	@RequestMapping("/")
	public String list(Model m) {
		m.addAttribute("students", studentservice.getallstudents());
		return "display";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		studentservice.delete(id);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Student student=studentservice.getByid(id);
		m.addAttribute("student", student);
		System.out.println(student);
		return "Studentform";
	}
	@RequestMapping("/edit/update")
	public String update(@ModelAttribute Student student) {
		studentservice.edit(student);
		return "redirect:/";
	}

	/*
	 * @RequestMapping("/greet") public String greet(Model model) {
	 * System.out.println("method invoked"); String greetingmessage =
	 * messageSource.getMessage("greeting.message", new
	 * Object[]{"John"},"Default Greeting", Locale.getDefault());
	 * model.addAttribute("greetingMessage",greetingmessage); return "greet"; }
	 */
	/*
	 * @RequestMapping("/greet") public String greet(Model model, @RequestParam(name
	 * = "lang", required = false, defaultValue = "en") String lang) { Locale locale
	 * = new Locale(lang); String greetingMessage =
	 * messageSource.getMessage("greeting.message", new Object[]{"John"},
	 * "Default Greeting", locale); System.out.println("Requested Lang: " + lang);
	 * System.out.println("Resolved Locale: " + locale);
	 * System.out.println("Resolved Greeting: " + greetingMessage);
	 * model.addAttribute("greetingMessage", greetingMessage); return "greet"; }
	 */
	@GetMapping("/add")
	public String userform() {
		return "greet";
	}

}