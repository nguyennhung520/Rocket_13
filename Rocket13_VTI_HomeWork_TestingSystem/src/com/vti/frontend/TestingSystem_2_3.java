package com.vti.frontend;

import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class TestingSystem_2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("----------------------------------------");
			System.out.println("1. Tạo phòng ban");
			System.out.println("2. Tạo account");
			System.out.println("3. Exit");
			System.out.println("----------------------------------------");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				createAccount();
				break;
			case 2:
				createDepartment();
				break;
			case 3:
				return;
			default:
				System.out.println("Mời bạn nhập lại giá trị : ");
				break;
			}
		}
	}

	private static void createDepartment() {
		// TODO Auto-generated method stub
		System.out.println("Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin Department cân tạo: ");
		Department dep = new Department();
		System.out.println("Nhập ID: ");
		dep.id = sc.nextInt();
		System.out.println("Nhập Name: ");
		dep.name = sc.next();
		System.out.println("Thông tin Department vừa nhập, ID: " + dep.id + " Name: " + dep.name);
	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin account cân tạo: ");
		Account acc = new Account();
		System.out.println("Nhập ID: ");
		acc.id = sc.nextInt();
		System.out.println("Nhập email: ");
		acc.email = sc.next();
		System.out.println("Nhập userName: ");
		acc.userName = sc.next();
		System.out.println("Nhập fullName: ");
		acc.fullName = sc.next();
		System.out
				.println("Nhập position (Nhập các số từ 1 đến 4 tương ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
		int posNum = sc.nextInt();
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
		System.out.println("Thông tin Acc vừa nhập, ID: " + acc.id + " Email: " + acc.email + " UserName: "
				+ acc.userName + " FullName: " + acc.fullName + " Position: " + acc.position.name);
	}

}
