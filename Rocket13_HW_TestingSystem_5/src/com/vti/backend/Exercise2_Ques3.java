package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.HCN;
import com.vti.entity.HV;

public class Exercise2_Ques3 {
	private HCN hCN;
	private HV hv;
	private Scanner sc;
	public void Exercise2_Ques3() {
		sc = new Scanner(System.in);
	}
	public void question3() {
		while(true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
			System.out.println("=== 			1. Create Square. 									===");
			System.out.println("=== 			2. Tính chu vi hình vuông. 							===");
			System.out.println("=== 			3. Tính diện tích hình vuông. 						===");
			System.out.println("=== 			4. Exit. 											===");
			System.out.println("=======================================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhp canh hinh vuong: ");
				Float a = sc.nextFloat();
				hv = new HV(a);
				System.out.println("Ban vau tao thanh cong hinh vuong co canh: "+a);
				break;
			case 2:
				System.out.println("Chu vi cua hinh vuong: "+hCN.chuVi());
				break;
			case 3:
				System.out.println("Dien tich hinh vuong la: "+hCN.dienTich());
				break;
			case 4:
				return;
			default:
				System.out.println("SAI SAI SAI ROI");
				break;
			}
		}
	}
}
