package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;

public class Test {

	private static final int ArrayList = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CanBo> cbList = new ArrayList<CanBo>();
		int n;
		System.out.print("Moi ban nhap vao so luong can bo n = ");
		n = new Scanner(System.in).nextInt();
		//Khai bao mang gom n sinh vien
		CanBo[] arrCB = new CanBo[n];
		for(int i = 0; i < arrCB.length; i++) {
			arrCB[i] = new CanBo();//Khoi tao doi tuong sinh vien thu i
			System.out.println("-Nhap thong tin CB thu: "+(i+1));
			CanBo.nhapCanBo(arrCB[i]);
		}
		//Xuat danh sach SV ra man hinh
		for(int i = 0; i < arrCB.length; i++) {
			CanBo.xuatCanBo(arrCB[i]);
		}
		System.out.println("search full name");
		searchFullName();
	}
		
	public static void nhapCanBo(CanBo canBo)
	{
		System.out.println("Nhap ho ten: ");
		canBo.setHoTen(new Scanner(System.in).nextLine());
		System.out.println("Nhap tuoi: ");
		canBo.setTuoi(new Scanner(System.in).nextInt());
		System.out.println("Nhap dia chi");
		canBo.setDiaChi(new Scanner(System.in).nextLine());
		System.out.println("Nhap gioi tinh: ");
		canBo.setGioiTinh(new Scanner(System.in).nextLine());
	}
	public static void xuatCanBo(CanBo canBo)
	{
		System.out.println(canBo.getHoTen()+canBo.getTuoi()+canBo.getDiaChi()+canBo.getGioiTinh());
	}
	
	private static void searchFullName() {
		int j = 0;
		CanBo[] arrCB = new CanBo[j];
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten: ");
		String hoTen = sc.nextLine();
		// TODO Auto-generated method stub
		for (int i = 0; i < arrCB.length; i++) {
			if(arrCB[i]!= null)
				xuatCanBo(arrCB[i]);
		}
	}
	
}
	
