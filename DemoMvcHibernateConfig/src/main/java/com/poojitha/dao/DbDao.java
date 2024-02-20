package com.poojitha.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poojitha.model.Student;
import com.poojitha.model.Teacher;

@Repository
public class DbDao {

	@Autowired
	SessionFactory factory;

	public void save(Student student) {

		Session session = factory.getCurrentSession();
		session.persist(student);
	}

	public void save(Teacher teacher) {

		Session session = factory.getCurrentSession();
		session.persist(teacher);
	}

	public Student getStudentById(long id) {

		Session session = factory.getCurrentSession();
		return session.get(Student.class, id);
	}

	public Teacher getTeacherById(long id) {

		Session session = factory.getCurrentSession();
		return session.get(Teacher.class, id);
	}

	public List<Student> getAllTeachers() {
		Session session = factory.getCurrentSession();
		return session.createQuery("FROM Teacher",Teacher.class).list();
	}

	public void updateTeacher(Teacher teacher) {
		
		Session session = factory.getCurrentSession();
		session.merge(teacher);
	}
	
	public void updateStudent(Student student) {
		
		Session session = factory.getCurrentSession();
		session.merge(student);
	}
	
	public void deleteTeacher(Teacher teacher) {
		
		Session session = factory.getCurrentSession();
		session.remove(teacher);	
	}
	
	public void deleteStudent(Student student) {
		
		Session session = factory.getCurrentSession();
		session.remove(student);
	}
}
