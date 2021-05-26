package com.vti.frontend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;

public class TestingSystem_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Exercise : Method
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10");
			System.out.println("Question 2: Tạo method để in thông tin các account");
			System.out.println("Question 3: Tạo method để in ra các số nguyên dương nhỏ hơn 10");
			System.out.println("Exit");
			System.out.println("-----------------------------------------------------------------------");
			choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3) {
				switch (choose) {
				case 1:
					chanNguyenDuongNhoHon10();
					break;
				case 2:
					inRaThongTinAccount();
					break;
				case 3:
					nguyenDuongNhoHon10();
					break;
				default:
					System.out.println("Nhập sai dữ liêu!. Nhập lại: ");
					break;
				}
			}
		}

	}

	private static void nguyenDuongNhoHon10() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("Số nguyên dương nhỏ hơn 10: ");
		}
	}

	private static void inRaThongTinAccount() {
		// TODO Auto-generated method stub
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.createDate = LocalDate.now();
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.createDate = LocalDate.of(2021, 03, 17);
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.createDate = LocalDate.now();
		printAccount(acc1);
		printAccount(acc2);
		printAccount(acc3);		
	}

	private static void printAccount(Account account) {
		System.out.println("ID: " + account.id + " Email: " + account.email + " Username: " + account.userName
				+ " FullName: " + account.fullName + " CreareDate: " + account.createDate);
	}

	private static void chanNguyenDuongNhoHon10() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i + " ");
			}
		}
		System.out.println("Số chẵn nguyên dương nhỏ hơn 10: ");
	}

}
