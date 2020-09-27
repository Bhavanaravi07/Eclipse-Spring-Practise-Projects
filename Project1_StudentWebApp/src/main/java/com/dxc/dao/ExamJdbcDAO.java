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


public class ExamJdbcDAO implements ExamDAO<Exam> {
	
	Connection con=null;
	PreparedStatement p=null;
	ResultSet rs=null;
	
	public ExamJdbcDAO() throws ClassNotFoundException, SQLException {
		super();
		String dri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dxc";
		String un = "root";
		String pw = "root";
		
		Class.forName(dri);
		con=DriverManager.getConnection(url, un, pw);
	}

	@Override
	public boolean save(Exam e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		
		p=con.prepareStatement("insert into exam values(?,?)");
		p.setString(1, e.getEid());
		p.setString(2,e.getEname());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		return res;
	}

	@Override
	public boolean edit(Exam e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("update exam set ename=? where eid=?");
		p.setString(1, e.getEname());
		p.setString(2, e.getEid());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		return res;
	}

	@Override
	public boolean delete(String id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		boolean res=false;
		p=con.prepareStatement("delete from exam where eid=?");
		p.setString(1,id);
		if(1==p.executeUpdate())
		{
			res=true;
		}
		return res;
	}

	@Override
	public Exam find(String id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		p=con.prepareStatement("select * from exam where eid=?");
		p.setString(1, id);
		Exam exam=null;
		rs=p.executeQuery();
		if(rs.next())
		{
			String name=rs.getString("name");
			exam=new Exam(id, name);
		}
		return exam;
	}

	@Override
	public List<Exam> findAll() throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		List<Exam> exams=new ArrayList<>();
		Exam exam=null;
		Statement s= con.createStatement();
		rs=s.executeQuery("select * from exam");
		while(rs.next())
		{
			String eid=rs.getString("eid");
			String ename=rs.getString("ename");
			exam=new Exam(eid, ename);
			exams.add(exam);
		}
		return exams;
	}

}
