package com.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetomany.dao.Teacherdao;
import com.onetomany.model.Teacher;



@Service
public class TeacherService {
	@Autowired
	private Teacherdao teacherdao;
	
	public void saveteacher(Teacher teacher) {
		teacherdao.saveTeacher(teacher);
	}
	public Teacher getbyId(int id) {
		return teacherdao.getbyid(id);
	}
	public List<Teacher> getAllteachers(){
		return teacherdao.getallteachers();
	}
	public boolean delete(int id) {
		Teacher teacher = teacherdao.getbyid(id);
		if(teacher!=null) {
			teacherdao.delete(teacher);
			return true;
		}
		return false;
	}
	public void edit(Teacher teacher ) {
		teacherdao.edit(teacher);
	}
	/*
	 * public List<Teacher> search(String keyword) { return
	 * teacherdao.search(keyword); }
	 */
	
}
