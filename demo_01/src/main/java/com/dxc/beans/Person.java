package com.dxc.beans;

import org.springframework.stereotype.Component;

@Component
public class Person {
	int id;
	String name;
	String tech;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String tech) {
		super();
		this.id = id;
		this.name = name;
		this.tech = tech;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}
	
	public void show() {
		System.out.println("Inside of show() of person");
	}

}
