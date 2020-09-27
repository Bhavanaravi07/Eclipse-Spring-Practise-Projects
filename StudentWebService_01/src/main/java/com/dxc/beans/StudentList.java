package com.dxc.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
public class StudentList {
	
	List<Student> students ;

	public StudentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentList(List<Student> students) {
		super();
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	@XmlElement(name = "student")
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	

}