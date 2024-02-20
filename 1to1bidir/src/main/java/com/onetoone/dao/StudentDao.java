package com.onetoone.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onetoone.model.Student;

@Repository
public class StudentDao {
	@Autowired
	private SessionFactory sessionfactory;
	public void savestudent(Student student) {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(student);
		transaction.commit();
	}
	public Student getbyid(int id) {
		Session session = sessionfactory.openSession();
		return session.get(Student.class, id);
	}
	public List<Student> getAllstudents(){
		Session session = sessionfactory.openSession();
		return session.createQuery("FROM Student",Student.class).list();
	}
	public void delete(Student student) {
		Session session = sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.remove(student);
		transaction.commit();
	}
	public void edit(Student student) {
		Session session=sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(student);
		transaction.commit();
	}
}
