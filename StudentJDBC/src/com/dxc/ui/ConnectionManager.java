package com.dxc.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	protected ConnectionManager() { }
	
	public static Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		Properties properties = new Properties();
		properties.load(new FileInputStream("db.prop"));
		
		String dri = properties.getProperty("dri");
		String url = properties.getProperty("url");
		String un = properties.getProperty("un");
		String pw = properties.getProperty("pw");
		
		Class.forName(dri);
		con = DriverManager.getConnection(url, un, pw);
		return con;
	}

}