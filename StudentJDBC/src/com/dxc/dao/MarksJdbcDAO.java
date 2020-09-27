package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Marks;
import com.dxc.ui.ConnectionManager;

public class MarksJdbcDAO extends JdbcDAO implements DAO<Marks> {

	public MarksJdbcDAO() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		super();
		
	}


	@Override
	public boolean save(Marks e) throws SQLException {
		
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Marks VALUES(?,?,?,?,?,?)");
		pstmt.setInt(1, e.getStudentid());
		pstmt.setInt(2, e.getExamid());
		pstmt.setInt(3, e.getSub1());
		pstmt.setInt(4, e.getSub2());
		pstmt.setInt(5, e.getSub3());
		pstmt.setInt(6, e.getSub4());
		
		
		if(1==pstmt.executeUpdate()) {
			res = true;
		}
		return res;
		
	}

	@Override
	public boolean edit(Marks e) throws SQLException {
		// TODO Auto-generated method stub
boolean res = false;
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE Marks SET studentid=?, examid=?, sub1=?, sub2=?, sub3=?, sub4=?");
		pstmt.setInt(1, e.getStudentid());
		pstmt.setInt(2, e.getExamid());
		pstmt.setInt(3, e.getSub1());
		pstmt.setInt(4, e.getSub2());
		pstmt.setInt(5, e.getSub3());
		pstmt.setInt(6, e.getSub4());
		
		if(1 == pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
		
	}

	@Override
	public boolean delete(int Studentid) throws SQLException {
		// TODO Auto-generated method stub
		boolean res = false;
		 PreparedStatement pstmt = con.prepareStatement("DELETE FROM Exam WHERE id = ?");
		 pstmt.setInt(1, Studentid);
		 pstmt.setInt(2, Examid);
		 if(1==pstmt.executeUpdate()) {
			 res = true;
		 }
		 
		return res;
		
	
	}

	@Override
	public Marks find(int Studentid) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		
		Marks marks = null;
		try {
		     Connection con = ConnectionManager.getConnection();
		     con.commit();
		     PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Marks WHERE id = ?");
		     pstmt.setInt(1, Studentid);
		     pstmt.setInt(2, Examid);
		     ResultSet rs = pstmt.executeQuery();
		     if(rs.next()) {
		    	int sub1 = rs.getInt(3);
			    int sub2 = rs.getInt(4);
			    int sub3 = rs.getInt(5);
			    int sub4 = rs.getInt(6);
			
			
			    marks = new Marks(Studentid, Examid, sub1, sub2, sub3, sub4);
	        }
		
		}
		finally {
			con.close();
		}
		
		
		return marks;
		
	}

	@Override
	public List<Marks> findAll() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		
	    ArrayList<Marks> marks = new ArrayList<>();
	    try {
	        Connection con = ConnectionManager.getConnection();
		    con.commit();
		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Marks");
			while(rs.next()) {
				int Studentid = rs.getInt("Studentid");    
			    int Examid = rs.getInt("Examid");
			    int sub1 = rs.getInt("sub1");
				int sub2 = rs.getInt("sub2");
				int sub3 = rs.getInt("sub3");
				int sub4 = rs.getInt("sub4");
			    
			    
			    Marks marks1 = new Marks(Studentid, Examid, sub1, sub2, sub3, sub4);
			}
			
	}
	finally {
		con.close();
	}
		return null;
	}

}
