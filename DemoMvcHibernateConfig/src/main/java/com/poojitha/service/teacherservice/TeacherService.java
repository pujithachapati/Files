package com.poojitha.service.teacherservice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.poojitha.model.Student;
import com.poojitha.model.Teacher;


@Transactional
public interface TeacherService {
	
	public void saveTeacher(Teacher teacher);
	
	public Teacher findById(long id);

	public List<Teacher> getAllTeachers();
	
	public boolean deleteTeacher(long id);
	
	public void updateTeacher(Teacher teacher);

}
