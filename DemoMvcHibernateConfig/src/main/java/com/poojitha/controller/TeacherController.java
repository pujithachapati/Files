package com.poojitha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.poojitha.model.Teacher;
import com.poojitha.service.teacherservice.TeacherService;

@Controller
@RequestMapping("/")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@GetMapping("/")
	public ModelAndView empForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("teacher", new Teacher());
		mav.setViewName("Teacher_Form");
		return mav;
	}

	@PostMapping("/save")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher,BindingResult result) {

		if (teacher.getTeacher_Id() != 0) {// update
			System.out.println("update teacher :"+teacher.getTeacher_Id());
			service.updateTeacher(teacher);
		} else {
			System.out.println("save teacher :"+teacher.getTeacher_Id());
			service.saveTeacher(teacher); //save
		}
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public String getTeacher(@PathVariable long id, Model model) {
		Teacher teacher = service.findById(id);
		model.addAttribute("teacher", teacher);
		return "Teacher_Form";
	}
	
}