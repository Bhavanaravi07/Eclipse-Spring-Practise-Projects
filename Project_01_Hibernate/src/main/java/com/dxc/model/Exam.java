package com.dxc.model;

public class Exam {
	private int examid;
	private String ename;
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam(int examid, String ename) {
		super();
		this.examid = examid;
		this.ename = ename;
	}
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Exam [examid=" + examid + ", ename=" + ename + "]";
	}
	
	
	

}
