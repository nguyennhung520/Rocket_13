package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class TestingSystem_2 {

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
		group1.accounts = new Account[] {acc1};
		group2.accounts = new Account[] {acc1,acc2};
		
		//ques1
		// Question 1:
		System.out.println("---------Question 1 Check acc2:---------");
		if (acc2.department == null) {
		System.out.println("Nh??n vi??n n??y ch??a c?? ph??ng ban.");
		} else {
		System.out.println("Ph??ng ban c???a nv n??y l??: " + 
		acc2.department.name);
		}
				
		//ques2
		if (acc2.groups == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? group");
		} else {
			int countGroup = acc2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
			}
			if (countGroup == 3) {
				System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
			}
			if (countGroup >= 4) {
				System.out.println("Nh??n vi??n n??y l??  ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
			}
		}
				
		// ques3
		System.out.println(acc2.department == null ? "Nh??n vi??n n??y ch??a c?? ph??ng ban."
				: "Ph??ng c???a nh??n vi??n n??y l??: " + acc2.department.name);
				
		// ques 4: su dung toan tu ternary de lam yeu cau sau:
		// kiem tra position cua account thu 1
		// neu position = dev thi in ta text "Day la Developer"
		// neu khong thi in ra text "Nguoi nay khong phai la developer

		System.out.println("---------Question 4: s??? d???ng Terry cho Position--------- ");
				System.out.println(
				acc1.position.name.toString() == "Dev" ? "????y l?? Developer" : "Ng?????i n??y kh??ng ph???i l?? Developer");
				
		// Question 5:
		/*
		* L???y ra s??? l?????ng account trong nh??m th??? 1 v?? in ra theo format sau: N???u s???
		* l?????ng account = 1 th?? in ra "Nh??m c?? m???t th??nh vi??n" N???u s??? l?????ng account = 2
		* th?? in ra "Nh??m c?? hai th??nh vi??n" N???u s??? l?????ng account = 3 th?? in ra
		* "Nh??m c?? ba th??nh vi??n" C??n l???i in ra "Nh??m c?? nhi???u th??nh vi??n
		*/

		if (group1.accounts == null) {
			System.out.println("Group khong co account nao");
		} else {
			int coungAccountInGroup = group1.accounts.length;
			switch (coungAccountInGroup) {
			case 1:
				System.out.println("Nh??m c?? m???t th??nh vi??n");
				break;
			case 2:
				System.out.println("Nh??m c?? hai th??nh vi??n");
				break;
			case 3:
				System.out.println("Nh??m c?? ba th??nh vi??n");
			default:
				System.out.println("Nh??m c?? nhi???u th??nh vi??n");
				break;
			}
		}
				
		// q6
		if (acc2.groups == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? group");
		} else {
			int countGroup = acc2.groups.length;
			switch (countGroup) {
			case 1:
				System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
				break;
			case 2:
				System.out.println("\"Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
				break;
			default:
				System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
				break;
			}
		}
				
				
		// Ques7
		System.out.println("---------Question 7: S??? d???ng switch case ????? l??m l???i Question 4---------");
		String positionName = acc1.position.name.toString();
		switch (positionName) {
		case "Dev":
			System.out.println("????y l?? Developer");
			break;
		default:
			System.out.println("Ng?????i n??y kh??ng ph???i l?? Developer");
			break;
		}
				
				
		// Ques8: in ra thong tin account bao gom: email, fullname va ten phong ban

		System.out.println("Question 8: Su dung Foreach");
		Account[] accArray2 = { acc1, acc2 };
		for (Account account : accArray2) {
			System.out.println("AccountID: " + account.id + "Email: " + account.email + "Fullname: " + account.fullName
					+ "Department: " + account.department);
		}
				
		// Ques9: in ra thong tin phong ban bao gom: id va name
		System.out.println("Question 9 SD Foreach");
		Department[] departArray1 = { dep1, dep2, dep3 };
		for (Department dep : departArray1) {
			System.out.println("DepartmentID: " + dep.id + "DepartmentName: " + dep.name);
		}
				
				
		// ques10
		System.out.println("Question 10 SD FOR");
		Account[] accArray1 = { acc1, acc2 };
		for (int i = 0; i < accArray1.length; i++) {
			System.out.println("Thong tin account thu " + (i + 1) + "la: ");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Fullname: " + accArray1[i].fullName);
			System.out.println("Department: " + accArray1[i].department.name);
		}
				
		// Question 11:
		// In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng sau:
		// Th??ng tin department th??? 1 l??:
		// Id: 1
		// Name: Sale
		// Th??ng tin department th??? 2 l??:
		// Id: 2
		// Name: Marketing

		System.out.println("Question 11 SD FOR");
		Department[] departArray2 = { dep1, dep2 };
		for (int i = 0; i < departArray2.length; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + "la: ");
			System.out.println("DepartmentID: " + departArray2[i].id);
			System.out.println("DepartmentName: " + departArray2[i].name);
		}

		// Question 12: Ch??? in ra th??ng tin 2 department ?????u ti??n theo ?????nh d???ng nh??
		// Question 10
		System.out.println("Question 12 SD FOR");
		Department[] departArray3 = { dep1, dep2, dep3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + "la: ");
			System.out.println("ID: " + departArray3[i].id);
			System.out.println("Name: " + departArray3[i].name);
		}
				
		// Question 13: In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2
		System.out.println(
				"----------Question 13:In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2: ------------");
		Account[] accArray21 = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray21.length; i++) {
			if (i != 1) {
				System.out.println("Th??ng tin account th??? " + (i + 1) + " l??:");
				System.out.println("Email: " + accArray21[i].email);
				System.out.println("Full name: " + accArray21[i].fullName);
				System.out.println("Ph??ng ban: " + accArray21[i].department.name);
			}
		}
		
		//Question 14: In ra th??ng tin t???t c??? c??c account c?? id < 4
		System.out.println("Question 14: In ra th??ng tin t???t c??? c??c account c?? id < 4");
		Account[] accArray5 = {acc1,acc2,acc3};
		for (int i = 0; i < accArray5.length; i++) {
			if (accArray5[i].id < 4) {
				System.out.println("Th??ng tin account th??? " + (i + 1) + " l??:");
				System.out.println("Email: " + accArray5[i].email);
				System.out.println("Full name: " + accArray5[i].fullName);
				System.out.println("Ph??ng ban: " + accArray5[i].department.name);
			}
		}
		
		//Question 15: In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20
		System.out.println("Question 15: In ra c??c s??? ch???n <= 20");
		for (int i = 0; i <= 20; i++) {
			if (i%2 == 0) {
				System.out.println(i+ " ");
			}
		}
		
		//S??? D???NG C??U L???NH WHILE L??M L???I C??C B??I TRONG C??U L???NH FOR
		//Question 16:
		//Question 16.1. In ra th??ng tin c??c account bao g???m:Email,FullName v?? t??n ph??ng ban
		System.out.println("16.1. In ra th??ng tin c??c account bao g???m:Email,FullName v?? t??n ph??ng ban");
		Account[] accArray11 = {acc1,acc2,acc3};
		int i = 0;
		while (i < accArray11.length) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + "l??: ");
			System.out.println("Email: " + accArray11[i].email);
			System.out.println("Fullname: " + accArray11[i].fullName);
			System.out.println("Department: " + accArray11[i].department.name);
			i++;
		}
		
		//Question 16.2. In th??ng tin c??c ph??ng ban bao g???m id v?? name
		System.out.println("In th??ng tin c??c ph??ng ban bao g???m id v?? name");
		Department[] depArray6 = {dep1,dep2,dep3};
		while (i < depArray6.length) {
			System.out.println("Th??ng tin c???a ph??ng ban th???: " + (i+1) + "l??: ");
			System.out.println("DepartmentID: " + depArray6[i].id);
			System.out.println("DepartmentName: " + depArray6[i].name);
			i++;
		}
		
		//Question 16.3. Ch??? in ra th??ng tin 2 department ?????u ti??n
		System.out.println("Ch??? in ra th??ng tin 2 department ?????u ti??n");
		int j = 0;
		Department[] departArray31 = {dep1,dep2,dep3};
		while (j < 2) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + "l??: ");
			System.out.println("ID: " + departArray31[i].id);
			System.out.println("Name: " + departArray31[i].name);
			j++;
		}
		
		//Question 16.4. In ra th??ng tin t???t c??c account ngo???i tr??? account th??? 2
		System.out.println("In ra th??ng tin t???t c??c account ngo???i tr??? account th??? 2");
		Account[] accArray7 = {acc1,acc2,acc3};
		int i2 = 0;
		while (i2 < accArray7.length) {
			if (i2 != 1) {
				System.out.println("Th??ng tin account th??? "+(i2+1)+ "l??: ");
				System.out.println("Email: "+ accArray7[i2].email);
				System.out.println("Full name: "+accArray7[i2].fullName);
				System.out.println("Department: "+accArray7[i2].department);
			}
			i2++;
		}
		
		//Question 16.5. In ra th??ng tin t???t c??? c??c account c?? id < 4
		System.out.println("In ra th??ng tin t???t c??? c??c account c?? id < 4");
		Account[] accArray6 = {acc1,acc2,acc3};
		int i3 = 0;
		while (i3 < accArray6.length) {
			if(accArray6[i].id < 4) {
				System.out.println("Th??ng tin account th??? "+(i3+1) + "l??: ");
				System.out.println("Email: "+accArray6[i3].email);
				System.out.println("Full name: "+accArray6[i3].fullName);
				System.out.println("Department: "+accArray6[i3].department);
			}
			i3++;
		}
		
		//Question 16.6. In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20
		System.out.println("In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20");
		int i4 = 1;
		while (i4 <= 20) {
			if(i4 % 2 == 0) {
				System.out.println(i4+ " ");
			}
			i4++;
		}
		
		//S??? D???NG DO WHILE
		//Question 17.1.In ra th??ng tin c??c account bao g???m: Email,fullname,departmentname
		System.out.println("In ra th??ng tin c??c account bao g???m: Email,fullname,departmentname");
		Account[] accArray51 = {acc1,acc2,acc3};
		int i5 = 0;
		do {
			System.out.println("Th??ng tin account th???" + (i+1)+ "l??: ");
			System.out.println("Email: "+ accArray51[i].email);
			System.out.println("Full name: "+accArray51[i].fullName);
			System.out.println("Department: "+accArray51[i].department);
			i5++;
		} while (i5 < accArray51.length);
		
		//Question 17.2.In ra th??ng tin c??c ph??ng  ban bao g???m: id v?? name
		System.out.println("In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name");
		Department[] depArray4 = {dep1,dep2,dep3};
		int j3 = 0;
		do {
			System.out.println("Th??ng tin department th??? "+ (j3+1) + "l??: ");
			System.out.println("DepartmentID: "+ depArray4[j3].id);
			System.out.println("DepartmentName: "+depArray4[j3].name);
			j3++;
		} while (j3 < depArray4.length);
		
		//Question 17.3.In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2
		System.out.println("In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2");
		Account[] accArray9 = {acc1,acc2,acc3};
		int j4 = 0;
		do {
			if (j4 != 1) {
				System.out.println("Th??ng tin account th??? "+(j4+1)+ "l??: ");
				System.out.println("Email: "+accArray9[j4].email);
				System.out.println("Full name: "+accArray9[j4].fullName);
				System.out.println("Department: "+accArray9[j4].department);
				j4++;
			}
		} while (j4 < accArray9.length);
		
		//Question 17.4.In ra th??ng tin t???t c??? c??c account c?? id < 4
		System.out.println("---------- Question 17-14: In ra th??ng tin t???t c??? c??c account c?? id < 4-----------");
		Account[] accArray3 = { acc1, acc2, acc3 };
		int j5 = 0;
		do {
			if (accArray3[j5].id < 4) {
				System.out.println("Th??ng tin account th??? " + (j5 + 1) + " l??:");
				System.out.println("Email: " + accArray3[j5].email);
				System.out.println("Full name: " + accArray3[j5].fullName);
				System.out.println("Ph??ng ban: " + accArray3[j5].department.name);
			}
			j5++;
		} while (j5 < accArray3.length);
		
		//Question 17.5. In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20
		System.out.println("In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20");
		int j6 = 0;
		do {
			if (j6 % 2 == 0) {
				System.out.println(j6+ " ");
			}
		} while (j6 <= 20);
	}
}
