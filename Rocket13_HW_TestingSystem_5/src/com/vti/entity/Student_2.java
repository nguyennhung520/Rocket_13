package com.vti.entity;

import java.util.Scanner;

public class Student_2 extends Person{
	private int studentID;
	private float averageTotal;
	private String email;
	
	@Override
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		super.inputInfo();
		System.out.println("StudentID: ");
		this.studentID = sc.nextInt();
		System.out.println("AverageTotal: ");
		this.averageTotal = sc.nextFloat();
		System.out.println("Email: ");
		this.email = sc.nextLine();
	}
	
	@Override
	public String showInfo() {
		return super.showInfo()+ "Student_2 [studentID=" + studentID + ", averageTotal=" + averageTotal + ", email=" + email + "]";
	}
	public boolean Scholarship() {
		return averageTotal > 8.0 ? true : false;
	}
	
}
