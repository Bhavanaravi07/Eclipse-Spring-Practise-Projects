package com.dxc.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dxc.service.ProductService;
import com.dxc.beans.Product;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
		ProductService productService = application.getBean(ProductService.class);
		
		productService.add(new Product(1, "pen" ,12.12));
		productService.add(new Product(2, "pencil" ,20.2));
		
		System.out.println(productService.findAll());
		application.close();
	}

}