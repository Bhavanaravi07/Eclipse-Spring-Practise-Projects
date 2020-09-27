package com.dxc.app;

import com.dxc.beans.Address;
import com.dxc.beans.Person;

public class App_02_NODI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address add1=new Address(101,"AB-101","pathuru","Nellore");
		Person person1=new Person();
		person1.setId(101);
		person1.setName("sasi");
		person1.setEmail("sasi@gmail.com");
		person1.setMobile("766398693");
		person1.setAddress(add1);
		System.out.println(person1);
	}

}