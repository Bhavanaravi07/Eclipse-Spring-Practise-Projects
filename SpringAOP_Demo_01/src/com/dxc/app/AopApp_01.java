package com.dxc.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dxc.model.Person;
import com.dxc.service.PersonService;

public class AopApp_01 {
	
	public static void main(String[] args) {
		
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonService personService = ctxt.getBean("personService", PersonService.class);
		
		Person person = personService.getPerson();
		
		System.out.println("id :"+person.getId());
		System.out.println("name :"+person.getName());
		
		person.setName("ravi");
		System.out.println("Person after updating : "+person);
		
	}

}
