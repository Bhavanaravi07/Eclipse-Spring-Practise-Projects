package com.dxc.beans;

public class Exam {
	int id;
	String name;
	int sem1;
	int sem2;
	int sem3;
	int sem4;
	public Exam(int id, String name, int sem1, int sem2, int sem3, int sem4) {
		super();
		this.id = id;
		this.name = name;
		this.sem1 = sem1;
		this.sem2 = sem2;
		this.sem3 = sem3;
		this.sem4 = sem4;
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
	public int getSem1() {
		return sem1;
	}
	public void setSem1(int sem1) {
		this.sem1 = sem1;
	}
	public int getSem2() {
		return sem2;
	}
	public void setSem2(int sem2) {
		this.sem2 = sem2;
	}
	public int getSem3() {
		return sem3;
	}
	public void setSem3(int sem3) {
		this.sem3 = sem3;
	}
	public int getSem4() {
		return sem4;
	}
	public void setSem4(int sem4) {
		this.sem4 = sem4;
	}
	@Override
	public String toString() {
		return "Marks [id=" + id + ", name=" + name + ", sem1=" + sem1 + ", sem2=" + sem2 + ", sem3=" + sem3 + ", sem4="
				+ sem4 + "]";
	}
	public String toCSV() {
		
		return id+","+name+","+sem1+","+sem2+","+sem3+","+sem4;
	}
	public static Exam parseStudent(String CSVstudent) {
		String[]values=CSVstudent.split(",");
		int id=Integer.parseInt(values[0]);
		String name=values[1];
		int sem1=Integer.parseInt(values[2]);
		int sem2=Integer.parseInt(values[3]);
		int sem3=Integer.parseInt(values[4]);
		int sem4=Integer.parseInt(values[5]);
		
		return null;
		
	}
	

}
