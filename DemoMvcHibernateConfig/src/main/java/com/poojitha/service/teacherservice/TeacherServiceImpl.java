package com.poojitha.service.teacherservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poojitha.dao.DbDao;
import com.poojitha.model.Student;
import com.poojitha.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private final DbDao dbDao;

    @Autowired
    public TeacherServiceImpl(DbDao dbDao) {
        this.dbDao = dbDao;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
    	dbDao.save(teacher);
    }

	@Override
	public Teacher findById(long id) {
		
		return dbDao.getTeacherById(id);
	}
	
	@Override
	public List<Teacher> getAllTeachers() {
		
		return dbDao.getAllTeachers();
	}

	@Override
	public boolean deleteTeacher(long id) {
		
		Teacher teacher = findById(id);
		if(teacher!=null) {
			dbDao.deleteTeacher(teacher);
			return true;
		}
		return false;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		
		dbDao.updateTeacher(teacher);
	} 
}