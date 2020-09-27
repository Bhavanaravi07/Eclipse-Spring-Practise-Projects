package com.dxc.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dxc.beans.Person;

public class App_02DI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctxt=new ClassPathXmlApplicationContext("spring.xml");
		Person person=(Person)ctxt.getBean("person");
		System.out.println(person);
	}

}