package com.dxc.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.dxc.beans.Student;
import com.dxc.dao.StudentJdbcDAO;




	public class StudentConsoleUI {

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
					StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
					
					System.out.println("Enter id : ");
					int id = input.nextInt();
					
					System.out.println("Enter name : ");
					String name = input.next();

					System.out.println("Enter Dob (dd-MM-yyyy) : ");
					String strDob = input.next();
					
					System.out.println("Enter email : ");
					String email = input.next();
					
					System.out.println("Enter mobile : ");
					String mobile = input.next();
					
					Student student = new Student(id, strDob,name, email, mobile);
					
					try {
						if(studentJdbcDAO.save(student)) {
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
					System.out.println("Enter student id to find : ");
					int findId = input.nextInt();
					try {
						StudentJdbcDAO studentJdbcDAO2 = new StudentJdbcDAO();
						Student s = studentJdbcDAO2.find(findId);
						
						if(s != null) {
							System.out.println("Student Found : ");
							System.out.println(s);
						}
						else {
							System.out.println("Student not found with id : "+findId);
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
						StudentJdbcDAO studentJdbcDAO2 = new StudentJdbcDAO();
						Student s = studentJdbcDAO2.find(findAllId);
						
						if(s != null) {
							System.out.println("Student Found : ");
							System.out.println(s);
						}
						else {
							System.out.println("Student not found with id : "+findAllId);
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