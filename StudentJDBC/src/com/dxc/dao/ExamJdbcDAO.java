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

import com.dxc.beans.Exam;
import com.dxc.ui.ConnectionManager;

public class ExamJdbcDAO extends JdbcDAO implements DAO<Exam> {
    
	
	public ExamJdbcDAO() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		super();
		
		
	}

	@Override
	public boolean save(Exam e) throws SQLException {
	
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Exam VALUES(?,?,?,?,?,?)");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getSem1());
		pstmt.setInt(4, e.getSem2());
		pstmt.setInt(5, e.getSem3());
		pstmt.setInt(6, e.getSem4());
		
		
		if(1==pstmt.executeUpdate()) {
			res = true;
		}
		return res;
		
	}

	@Override
	public boolean edit(Exam e) throws SQLException {
		
        boolean res = false;
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE Exam SET name=?, sem1=?, sem2=?, sem3=?, sem4=?, id=?");
		pstmt.setString(1, e.getName());
		pstmt.setInt(2, e.getSem1());
		pstmt.setInt(3, e.getSem2());
		pstmt.setInt(4, e.getSem3());
		pstmt.setInt(5, e.getSem4());
		pstmt.setInt(6, e.getId());
		
		if(1 == pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
		
	}

	@Override
	public boolean delete(int id) throws SQLException {
		
		boolean res = false;
		 PreparedStatement pstmt = con.prepareStatement("DELETE FROM Exam WHERE id = ?");
		 pstmt.setInt(1, id);
		 if(1==pstmt.executeUpdate()) {
			 res = true;
		 }
		 
		 
		return res;
		
	}

	@Override
	public Exam find(int id) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
	
		Exam exam = null;
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
	
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Exam WHERE id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String name = rs.getString(2);
			int sem1 = rs.getInt(3);
			int sem2 = rs.getInt(4);
			int sem3 = rs.getInt(5);
			int sem4 = rs.getInt(6);
			
			
			exam = new Exam(id, name, sem1, sem2, sem3, sem4);
	      }
		}  
		finally {
			con.close();
		}
		
		return exam;
	
	}

	@Override
	public List<Exam> findAll() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		
    ArrayList<Exam> exam = new ArrayList<>();
    try {
    	Connection con = ConnectionManager.getConnection();
    	con.commit();
    	
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM exam");
		while(rs.next()) {
			int id = rs.getInt("id");    
		    String name = rs.getString("name");
		    int sem1 = rs.getInt("sem1");
			int sem2 = rs.getInt("sem2");
			int sem3 = rs.getInt("sem3");
			int sem4 = rs.getInt("sem4");
		    
		    
		    Exam exams = new Exam(id, name, sem1, sem2, sem3, sem4);
		}
		
    }
    finally {
    	con.close();
    }
		
		return null;
	}

}
