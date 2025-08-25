package com.vignesh;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class demo04Main {
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
		String sql = " call sp_getStudent(?) ";
				try(CallableStatement stmt =  con.prepareCall(sql)){
					System.out.println("enter minimum marks ");
					int minmarks = sc.nextInt();
					stmt.setDouble(1, minmarks);
				    ResultSet rs = 	stmt.executeQuery();
				    while(rs.next()) {
						int rollno = rs.getInt("rollno");
						String name = rs.getString("name");
						Double marks = rs.getDouble("marks");
						System.out.println(rollno +", " + name +", " + marks   );
						}
				}
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
}
}
