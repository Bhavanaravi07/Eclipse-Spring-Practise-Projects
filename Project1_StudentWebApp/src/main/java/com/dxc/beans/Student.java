package com.dxc.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>,Serializable {
	int id;
	String name;
	Date dob;
	String email;
	String mobile;
	
		public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

		public Student(int id, String name, String strdob, String email, String mobile) throws ParseException {
			super();
			this.id = id;
			this.name = name;
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			dob=sdf.parse(strdob);
			this.email = email;
			this.mobile = mobile;
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
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
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
			String strdob=new SimpleDateFormat("dd-MM-yyyy").format(dob);
			return "Student [id=" + id + ", name=" + name + ", dob=" + strdob + ", email=" + email + ", mobile=" + mobile
					+ "]";
		}

		public String tocsv()
		{
		String strdob=new SimpleDateFormat("dd-MM-yyyy").format(dob);
		return ""+id+" , "+name+" , "+strdob+" , "+email+" , "+mobile+"";
		}
		public static Student paraStudent(String csvStudent) throws ParseException
		{
			String[] values=csvStudent.split(",");
			int id=Integer.parseInt(values[0]);
			String name=values[1];
			String strdob=values[2];
			String email=values[3];
			String mobile=values[4];
			Student student=new Student(id, name, strdob, email, mobile);
			return student;
			
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.id-o.id;
		}
}
