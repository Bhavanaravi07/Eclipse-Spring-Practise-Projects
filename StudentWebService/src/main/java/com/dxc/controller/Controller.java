package com.dxc.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dxc.model.Student;
import com.dxc.service.Student_Service;  
  
 
  
@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/students")  
public class Controller {  
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/students").allowedOrigins("http://localhost:4200");
			}
		};
	}
      
    @Autowired  
    private Student_Service studentservice;  
      
    @PostMapping("save-student")  
    public boolean save(@RequestBody Student student) {  
         return studentservice.saveStudent(student);  
          
    }  
      
    @GetMapping("students-list")  
    public List<Student> allstudents() {  
         return studentservice.getStudents();  
          
    }  
      
    @DeleteMapping("delete-student/{id}")  
    public boolean delete(@PathVariable("id") int id,Student student) {  
        student.setId(id);  
        return studentservice.deleteStudent(student);  
    }  
  
    @GetMapping("student/{id}")  
    public List<Student> allByID(@PathVariable("id") int id,Student student) {  
         student.setId(id);  
         return studentservice.getStudentByID(student);  
          
    }  
      
    @PostMapping("update-student/{id}")  
    public boolean update(@RequestBody Student student,@PathVariable("id") int id) {  
    	student.setId(id);  
        return studentservice.updateStudent(student);  
    }  
}  