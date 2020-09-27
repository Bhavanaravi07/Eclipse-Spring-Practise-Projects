package com.dxc.model;

public class Student {
	private int studentid;
	private String name;
	private String email;
	private String mobile;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentid, String name, String email, String mobile) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "Student [studentid=" + studentid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
}
