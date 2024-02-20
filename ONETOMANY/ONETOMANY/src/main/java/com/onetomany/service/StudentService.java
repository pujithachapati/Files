package com.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onetomany.dao.Studentdao;
import com.onetomany.dao.Teacherdao;
import com.onetomany.model.Student;
import com.onetomany.model.Teacher;

@Repository
public class StudentService {
	@Autowired
	private Studentdao studentdao;
	
	public void savestudent(Student student) {
		studentdao.saveStudent(student);
	}
	public Student getbyId(int id) {
		return studentdao.getbyid(id);
	}
	public List<Student> getAllteachers(){
		return studentdao.getallteachers();
	}
	public boolean delete(int id) {
		Student student = studentdao.getbyid(id);
		if(student!=null) {
			studentdao.delete(student);
			return true;
		}
		return false;
	}
	public void edit(Student student ) {
		studentdao.edit(student);
	}
}
