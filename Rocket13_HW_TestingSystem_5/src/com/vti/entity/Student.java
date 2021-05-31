package com.vti.entity;

public class Student{
	private int studentID;
	private String name;
	private String address;
	private int	prioritize;
	private static int COUNT = 0;
	private String blockName;
	
	public Student(String name, String address, int prioritize, String blockName) {
		super();
		COUNT++;
		this.studentID = COUNT;
		this.name = name;
		this.address = address;
		this.prioritize = prioritize;
		this.blockName = blockName;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", address=" + address + ", prioritize="
				+ prioritize + ", blockName=" + blockName + "]";
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
}
