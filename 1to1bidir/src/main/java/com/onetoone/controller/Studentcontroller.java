package com.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onetoone.model.Laptop;
import com.onetoone.model.Student;
import com.onetoone.service.StudentService;



@Controller
public class Studentcontroller {
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	@PostMapping("/save")
	public String savestudent(@ModelAttribute Student student,@ModelAttribute Laptop laptop) {
		student.setLaptop(laptop);
		/*
		 * laptop.setStudent(student);
		 */		studentservice.savestudent(student);
		System.out.println(student);
		return "redirect:/";
	}
	@RequestMapping("/")
	public String list(Model m) {
		m.addAttribute("students", studentservice.getall());
		return "display";
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		studentservice.delete(id);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id,Model m) {
		Student student=studentservice.getbyId(id);
		Laptop laptop=student.getLaptop();
		m.addAttribute("student",student);
		m.addAttribute("laptop",laptop);
		System.out.println(m);
		return "form";
	}
	@PostMapping("/edit/update")
	public String update(@ModelAttribute Student student,@ModelAttribute Laptop laptop) {
		student.setLaptop(laptop);
		studentservice.edit(student);
		return "redirect:/";
	}
}
