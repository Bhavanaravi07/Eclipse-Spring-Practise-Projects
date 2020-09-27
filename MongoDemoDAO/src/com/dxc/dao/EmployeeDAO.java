package com.dxc.dao;

import java.util.Scanner;

import org.bson.Document;

public class EmployeeDAO extends JdbcDAO implements DAO {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char rep;
		do {
			Document document = new Document();
			
			do {
				System.out.println("Enter field name: ");
				String key = scanner.next();
				System.out.println("Enter value to " + key + " : ");
				String value = scanner.next();
				document.append(key, value);
				System.out.println();
				System.out.println("Do u have any more fields? ");
				rep = scanner.next().charAt(0);
			}
			
			while(rep != 'n');
			
			mongoCollection.insertOne(document);
			System.out.println("Do u have any more documents? ");
			rep = scanner.next().charAt(0);
		}
		while(rep!='n');
		
		System.out.println("End of the program");
		mongoClient.close();
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		mongoCollection.deleteOne(new Document("id","102"));
		
	}

	@Override
	public void find(int id) {
		// TODO Auto-generated method stub
		mongoCollection.find(new Document("id","103"));
		
	}

	
}

	
	


