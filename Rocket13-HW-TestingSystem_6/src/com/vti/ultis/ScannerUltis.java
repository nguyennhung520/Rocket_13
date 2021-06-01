package com.vti.ultis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);
	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine().trim());
			}catch(Exception e) {
				System.out.println("SAI ROI! Nhap lai: ");
			}
		}
	}
	public static int inputIntPositive() {
		while(true) {
			try {
				int intPositive = Integer.parseInt(sc.nextLine());
				if(intPositive >= 0) {
					return intPositive;
				}else {
					System.out.println("NHAP LAI: COME ON");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("NHAP LAI: COME ON");
			}
		}
	}
	public static float inputFloat(String str) {
		while(true) {
			try {
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("NHAP LAI: COME ON ");
			}
		}
	}
	
	
	public static String inputString() {
		while (true) {
			String str = sc.nextLine().trim();
			if(!str.isEmpty()) {
				return str;
			}else {
				System.out.println("NHAP LAI NAO: OK!");
			}
		}
	}
	public static LocalDate inputLocalDate() {
		System.out.println("Nhap theo dinh dang yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while(true) {
			String localdate = sc.nextLine().trim();
			try {
				if(format.parse(localdate)!=null) {
					LocalDate ld = LocalDate.parse(localdate);
					return ld;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("CHU Y NHAP DUNG NHAP YYYY-MM-DD. OK: ");
			}
		}
	}
}
