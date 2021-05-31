package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Person;
import com.vti.entity.Student_2;

public class Exercise2_Ques2 {
	private Scanner sc;
	public void Exercise2_Question2() {
//		super();
		sc = new Scanner(System.in);
	}
	public void question2() {
		while (true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
			System.out.println("=== 			 1. Demo Person.      								===");
			System.out.println("=== 			 2. Demo Stusent. 									===");
			System.out.println("=== 			 3. Exit. 											===");
			System.out.println("=======================================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				demoPersons();
				break;
			case 2:
				demoStudents();
			case 3:
				return;
			default:
				System.out.println("CHU Y Y!! SAAI");
				break;
			}

		}
	}
	private void demoStudents() {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.inputInfo();
		System.out.println("Thong tin person vua nhap vao: ");
		System.out.println(person.showInfo());
	}
	private void demoPersons() {
		// TODO Auto-generated method stub
		Student_2 st2 = new Student_2();
		st2.inputInfo();
		System.out.println("Thong tin person vua nhap vao: ");
		System.out.println(st2.showInfo());
		if (st2.Scholarship()) {
			System.out.println("Sinh vien nay dat hoc bong.OK");
		} else {
			System.out.println("Sinh vien nay khong dat hoc bong.OKDe");
		}
	}
}
