package com.dxc.studentmarks.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.studentmarks.model.Marks;
import com.dxc.studentmarks.model.Student;
import com.dxc.studentmarks.model.StudentMarks;

@RestController
@RequestMapping("/studentmarks")
public class StudentMarksResource {
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/{id}")
	public StudentMarks getStudentMarks(@PathVariable("id")int stuid) {
		// Obtain Student data it's webservice: http://localhost:8181/student/{id}
		//Map<Integer,Student>students=new HashMap<>();
		 //students.put(101, new Student(101,"Pooja"));
		//students.put(102, new Student(102,"Honey"));
		
		
		Student student = restTemplate.getForObject("http://STUDENT-SERVICE/student/"+stuid, Student.class);
		// Obtain Student data it's webservice: http://localhost:8282/student/{id}
		//List<Marks>marks=Arrays.asList(
				//new Marks(101,501,65,89),
				//new Marks(101,502,54,97),
				//new Marks(102,501,76,87),
				//new Marks(102,502,88,65)
						
				//);
		Marks[] marks = restTemplate.getForObject("http://MARKS-SERVICE/marks/"+stuid, Marks[].class);
		
	//Bring student data and marks data and combine
		return new StudentMarks(student.getName(),
				Arrays.asList(marks)
				
				
				);
	}
	}