package com.vignesh;

import java.util.List;

public class jdbcdemo6Main {

	public static void main(String[] args) {
		
			try (StudentDao dao = new StudentDaoImp()){
				
				Student s = new Student(76,"vigneshkiwade", 44.00);			
				int cnt = dao.save(s);
				System.out.println("number of students inserted :" + cnt);
			}// dao close  
			catch (Exception e) {
				
			}
			
			
try (StudentDao dao = new StudentDaoImp()){
				
				List<Student> list = dao.findAll();
				for(Student S: list) 
					System.out.println(S);				
			}// dao close  
			catch (Exception e) {
				
			}
			
		
	}

}
