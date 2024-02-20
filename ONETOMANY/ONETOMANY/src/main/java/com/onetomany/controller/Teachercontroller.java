package com.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetomany.model.Student;
import com.onetomany.model.Teacher;
import com.onetomany.service.StudentService;
import com.onetomany.service.TeacherService;

@Controller
public class Teachercontroller {
	@Autowired
	private TeacherService teacherservice;
	
	@RequestMapping("/form")
	public String view() {
		return "form";
	}
	
	@PostMapping("/save")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, BindingResult result) {
		List<Student> students = teacher.getStudents();
		System.out.println(students);
		teacherservice.saveteacher(teacher);
	    System.out.println(teacher);
	    return "redirect:/";
	}
	/*
	 * @PostMapping("/save") public String saveTeacher(@ModelAttribute Teacher
	 * teacher,@ModelAttribute List<Student> students) {
	 * teacher.setStudents(students); teacherservice.saveteacher(teacher);
	 * System.out.println(teacher); return "redirect:/"; }
	 */
	@RequestMapping("/")
	public String getall(Model model) {
		model.addAttribute("teacher", teacherservice.getAllteachers());
		return "display";
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		teacherservice.delete(id);
		System.out.println("delete method called");
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Teacher teacher = teacherservice.getbyId(id);
		m.addAttribute("teacher", teacher);
		return "form";
	}
	@PostMapping("/edit/update")
	public String update(@ModelAttribute Teacher teacher) {
		teacherservice.edit(teacher);
		 return "redirect:/";
	}
	/*
	 * @RequestMapping("/search") public String search(@RequestParam(name="keyword")
	 * String keyword,Model model) { List<Teacher> searchresults =
	 * teacherservice.search(keyword); model.addAttribute(searchresults); return
	 * "searchresults"; }
	 */
	
}
