package com.poojitha.service.studentservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poojitha.dao.DbDao;
import com.poojitha.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private final DbDao dbDao;

    @Autowired
    public StudentServiceImpl(DbDao dbDao) {
        this.dbDao = dbDao;
    }

    @Override
    public void saveStudent(Student student) {
    	dbDao.save(student);
    }

	@Override
	public Student findById(long id) {
		
		return dbDao.getStudentById(id);
	}
	
	@Override
	public List<Student> getStudents() {
		
		return dbDao.getAllStudents();
	}

	@Override
	public boolean deleteStudent(long id) {
		Student student = findById(id);
		if(student!=null) {
		dbDao.deleteStudent(student);
		return true;
		}else
		return false;
	}

	@Override
	public void updateStudent(Student student) {
		
		dbDao.updateStudent(student);
	} 
}