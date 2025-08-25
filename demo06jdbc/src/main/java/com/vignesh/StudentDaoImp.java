package com.vignesh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImp implements StudentDao, AutoCloseable{
		private Connection con;
		public  StudentDaoImp() throws Exception{
			con = DBUtil.getConnection();
			
		}
	@Override
	public Student findById(int rollno) throws Exception {
		String sql = "select * from students where rollno = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rollno);
			ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				int rollno1 = rs.getInt("rollno");
				String name = rs.getString("name");
				double marks = rs.getDouble("marks");
				Student s = new Student(rollno1, name, marks);
				return s;
				
			}
		}
		return null; 
	} 

	@Override
	public List<Student> findAll()  throws Exception{
		List<Student> list = new ArrayList<>();
		String sql = "select * from students";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		        int rollno = rs.getInt("rollno");
		        String name = rs.getString("name");
		        double marks = rs.getDouble("marks");
		        Student s = new Student(rollno, name, marks);
		        list.add(s);
		    }
		}	
		return list;

	}

	@Override
	public int save(Student s) throws Exception{
			String sql = "insert into students values(?,?,?)";
			
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, s.getRollno());
				stmt.setString(2, s.getName());
				stmt.setDouble(3, s.getMarks());
				int count = stmt.executeUpdate();
				return count;
				
	}
	@Override
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
