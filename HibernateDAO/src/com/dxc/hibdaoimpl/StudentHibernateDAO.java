package com.dxc.hibdaoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dxc.beans.Student;
import com.dxc.dao.StudentDAO;

public class StudentHibernateDAO implements StudentDAO {
	
	
	SessionFactory sessionFactory ;
	Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void openSession(){
		System.out.println("inside departmenthibdao sessionFactory : "+sessionFactory);
		session = getSessionFactory().openSession();
	}

	public void closeSession(){
		session.close();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		String sql = "from students";
		Query query = session.createQuery(sql);
		List<Student> students = query.list();
		return students;
	}

	@Override
	public Student find(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student insert(Student students) {
		// TODO Auto-generated method stub
		System.out.println("Before inserting "+students.getName());
		session.save(students);
		System.out.println("After inserting "+students.getName());
		return students;
	}

	@Override
	public Student udpate(Student student) {
		// TODO Auto-generated method stub
		Student students = new Student();
		
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();
		return student;
	}

	@Override
	public boolean delete(int sid) {
		// TODO Auto-generated method stub
		Student student=(Student) session.get(Student.class, 101);
		if(student !=null) {
			session.delete(student);
			System.out.println("Student deleted");
			session.getTransaction().commit();
		}
		return false;
	}

}