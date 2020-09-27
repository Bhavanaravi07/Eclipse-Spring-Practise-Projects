package com.dxc.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.dxc.beans.Marks;
import com.dxc.dao.MarksJdbcDAO;

public class MarksConsoleUI {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 5) {
			System.out.println("1. Save Student");
			System.out.println("2. Edit Existing student");
			System.out.println("3. Delete Student");
			System.out.println("4. Display Student");
			System.out.println("5. Display All Student");
			System.out.println("\n6. Exit");
			System.out.println();
			System.out.print("Enter your option : ");
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Save operation");
				MarksJdbcDAO MarksJdbcDAO = new MarksJdbcDAO();
				
				System.out.println("Enter Studentid : ");
				int Studentid = input.nextInt();
				
				System.out.println("Enter Examid : ");
				int Examid = input.nextInt();

				System.out.println("Enter sub1: ");
				int sub1 = input.nextInt();
				
				System.out.println("Enter sub2 : ");
				int sub2 = input.nextInt();
				
				System.out.println("Enter sub3 : ");
				int sub3 = input.nextInt();
				
				System.out.println("Enter sub4: ");
				int sub4 = input.nextInt();
				
				Marks marks = new Marks(Studentid, Examid, sub1, sub2, sub3, sub4);
				
				try {
					if(MarksJdbcDAO.save(marks)) {
						System.out.println("Saved Successfully");
					}	
					else {
						System.out.println("Failed during save");
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				
				break;
				
			case 2:
				System.out.println("Edit operation");
				break;
			
			case 3:
				System.out.println("Delete operation");
				break;
			
			case 4:
				System.out.println("Display operation");
				System.out.println("Enter exam id to find : ");
				int findId = input.nextInt();
				try {
					MarksJdbcDAO marksJdbcDAO2 = new MarksJdbcDAO();
					Marks m = marksJdbcDAO2.find(findId);
					
					if(m != null) {
						System.out.println("Marks Found : ");
						System.out.println(m);
					}
					else {
						System.out.println("Marks not found with id : "+findId);
					}
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 5:
				System.out.println("Display All operation");
				System.out.println("Enter student id to find all : ");
				int findAllId = input.nextInt();
				try {
					MarksJdbcDAO marksJdbcDAO2 = new MarksJdbcDAO();
					Marks m = marksJdbcDAO2.find(findAllId);
					
					if(m != null) {
						System.out.println("Marks Found : ");
						System.out.println(m);
					}
					else {
						System.out.println("Marks not found with id : "+findAllId);
					}
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 6:
				System.exit(0);

			default:
				System.out.println("Invalid user option");
				break;
			}
			
		}
		
		

	}

}
