package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.TuyenSinh;

public class Exercise1_Ques2 {
	private TuyenSinh tuyenSinh;
	private Scanner sc;
	public void Exercise1_Ques2(){
		sc = new Scanner(System.in);
		tuyenSinh = new TuyenSinh();
	}
	public void question() {
		menuStudent();
	}
	private void menuStudent() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("===========================================================");
			System.out.println("===============Lua chon chuc nang ban muon su dung=========");
			System.out.println("===============1. Insert Student 	  =====================");
			System.out.println("===============2. View Student   	  =====================");
			System.out.println("===============3. Find by StudentID   =====================");
			System.out.println("===========================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				tuyenSinh.addStudent();
				break;
			case 2:
				tuyenSinh.printInformationStudentandBlock();
				break;
			case 3:
				System.out.print("Nhap vao ID student can tim kiem: ");
				int studentID = sc.nextInt();
				tuyenSinh.searchStudentID(studentID);
				break;
			case 4:
				return;
			default:
				System.out.println("Error Input Database!");
				break;
			}
		}
	}
}
