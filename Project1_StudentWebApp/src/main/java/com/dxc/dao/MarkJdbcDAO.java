package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Exam;
import com.dxc.beans.Mark;
import com.dxc.beans.Student;

public class MarkJdbcDAO implements MarkDAO<Mark> {
	
	Connection con=null;
	PreparedStatement p=null;
	ResultSet rs=null;
	
	public MarkJdbcDAO() throws ClassNotFoundException, SQLException {
		super();
		String dri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dxc";
		String un = "root";
		String pw = "root";
		
		Class.forName(dri);
		con=DriverManager.getConnection(url, un, pw);
	}

	@Override
	public boolean save(Mark e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		
		p=con.prepareStatement("insert into marks values(?,?,?,?,?)");
		p.setString(1, e.getExamid());
		p.setInt(2,e.getStudentid());
		p.setInt(3,e.getMark1());
		p.setInt(4,e.getMark2());
		p.setInt(5,e.getMark3());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		return res;
	}

	@Override
	public boolean edit(Mark e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("update marks set mark1=?,mark2=?,mark3=? where examid=? and studentid=?");
		p.setInt(1,e.getMark1());
		p.setInt(2,e.getMark2());
		p.setInt(3,e.getMark3());
		p.setString(4, e.getExamid());
		p.setInt(5, e.getStudentid());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		return res;
	}


	@Override
	public boolean delete(String examid, int studentid) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("delete from marks where examid=? and studentid=?");
		p.setString(1, examid);
		p.setInt(2, studentid);
		if(1==p.executeUpdate())
		{
			res=true;
		}
		return res;
	}

	@Override
	public Mark find(String examid, int studentid) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		Mark mark=null;
		try {
			p=con.prepareStatement("select * from marks where examid=? and studentid=?");
		p.setString(1, examid);
		p.setInt(2,studentid);
		
		rs=p.executeQuery();
		
		if(rs.next())
		{
			int mark1=rs.getInt(3);
			int mark2=rs.getInt(4);
			int mark3=rs.getInt(5);
		
			mark=new Mark(examid, studentid, mark1, mark2, mark3);
		}
		}
		finally
		{
			con.close();
		}
		return mark;
	}


	@Override
	public List<Mark> findAll() throws Exception {
		List<Mark> marks=new ArrayList<>();
		Mark mark=null;
		Statement s= con.createStatement();
		rs=s.executeQuery("select * from marks");
		while(rs.next())
		{
			String examid=rs.getString("examid");
			int studentid=rs.getInt(2);
			int mark1=rs.getInt(3);
			int mark2=rs.getInt(4);
			int mark3=rs.getInt(5);
			mark=new Mark(examid, studentid, mark1, mark2, mark3);
			marks.add(mark);
		}
		return marks;
		}

}
