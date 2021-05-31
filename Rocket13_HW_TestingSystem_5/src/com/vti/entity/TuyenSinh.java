package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh{

	private ArrayList<Student> listStudent;
	private Scanner sc;
	public void tuyenSinh() {
		listStudent = new ArrayList<Student>();
		sc = new Scanner(System.in);
	}
	
	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao ten thi sinh: ");
		String stuName = sc.nextLine();
		System.out.println("Nhap vao dia chi thi sinh: ");
		String addressStu = sc.nextLine();
		System.out.println("Nhap vao muc tien cua thi sinh: ");
		int priStu = sc.nextInt();
		System.out.println("Nhap vao khoi thi sinh chon: 1. Khoi A, 2.Khoi B, 3.Khoi C: ");
		String blockName = sc.nextLine();
		Student student = new Student(stuName, addressStu, priStu, blockName);
		listStudent.add(student);
	}

	@Override
	public void printInformationStudentandBlock() {
		// TODO Auto-generated method stub
		for (Student student : listStudent) {
			System.out.println("Danh sach sinh vien"+student);
		}
	}

	@Override
	public void searchStudentID(int studentID) {
		// TODO Auto-generated method stub
		for (Student student : listStudent) {
			if(student.getStudentID() == studentID) {
				System.out.println("Sinh vien "+student);
			}
		}
	}

	@Override
	public void exitprogram() {
		// TODO Auto-generated method stub
		return;
	}

}
