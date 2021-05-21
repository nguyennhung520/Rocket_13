package com.vti.frontend;

import java.time.LocalDate;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department dep1 = new Department();//ham khoi tao cho doi tuong
		dep1.id = 1;
		dep1.name ="Marketing";
		
		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";
		
		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Account";
		
		//Tao Possition
		Position pos = new Position();
		pos.id = 1;
		pos.name = PositionName.SCRUM_MASTER;
		
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.DEV;
		
		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.PM;
		
		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.TEST;
		
		//Tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name ="TestingSystem";
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name="Manager";
		
		//Tao Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email="mai";
		acc1.userName ="mai";
		acc1.fullName ="nguyen mai";
		acc1.department = dep1;
		acc1.position = pos2;
		Group[] groupAcc1 = {group1, group2};
		acc1.groups = groupAcc1;
		acc1.createDate = LocalDate.of(2021, 02, 04);
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email= "hung";
		acc2.userName = "hung";
		acc2.fullName="tran hung";
		acc2.department= dep2;
		acc2.position = pos3;
		Group[] groupAcc2 = {group1};
		acc2.groups = groupAcc2;
		acc2.createDate = LocalDate.now();
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email ="linh";
		acc3.userName="mai";
		acc3.fullName="linh mai";
		acc3.department = dep3;
		acc3.position =pos;
		Group[] groupAcc3= {group1,group2};
		acc3.groups = groupAcc3;
		acc3.createDate = LocalDate.of(2021, 05, 05);
		
		System.out.println("In thong tin account tren he thong");
		System.out.println("Thong tin Account1: ");
		System.out.println("ID: "+acc1.id);
		System.out.println("Email: "+acc1.email);
		System.out.println("Department: "+acc1.department.name);
		System.out.println("Group: "+acc1.groups[0].name+" "+acc1.groups[1].name);
		System.out.println("Create: "+acc1.createDate);
		
		//add group  
		group1.account = new Account[] {acc1};
		group2.account = new Account[] {acc1,acc2};
		//ques1
		
		if (acc2.department == null) {
			System.out.println("Nhan vien chua co phong ban");
		}else {
			System.out.println("phong cua nhan vien la: "+acc2.department.name);
		}
		
		
		//ques2
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		}else {
			int countGroup = acc2.groups.length;
			if(countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			}
			if(countGroup == 3) {
					System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			}
			if(countGroup >= 4) {
				System.out.println("Nhân viên này là  người hóng chuyện, tham gia tất cả các group");
			}
		}
		
		//ques3
		System.out.println(acc2.department == null? "Nhân viên này chưa có phòng ban.":"Phòng của nhân viên này là: "+acc2.department.name);
		
		//ques 4: su dung toan tu ternary de lam yeu cau sau:
		// kiem tra position cua account thu 1
		// neu position = dev thi in ta text "Day la Developer"
		// neu khong thi in ra text "Nguoi nay khong phai la developer
		
		//System.out.println(acc1.position.name == "DEV"? "Day la Developer" : "Nguoi nay khong phai la developer");
		
		
		
		// Question 5:
		/*Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
			Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
			Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
			Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
			Còn lại in ra "Nhóm có nhiều thành viên*/
			
		if(group1.account == null) {
			System.out.println("Group khong co account nao");
		}else {
			int coungAccountInGroup = group1.account.length;
			switch (coungAccountInGroup) {
			case 1:
				System.out.println("Nhóm có một thành viên");
				break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
				break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}
		}
		
		//q6
		if(acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		}else {
			int countGroup = acc2.groups.length;
			switch (countGroup) {
			case 1:
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			case 2:
				System.out.println("\"Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
			default:
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				break;
			}
		}
		
		
		//Ques7
//		System.out.println("Question 7");
//		switch(acc1.position.name == "DEV") {
//		case 1:
//			System.out.println("Day la developer");
//			break;
//		default:
//			System.out.println("Nguoi nay khong phai la developer");
//			break;
//		}
		
		
		//Ques8: in ra thong tin account bao gom: email, fullname va ten phong ban
		
		System.out.println("Question 8: Su dung Foreach");
		Account[] accArray2 = {acc1,acc2};
		for (Account account : accArray2) {
			System.out.println("AccountID: "+account.id+"Email: "+ account.email + "Fullname: "+ account.fullName + "Department: "+ account.department);
		}
		
		//Ques9: in ra thong tin phong ban bao gom: id va name
		System.out.println("Question 9 SD Foreach");
		Department[] departArray1 = {dep1,dep2,dep3};
		for(Department dep : departArray1) {
			System.out.println("DepartmentID: "+dep.id + "DepartmentName: "+dep.name);
		}
		
		
		//ques10
		System.out.println("Question 10 SD FOR");
		Account[] accArray1 = {acc1,acc2};
		for (int i = 0; i < accArray1.length; i++) {
			System.out.println("Thong tin account thu "+ (i+1) + "la: ");
			System.out.println("Email: "+accArray1[i].email);
			System.out.println("Fullname: "+accArray1[i].fullName);
			System.out.println("Department: "+accArray1[i].department.name);
		}
		
		// Question 11: 
		//In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau: 
			//Thông tin department thứ 1 là: 
				//Id: 1
				//Name: Sale
			//Thông tin department thứ 2 là: 
				//Id: 2
			//Name: Marketing
		
		System.out.println("Question 11 SD FOR");
		Department[] departArray2 = {dep1,dep2};
		for (int i = 0; i < departArray2.length; i++) {
			System.out.println("Thong tin department thu "+(i+1) + "la: ");
			System.out.println("DepartmentID: "+departArray2[i].id);
			System.out.println("DepartmentName: "+departArray2[i].name);
		}
		
		//Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		System.out.println("Question 12 SD FOR");
		Department[] departArray3 = {dep1,dep2,dep3};
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin department thu "+ (i+1) + "la: ");
			System.out.println("ID: "+departArray3[i].id);
			System.out.println("Name: "+departArray3[i].name);
		}
		
		//Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
		System.out.println("Question 13 SD FOR");
		Department[] departArray4 = {dep1, dep2, dep3};
		for (int i = 0; i != 2; i++) {
			System.out.println("Thong tin department thu "+(i+1) + "la: ");
			System.out.println("ID: "+departArray4[i].id);
			System.out.println("Name: "+departArray4[i].name);
		}
	}

}
