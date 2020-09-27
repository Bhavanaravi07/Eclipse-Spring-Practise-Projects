package com.dxc.dao;

import java.util.List;

import com.dxc.beans.Student;

public interface StudentDAO {

		List<Student> findAll();
		Student find(int sid);
		Student insert(Student students);
		Student udpate(Student student);
		boolean delete(int sid);
}