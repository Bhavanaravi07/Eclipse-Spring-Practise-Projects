package com.dxc.studentmarks.model;

import java.util.List;

public class StudentMarks {
	private String name;
	private List<Marks>marks;
	public StudentMarks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentMarks(String name, List<Marks> marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "StudentMarks [name=" + name + ", marks=" + marks + "]";
	}
	

}