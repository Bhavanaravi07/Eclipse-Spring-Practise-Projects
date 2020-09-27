package com.dxc.dao;
import java.util.List;  
   
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;

import com.dxc.model.Student;  
  
@Repository  
public class Student_DAO_Imp  implements DAO<Student>{  
  
    @Autowired  
    private SessionFactory sessionFactory;  
      
    @Override  
    public boolean save(Student student) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().save(student);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
  
    @Override  
    public List<Student> get() {  
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<Student> query=currentSession.createQuery("from Student", Student.class);  
        List<Student> list=query.getResultList();  
        return list;  
    }  
  
    @Override  
    public boolean delete(Student student) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().delete(student);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
  
    @Override  
    public List<Student> getByID(Student student) {  
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<Student> query=currentSession.createQuery("from Student where id=:id", Student.class);  
        query.setParameter("id", student.getId());  
        List<Student> list=query.getResultList();  
        return list;  
    }  
  
    @Override  
    public boolean update(Student student) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().update(student);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
      
}