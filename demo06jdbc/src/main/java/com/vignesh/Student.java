package com.vignesh;

public class Student {
		 
	private int rollno;
	private String name ;
	private Double marks;
	public Student(int rollno, String name, Double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
	
	 public Student() {
		 
	 }

	 public int getRollno() {
		 return rollno;
	 }

	 public void setRollno(int rollno) {
		 this.rollno = rollno;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public Double getMarks() {
		 return marks;
	 }

	 public void setMarks(Double marks) {
		 this.marks = marks;
	 }

	 @Override
	 public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	 }
	 
	 
	
	
	
}
