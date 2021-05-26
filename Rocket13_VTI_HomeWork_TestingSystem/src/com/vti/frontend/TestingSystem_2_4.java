package com.vti.frontend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Group;

public class TestingSystem_2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// Tạo Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing_System";
		group1.createDate = LocalDate.of(2021, 1, 1);
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2020, 2, 1);
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		group3.createDate = LocalDate.of(2019, 9, 23);
		// Tạo Account
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
		Account[] accArray = { acc1, acc2, acc3 };
		Group[] groupArray = { group1, group2, group3 };
		
		System.out.println("Danh sách User đang có trên hệ thống: ");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].userName);
		}
		
		System.out.println("Nhập vào UserName của account: ");
		String userName = sc.nextLine();
		
		System.out.println("Danh sách group đang có trên hệ thống: ");
		for (int y = 0; y < groupArray.length; y++) {
			System.out.println(groupArray[y].name);
		}
		
		System.out.println("Nhập vào tên group của group: ");
		String nameGroup = sc.nextLine();
		
		int indexGroup = -1;
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i].name.equals(nameGroup)) {
				indexGroup = i;
			}
		}
		
		int indexAccount = -1;
		for (int j = 0; j < accArray.length; j++) {
			if (accArray[j].userName.equals(userName)) {
				indexAccount = j;
			}
		}
		if (indexAccount < 0 || indexGroup < 0) {
			System.out.println("Kiểm tra lại thông tin bạn nhập, không có Account hoặc group này trên hệ thống");
		} else {
			for (int j = 0; j < accArray.length; j++) {
				if (accArray[j].userName.equals(userName)) {
					Group[] gpAdd = { groupArray[indexGroup] };
					accArray[j].groups = gpAdd;
					System.out.println("Bạn vừa Add group: " + accArray[indexAccount].groups[0].name + " cho Account: "
							+ accArray[indexAccount].userName);
				}
			}
		}
	}

}
