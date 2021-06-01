package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise2;

public class N_Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		question1();
	}

	private static void question1() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao so 1: ");
		int num1 = sc.nextInt();
		System.out.println("Nhap vao so 2: ");
		int num2 = sc.nextInt();
		try {
			System.out.println("Ket qua: "+Exercise2.device(num1, num2));
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Co loi khi thuc hien chi cho so 0");
		}finally {
			System.out.println("-----");
			System.out.println("The end!!!");
		}
	}

}
