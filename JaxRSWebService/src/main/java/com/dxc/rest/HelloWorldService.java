package com.dxc.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dxc.beans.Student;

@Path("/hello")
public class HelloWorldService {
	
	Map<Integer, Student> studMap = new HashMap<Integer, Student>();
	public HelloWorldService() {
		Student s1 = new Student(101,"bhavana", "bhavana@gmail.com", "9781801");
		Student s2 = new Student(102,"devi", "devi@gmail.com", "9782632");
		Student s3 = new Student(103,"ravi", "ravi@gmail.com", "9797322");
		studMap.put(s1.getId(), s1);
		studMap.put(s2.getId(), s2);
		studMap.put(s3.getId(), s3);
		
	}

	@GET
	@Path("/user")
	public String sayHello() {
		String result = "Hello world by user";
		return result;
	}

	@GET
	@Path("/service")
	public String sayHai() {
		String result = "Hello world by service";
		return result;
	}
	
	@GET
	@Path("/students/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent(@PathParam("id") int id) {
		return studMap.get(id);
	}
	
	@GET
	@Path("/students")
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		Set<Integer> ids = studMap.keySet();
		for(int id: ids) {
			students.add(studMap.get(id));
		}
		return students;
		
	}

}