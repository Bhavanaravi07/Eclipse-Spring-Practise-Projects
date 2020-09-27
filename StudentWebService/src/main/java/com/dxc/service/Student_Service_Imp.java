package com.dxc.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.DAO;
import com.dxc.dao.Student_DAO_Imp;
import com.dxc.model.Student;


  
  
@Service  
@Transactional  
public class Student_Service_Imp implements Student_Service {  
   
    @Autowired  
    private Student_DAO_Imp studentdao;  
      
    @Override  
    public boolean saveStudent(Student student) {  
        return studentdao.save(student);  
    }  
  
    @Override  
    public List<Student> getStudents() {  
        return studentdao.get();  
    }  
  
    @Override  
    public boolean deleteStudent(Student student) {  
        return studentdao.delete(student);  
    }  
  
    @Override  
    public List<Student> getStudentByID(Student student) {  
        return studentdao.getByID(student);  
    }  
  
    @Override  
    public boolean updateStudent(Student student) {  
        return studentdao.update(student);  
    }  
  
}  