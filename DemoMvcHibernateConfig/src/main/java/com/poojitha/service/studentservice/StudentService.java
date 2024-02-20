package com.poojitha.service.studentservice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.poojitha.model.Student;


@Transactional
public interface StudentService {
	
	public void saveStudent(Student student);
	
	public Student findById(long id);

	public List<Student> getStudents();
	
	public boolean deleteStudent(long id);
	
	public void updateStudent(Student student);

}
