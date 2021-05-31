package com.vti.frontend;

import java.util.Scanner;

import com.vti.entity.MyMath;

public class N_Exercise_Ques4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MyMath myMath = new MyMath();
		while(true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
			System.out.println("=== 			 1. Tính tổng 2 số kiểu int. 						===");
			System.out.println("=== 			 2. Tính tổng 2 số kiểu byte. 						===");
			System.out.println("=== 			 3. Tính tổng 2 số kiểu Float.					    ===");
			System.out.println("=== 			 4. Tính tổng 2 số kiểu int và float. 				===");
			System.out.println("=== 			 5. Tính tổng 2 số kiểu Byte và float. 				===");
			System.out.println("=== 			 6. Exit. 											===");
			System.out.println("=======================================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhap vao so int 1: ");
				int int1 = sc.nextInt();
				System.out.println("Nhap vao so int 2: ");
				int int2 = sc.nextInt();
				System.out.println("Tong 2 so int la: "+myMath.getSum(int1, int2));
				break;
			case 2:
				System.out.println("Nhap vao so byte 1: ");
				byte byte1 = sc.nextByte();
				System.out.println("Nhap vao so byte 2: ");
				byte byte2 = sc.nextByte();
				System.out.println("Tong 2 so byte la: "+myMath.getSum(byte1, byte2));
				break;
			case 3:
				System.out.println("Nhap vao so float 1: ");
				float float1 = sc.nextFloat();
				System.out.println("Nhap vao so float 2: ");
				float float2 = sc.nextFloat();
				System.out.println("Tong 2 so float la: "+myMath.getSum(float1, float2));
				break;
			case 4:
				System.out.println("Nhap vao so int 1: ");
				int int3 = sc.nextInt();
				System.out.println("Nhap vao so float 2: ");
				float float3 = sc.nextFloat();
				System.out.println("Tong 2 so la: "+myMath.getSum(int3, float3));
				break;
			case 5:
				System.out.println("Nhap vao so byte 1: ");
				byte byte3 = sc.nextByte();
				System.out.println("Nhap vao so float 2: ");
				float float4 = sc.nextFloat();
				System.out.println("Tong 2 so la: "+myMath.getSum(byte3, float4));
				break;
			case 6:
				return;
			default:
				System.out.println("SAI NHAP SAI ROI KIA!!!");
				break;
			}
		}
	}

}
