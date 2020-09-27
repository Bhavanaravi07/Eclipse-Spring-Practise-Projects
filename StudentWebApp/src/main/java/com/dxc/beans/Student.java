package com.dxc.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	int id;
	String name;
	Date Dob;
	String email;
	String mobile;
	

	public Student(int id, String name, String dob, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
	    this.email = email;
		this.mobile = mobile;
		try {
			this.Dob=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDob() {
		return Dob;
	}



	public void setDob(Date dob) {
		Dob = dob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@Override
	public String toString() {
		String strDob=new SimpleDateFormat("dd-MM-yyyy").format(Dob);
		return "Student_01 [id=" + id + ", name=" + name + ", Dob=" + Dob + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
	public String toCSV() {
		String strDob=new SimpleDateFormat("dd-MM-yyyy").format(Dob);
		return id+","+","+name+","+strDob+","+email+","+mobile;
	}
	public static Student parseStudent(String CSVstudent) {
		String[]values=CSVstudent.split(",");
		int id=Integer.parseInt(values[0]);
		String name=values[1];
		String strdob=values[2];
		String email=values[3];
		String mobile=values[4];
		
		return null;
		
	}

}
