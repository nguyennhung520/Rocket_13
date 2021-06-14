package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Function function = new Function();
		while (true) {
			while (true) {
				System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
				String leftAlignFormat = "| %-72s |%n";
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format("|                        Choose please                                     |%n");
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format(leftAlignFormat, "1. Login");
				System.out.format(leftAlignFormat, "2. Tìm thành viên của Project theo ProjectID");
				System.out.format(leftAlignFormat, "3. Lấy ra tất cả các Manager của Project");
				System.out.format(leftAlignFormat, "4. Exit");
				System.out.format("+--------------------------------------------------------------------------+%n");
				switch (ScannerUltis.inputIntPositive()) {
				case 1:
					function.getLogin();
					break;
				case 2:
					function.findAccountofProID();
					break;
				case 3:
					function.getAccountManager();
				case 4:
					return;
				default:
					System.out.println("Nhập lại:");
					break;
				}
			}
		}
	}

}
