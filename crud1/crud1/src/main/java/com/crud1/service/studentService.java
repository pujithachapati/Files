package com.crud1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud1.dao.studentDao;
import com.crud1.model.Student;

@Service
public class studentService {
	@Autowired
	private studentDao studentdao;
	
	public void savestudent(Student student) {
		studentdao.savestudent(student);
	}
	public Student getbyId(int id) {
		return studentdao.getbyid(id);
	}
	public List<Student> getall(){
		return studentdao.getAllstudents();
	}
	public boolean delete(int id) {
		Student student = studentdao.getbyid(id);
		if(student!=null) {
			studentdao.delete(student);
			return true;
		}
		return false;
	}
	public void edit(Student student) {
		studentdao.edit(student);
	}
	
}
