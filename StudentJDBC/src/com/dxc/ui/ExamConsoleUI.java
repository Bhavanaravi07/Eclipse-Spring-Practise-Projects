package com.dxc.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.dxc.beans.Exam;
import com.dxc.dao.ExamJdbcDAO;


public class ExamConsoleUI {
	
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
				ExamJdbcDAO ExamJdbcDAO = new ExamJdbcDAO();
				
				System.out.println("Enter id : ");
				int id = input.nextInt();
				
				System.out.println("Enter name : ");
				String name = input.next();

				System.out.println("Enter sem1: ");
				int sem1 = input.nextInt();
				
				System.out.println("Enter sem2 : ");
				int sem2 = input.nextInt();
				
				System.out.println("Enter sem3 : ");
				int sem3 = input.nextInt();
				
				System.out.println("Enter sem4: ");
				int sem4 = input.nextInt();
				
				Exam exam = new Exam(id, name, sem1, sem2, sem3, sem4);
				
				try {
					if(ExamJdbcDAO.save(exam)) {
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
					ExamJdbcDAO examJdbcDAO2 = new ExamJdbcDAO();
					Exam e = examJdbcDAO2.find(findId);
					
					if(e != null) {
						System.out.println("Exam Found : ");
						System.out.println(e);
					}
					else {
						System.out.println("Exam not found with id : "+findId);
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
					ExamJdbcDAO examJdbcDAO2 = new ExamJdbcDAO();
					Exam e = examJdbcDAO2.find(findAllId);
					
					if(e != null) {
						System.out.println("Exam Found : ");
						System.out.println(e);
					}
					else {
						System.out.println("Exam not found with id : "+findAllId);
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
