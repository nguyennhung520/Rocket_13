package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Student_1;


public class Exercise2_Ques1 {
	private ArrayList<Student_1> listStudent;
	private Random random;
	private Scanner sc;
	public void Exercise2() {
		listStudent = new ArrayList<Student_1>();
		random = new Random();
		sc = new Scanner(System.in);
	}
	public void question1() {
		while (true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
			System.out.println("=== 			1. Tạo danh sách sinh viên. 						===");
			System.out.println("=== 			2. Hiển thị ds sv trong lớp. 						===");
			System.out.println("=== 			3. Điểm danh lớp 									===");
			System.out.println("=== 			4. Gọi nhóm 1 đi học bài 							===");
			System.out.println("=== 			5. Gọi nhóm 2 đi dọn vệ	sinh						===");
			System.out.println("=== 			6. Exit.											===");
			System.out.println("=======================================================================");
			int menuchoose = sc.nextInt();
			switch (menuchoose) {
			case 1:
				addStudent();
				System.out.println("Tao thanh cong 10 sinh vien");
				break;
			case 2:
				for (Student_1 student_1 : listStudent) {
					System.out.println(student_1);
				}
				break;
			case 3:
			System.out.println("Hoc sinh diem danh: ");
			for (Student_1 student_1 : listStudent) {
				student_1.attendance();
			}
			break;
			case 4:
				System.out.println("Nhom 1 di hoc bai: ");
				for (Student_1 student_1 : listStudent) {
					if (student_1.getGroupInt() == 1) {
						student_1.homeWork();
					}
				}
				break;
			case 5:
				System.out.println("Nhom 2 di ve sinh: ");
				for (Student_1 student_1 : listStudent) {
					if (student_1.getGroupInt() == 2) {
						student_1.cleanOfClass();
					}
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Nhap sai du lieu!!");
				break;
			}
		}
	}
	private void addStudent() {
		// TODO Auto-generated method stub
		
	}
}
