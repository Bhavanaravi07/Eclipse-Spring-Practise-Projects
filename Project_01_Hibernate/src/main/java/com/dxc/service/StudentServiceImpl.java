package com.dxc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.DAO;
import com.dxc.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private DAO dao;

	public void setDAO(DAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void add(Student s) {
		// TODO Auto-generated method stub
		this.dao.add(s);
		
	}

	@Override
	@Transactional
	public void update(Student s) {
		// TODO Auto-generated method stub
		this.dao.update(s);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.dao.delete(id);
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return (Student) this.dao.find(id);
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		return this.dao.findAll();
	}

}
