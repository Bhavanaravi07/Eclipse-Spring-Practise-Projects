package com.dxc.dao;

import java.util.List;

public interface DAO<E> {
	public void add(E e);
	public void update(E e);
	public void delete(int id);
	public E find(int id);
	public List<E> findAll();	
	
}
