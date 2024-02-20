package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.studentdao;
import com.crud.model.Student;

@Service
public class studentservice {
	@Autowired
	private studentdao stduentdao;
	
	public void savestudent(Student student) {
		stduentdao.savestudent(student);
	}
	public Student getByid(int id) {
		return stduentdao.getbyid(id);
	}
	public List<Student> getallstudents(){
		return stduentdao.getAllstudents();
	}
	public boolean delete(int id) {
		Student student = stduentdao.getbyid(id);
		if(student!=null) {
			stduentdao.delete(student);
			return true;
		}
		return false;
	}
	public void edit(Student student) {
		stduentdao.edit(student);
	}
	
}
