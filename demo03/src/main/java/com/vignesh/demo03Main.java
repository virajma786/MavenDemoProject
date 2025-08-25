package com.vignesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class demo03Main {

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
			String sql = "select * from students where marks > ?"; // parameterised query 
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				System.out.println("eneter minium marks to see ");
				Double minmark = sc.nextDouble();
				pstmt.setDouble(1, minmark);
				try(ResultSet rs  = pstmt.executeQuery()){
					while(rs.next()) {
					int rollno = rs.getInt("rollno");
					String name = rs.getString("name");
					Double marks = rs.getDouble("marks");
					System.out.println(rollno +", " + name +", " + marks   );
					}
				}
			}
			
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}