package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dxc.model.Student;



public class StudentDaoImpl  implements DAO<Student>  {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void add(Student students) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(students);
		logger.info("Student saved successfully, Student Details="+students);
		
		
	}

	@Override
	public void update(Student students) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(students);
		logger.info("Student updated successfully, Student Details="+students);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Student students = (Student) session.load(Student.class, new Integer(id));
		if(null != students){
			session.delete(students);
		}
		logger.info("Student deleted successfully, student details="+students);
		
	}

	@Override
	public Student find(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Student students = (Student) session.load(Student.class, new Integer(id));
		logger.info("Student loaded successfully, Student details="+students);
		return students;
		
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList = session.createQuery("from Student").list();
		for(Student students : studentList){
			logger.info("Student List::"+students);
		}
		return studentList;
	}

	
	

	
}	
