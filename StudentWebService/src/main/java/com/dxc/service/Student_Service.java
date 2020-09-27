package com.dxc.service;

import java.util.List;

import com.dxc.model.Student;  
 
  
public interface Student_Service {  
  
      
    public boolean saveStudent(Student student);  
    public List<Student> getStudents();  
    public boolean deleteStudent(Student student);  
    public List<Student> getStudentByID(Student student);  
    public boolean updateStudent(Student student);  
}  