package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dxc.beans.User;
import com.dxc.util.ConnectionManager;

public class UserJdbcDAO extends JdbcDAO implements DAO<User> {

	public UserJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(User e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(User e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean validate(String username, String password) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Connection con = ConnectionManager.getConnection();
		con.commit();
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return true;
		
	}

}
