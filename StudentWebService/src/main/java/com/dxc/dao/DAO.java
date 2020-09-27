package com.dxc.dao;
import java.util.List;

import com.dxc.model.Student;
public interface DAO<E> {  
	  
    public boolean save(E e);  
    public List<E> get();  
    public boolean delete(E e);  
    public List<E> getByID(E e);  
    public boolean update(E e);  
} 
      
  