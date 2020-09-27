package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.beans.Product;
import com.dxc.repository.ProductRepository;

@Component
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Transactional
	public void add(Product product) {
		productRepository.save(product);
	}
	
	@Transactional(readOnly=true)
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	@Transactional(readOnly= true)
	public Product find(int id) {
		return productRepository.findOne(id);
	}

}
