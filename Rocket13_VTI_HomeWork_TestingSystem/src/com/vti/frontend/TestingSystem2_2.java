package com.vti.frontend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class TestingSystem2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Question 1:Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào 3 số nguyên");
		System.out.println("Nhập vào số 1: ");
		int a = sc.nextInt();
		System.out.println("Nhập vào số 2: ");
		int b = sc.nextInt();
		System.out.println("Nhập vào số 3: ");
		int c = sc.nextInt();
		System.out.println("Bạn vừa nhập vào các số: " + a + " " + b + " " + c);
		
		//Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
		Scanner sc1 = new Scanner(System.in);
		System.out.println(
				"---------------Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình-------------------");
		System.out.println("Mời bạn nhập vào 2 số thực");
		System.out.println("Nhập vào số 1: ");
		float f1 = sc1.nextFloat();
		System.out.println("Nhập vào số 2: ");
		float f2 = sc1.nextFloat();
		System.out.println("Bạn vừa nhập vào các số: " + f1 + " " + f2);
		
		//Question 3: Viết lệnh cho phép người dùng nhập họ và tên
		Scanner sc2 = new Scanner(System.in);
		System.out.println("-------------Question 3: Viết lệnh cho phép người dùng nhập họ và tên----------------");
		System.out.println("Mời bạn nhập vào Họ: ");
		String s1 = sc2.next();
		System.out.println("Mời bạn nhập vào Tên: ");
		String s2 = sc2.next();
		System.out.println("Fullname của bạn là:" + s1 + " " + s2);
		
		//Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		Scanner sc3 = new Scanner(System.in);
		System.out.println(
		"-------------Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ----------------");
		System.out.println("Mời bạn nhập vào năm sinh: ");
		int year = sc3.nextInt();
		System.out.println("Mời bạn nhập vào tháng sinh: ");
		int month = sc3.nextInt();
		System.out.println("Mời bạn nhập vào ngày sinh: ");
		int day = sc3.nextInt();
		LocalDate dateBirth = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh của bạn là: " + dateBirth);
		
		//Question 5:
		//Viết lệnh cho phép người dùng tạo account (viết thành method)
		//Đối với property Position, Người dùng nhập vào 1 2 3 4 và vào
		//chương trình sẽ chuyển thành Position.Dev, Position.Test,
		//Position.ScrumMaster, Position.PM
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin account cân tạo: ");
		Account acc = new Account();
		System.out.println("Nhập ID: ");acc.id = sc.nextInt();
		System.out.println("Nhập email: ");
		acc.email = sc.next();
		System.out.println("Nhập userName: ");
		acc.userName = sc.next();
		System.out.println("Nhập fullName: ");
		acc.fullName = sc.next();
		System.out
		.println("Nhập position (Nhập các số từ 1 đến 4 tương ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
		int posNum = sc4.nextInt();
		switch (posNum) {
		case 1:
		Position pos1 = new Position();
		pos1.name = PositionName.DEV;
		acc.position = pos1;
		break;
		case 2:
		Position pos2 = new Position();
		pos2.name = PositionName.TEST;
		acc.position = pos2;
		break;
		case 3:
		Position pos3 = new Position();
		pos3.name = PositionName.SCRUM_MASTER;
		acc.position = pos3;
		break;
		case 4:
		Position pos4 = new Position();
		pos4.name = PositionName.PM;
		acc.position = pos4;
		break;
		}
		System.out.println("Thông tin Acc vừa nhập, ID: " + acc.id + " Email: " + acc.email + " UserName: "+ acc.userName + " FullName: " + acc.fullName + " Position: " + acc.position.name);
		
		//Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)
		System.out.println("Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)");
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin Department cân tạo: ");
		Department dep = new Department();
		System.out.println("Nhập ID: ");
		dep.id = sc5.nextInt();
		System.out.println("Nhập Name: ");
		dep.name = sc5.next();
		System.out.println("Thông tin Department vừa nhập, ID: " + dep.id + " Name: " + dep.name);
		
		//Question 7: Nhập số chẫn từ consolo
		Scanner sc6 = new Scanner(System.in);
		while (true) {
			System.out.println("Hãy nhập vào 1 số chẵn: ");
			int n = sc6.nextInt();
			if (n % 2 == 0) {
				System.out.println("Bạm vừa nhập vào:" + a);
				return;
			} else {
				System.out.println("Nhập sai, đây không phải là số chẵn");
			}
		}
	}

}
