package com.dxc.student.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.student.model.Student;
import com.dxc.student.reposirory.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentResource {
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("/{id}")
	public Student getStudent(@PathVariable("id") int studid) {
		//Map<Integer,Student> students = new HashMap<>();
		//Students.put(101,new Student(101,"Hema"));
		//Students.put(102,new Student(102,"Bindu"));
		Student student = (Student)studentRepository.findById(studid).orElse(new Student());
		
		return  student;
		//return students.get(studid);
		
	}

}