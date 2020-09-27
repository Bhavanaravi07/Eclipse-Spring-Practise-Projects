package com.dxc.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dxc.beans.Student;

public class App_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration().configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				                             .applySettings(configuration.getProperties())
		                               		 .buildServiceRegistry();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		
		/* Obtaining record by primary key */
		//Student student = (Student)session.get(Student.class, 101);
		//System.out.println("data obtained from table : "+student);
		
		/*Obtaining all records - HQL (without any filter)*/
		//Query query = session.createQuery("from student");
		//List<Student> students = query.list();
		//students.forEach(System.out::println);
		
		/*Update an existing record */
		Student student = new Student(101, "Ravi", "ravi@gmail.com", "98879898");
		
		
		
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();

	}

}
