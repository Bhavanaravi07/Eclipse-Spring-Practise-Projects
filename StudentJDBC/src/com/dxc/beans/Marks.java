package com.dxc.beans;

public class Marks {
	int Studentid;
	int Examid;
	int sub1;
	int sub2;
	int sub3;
	int sub4;
	
	public Marks(int studentid, int examid, int sub1, int sub2, int sub3, int sub4) {
		super();
		this.Studentid = studentid;
		this.Examid = examid;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
	}
	
	public int getStudentid() {
		return Studentid;
	}

	public void setStudentid(int studentid) {
		this.Studentid = studentid;
	}

	public int getExamid() {
		return Examid;
	}

	public void setExamid(int examid) {
		this.Examid = examid;
	}

	public int getSub1() {
		return sub1;
	}

	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}

	public int getSub4() {
		return sub4;
	}

	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}
	

	@Override
	public String toString() {
		return "Marks [Studentid=" + Studentid + ", Examid=" + Examid + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3="
				+ sub3 + ", sub4=" + sub4 + "]";
	}

	public String toCSV() {
		
		return Studentid+","+Examid+","+sub1+","+sub2+","+sub3+","+sub4;
	}
	public static Marks parseStudent(String CSVstudent) {
		String[]values=CSVstudent.split(",");
		int Studentid=Integer.parseInt(values[0]);
		int Examid=Integer.parseInt(values[1]);
		int sem1=Integer.parseInt(values[2]);
		int sem2=Integer.parseInt(values[3]);
		int sem3=Integer.parseInt(values[4]);
		int sem4=Integer.parseInt(values[5]);
		
		return null;
		
	}
	

}
