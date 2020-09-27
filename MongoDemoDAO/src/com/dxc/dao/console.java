package com.dxc.dao;

import java.sql.SQLException;
import java.util.Scanner;

import org.bson.Document;



public class console {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 3) {
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. find");
			System.out.println("\n4. Exit");
			System.out.println();
			System.out.print("Enter your option : ");
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Insert operation");
				Document document = new Document();
				
				break;
				
			case 2:
				System.out.println("Delete operation");
				break;
			
			case 3:
				System.out.println("Find operation");
				System.out.println("Enter student id to find : ");
				int findId = input.nextInt();
					EmployeeDAO e = new EmployeeDAO();
					
					if(e != null) {
						System.out.println("Employee Found : ");
						System.out.println(e);
					}
					else {
						System.out.println("Employee not found with id : "+findId);
					}
				break;
	}
		

}
	}
}
	
