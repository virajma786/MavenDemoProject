package com.vignesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo02Main {
			
			public static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
			public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
			public static final String DB_User = "W1_86820_Vignesh";
			public static final String DB_PASS = "manager";
			static {
				try {
					Class.forName(DB_Driver);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
					System.exit(1);
				}
			}
			public static void main(String[] args) {
				
				Scanner sc = new Scanner(System.in);
				try {Connection con = DriverManager.getConnection(DB_URL, DB_User, DB_PASS);
					try(Statement stmt = con.createStatement()){
						
						System.out.println("enetre the student roll number ");
						int rollno = sc.nextInt();
						System.out.println("eneter the student name");
						String name = sc.next();
						System.out.println("eneter the marks of student ");
						Double marks = sc.nextDouble();
						String sql = "insert into students values ("+rollno + ",  '"+ name +"', " + marks +")"; 
								 int count = 	stmt.executeUpdate(sql);
								 System.out.println("number of rows inserted " + count);
						
				}// statment will be closed 	
			}// con will be closed 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
}
