package com.crud1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud1.model.Laptop;
import com.crud1.model.Student;
import com.crud1.service.studentService;

@Controller
public class studentcontroller {
	@Autowired
	private studentService studentservice;
	
	@RequestMapping("/form")
	public String form() {
		return "Studentform";
	}
	@PostMapping("/save")
	public String savestudent(@ModelAttribute Student student,@ModelAttribute Laptop laptop) {
		student.setLaptop(laptop);
		studentservice.savestudent(student);
		System.out.println(student);
		return "redirect:/";
	}
	@RequestMapping("/")
	public String list(Model m) {
		m.addAttribute("students", studentservice.getall());
		return "display";
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		studentservice.delete(id);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Student student=studentservice.getbyId(id);
		Laptop laptop=student.getLaptop();
		m.addAttribute("student",student);
		m.addAttribute("laptop",laptop);
		System.out.println(m);
		return "Studentform";
	}
	@PostMapping("/edit/update")
	public String update(@ModelAttribute Student student,@ModelAttribute Laptop laptop) {
		student.setLaptop(laptop);
		studentservice.edit(student);
		return "redirect:/";
	}
	
}
