package com.dxc.service;

import java.util.List;

import com.dxc.model.Student;

public interface StudentService {
	public void add(Student s);
	public void update(Student s);
	public void delete(int id);
	public Student getStudentById(int id);
	public List<Student> listStudents();
	

}
