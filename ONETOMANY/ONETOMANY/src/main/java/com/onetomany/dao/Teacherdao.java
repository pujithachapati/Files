package com.onetomany.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onetomany.model.Teacher;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;



@Repository

public class Teacherdao {
	@Autowired
	private SessionFactory sessionfactory;
	public void saveTeacher(Teacher teacher) {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(teacher);
		transaction.commit();
	}
	public Teacher getbyid(int id) {
		Session session =sessionfactory.openSession();
		return session.get(Teacher.class, id);
	}
	public List<Teacher> getallteachers() {
		Session session = sessionfactory.openSession();
		return session.createQuery("FROM Teacher",Teacher.class).list();
	}
	public void delete(Teacher teacher) {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.remove(teacher);
		transaction.commit();
	}
	public void edit(Teacher teacher) {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(teacher);
		transaction.commit();
	}
	/*
	 * public List<Teacher> search(String keyword){ Session session =
	 * sessionfactory.openSession(); CriteriaBuilder builder =
	 * session.getCriteriaBuilder(); CriteriaQuery<Teacher> query =
	 * builder.createQuery(Teacher.class); Root<Teacher> root =
	 * query.from(Teacher.class); Predicate likecondition =
	 * builder.like(root.get("tname"),"%" +keyword.toLowerCase()+"%");
	 * query.select(root).where(likecondition); Query q =
	 * session.createQuery(query); return q.getResultList();
	 * 
	 * 
	 * }
	 */
}
