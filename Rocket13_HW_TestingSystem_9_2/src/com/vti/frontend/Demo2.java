package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.vti.backend.Exercise2_1;
import com.vti.ultis.ScannerUltis;

public class Demo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Exercise2_1 ex2_1 = new Exercise2_1();
		while(true) {
			loadMenu();
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				ex2_1.question1();
				break;
			case 2:
				ex2_1.question2();
				break;
			case 3:
				ex2_1.question3();
				break;
			case 4:
				ex2_1.question4();
				break;
			case 5:
				ex2_1.question5();
				break;
			case 6:
				ex2_1.question6();
				break;
			case 7:
				ex2_1.question7();
				break;
			case 8:
				return;
			default:
				System.out.println("Sai roi nhap lai nao: ");
				break;
			}
		}
	}

	private static void loadMenu() {
		String leftAlignFormat = "| %-72s |%n";
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|			CHON CHUC NANG												  |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. Lay ra danh sach tat ca cac Department					 ");
		System.out.format(leftAlignFormat, "2. Lay ra Department co Id = 5					 			 ");
		System.out.format(leftAlignFormat, "3. Tim kiem Department bang DepartmentId					 ");
		System.out.format(leftAlignFormat, "4. Check DepartmentName co ton tai hay khong				 ");
		System.out.format(leftAlignFormat, "5. Tao Department				 						 	 ");
		System.out.format(leftAlignFormat, "6. Update DepartmentName					 				 ");
		System.out.format(leftAlignFormat, "7. Xoa Department theo ID									 ");
		System.out.format(leftAlignFormat, "8. Thoat he thong					 						 ");
		System.out.format("+--------------------------------------------------------------------------+%n");
		
		
	}
}
