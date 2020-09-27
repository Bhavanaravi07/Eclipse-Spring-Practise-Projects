package com.dxc.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dxc.beans.Student;

public class App_01 {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure(); 
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
		                                         .applySettings(configuration.getProperties())
		                                         .buildServiceRegistry();
		
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student s1 = new Student(101, "bhavana", "bhav@gmail.com", "949457992");
		
		session.save(s1);
		transaction.commit();
		System.out.println("Successfully save in DB");
		
		session.close();
		sessionFactory.close();
		
	}

}
