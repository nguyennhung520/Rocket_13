package com.vti.entity;

public class Student_1  implements IStudent{
	public static int COUNT;
	private int propertyID;
	private String nameStudent;
	private int groupInt;
	public Student_1(String nameStudent, int groupInt) {
		super();
		COUNT++;
		this.propertyID = COUNT;
		this.nameStudent = nameStudent;
		this.groupInt = groupInt;
	}
	
	public int getGroupInt() {
		return groupInt;
	}

	@Override
	public String toString() {
		return "Student_1 [propertyID=" + propertyID + ", nameStudent=" + nameStudent + ", groupInt=" + groupInt + "]";
	}
	@Override
	public void attendance() {
		// TODO Auto-generated method stub
		System.out.println(nameStudent+ "Diem danh");
	}
	@Override
	public void homeWork() {
		// TODO Auto-generated method stub
		System.out.println(nameStudent+ "Dang hoc bai.");
	}
	@Override
	public void cleanOfClass() {
		// TODO Auto-generated method stub
		System.out.println(nameStudent+"Di don ve sinh");
	}
	
}
