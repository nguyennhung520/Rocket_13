package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Bao;
import com.vti.entity.Sach;
import com.vti.entity.TaiLieu;
import com.vti.entity.TapChi;

public class Exercise5_Ques4 {
	private static ArrayList<TaiLieu> taiLieuList = new ArrayList<TaiLieu>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques4();
	}
	private static void Ques4() {
		// TODO Auto-generated method stub
		int menuchoose = sc.nextInt();
		int n = 0;
		switch (menuchoose) {
		case 1:
			System.out.println("Them moi tai lieu");
			int menuchoose1 = sc.nextInt();
			switch (menuchoose1) {
			case 1:
				addSach();
				break;
			case 2:
				addTapChi();
				break;
			case 3:
				addBao();
				break;
			default:
				System.out.println("Nhap sai du lieu!");
				break;
			}
			break;
		case 2:
			System.out.println("Hien thi tai lieu");
			int menuchoose2 = sc.nextInt();
			switch (menuchoose2) {
			case 1:
				hienThiSach();
				break;
			case 2:
				hienThiTapChi();
				break;
			case 3:
				hienThiBao();
				break;
			default:
				System.out.println("Nhap sai du lieu!");
				break;
			}
		case 3:
			System.out.println("Xoa tai lieu theo ma");
			deleteTLofID();
		default:
			break;
		}
	}
	private static void deleteTLofID() {
		// TODO Auto-generated method stub
		System.out.println("Nhap ma tai lieu can xoa: ");
		int maTL = sc.nextInt();
		taiLieuList.remove(maTL);
		System.out.println("Danh sach tai lieu: "+taiLieuList.toString());
	}
		
	private static void hienThiSach()
	{
		int n = sc.nextInt();
			Sach[] arrSach = new Sach[n];
			System.out.println("Hien thi danh sach Sach");
			for (int i = 0; i < arrSach.length; i++) {
				Sach.hienThiSach(arrSach[i]);
			}
	}
	private static void hienThiTapChi()
	{
		int n = sc.nextInt();
			TapChi[] arrTapChi = new TapChi[n];
			System.out.println("Hien thi danh sach tap chi");
			for (int i = 0; i < arrTapChi.length; i++) {
				TapChi.hienThiTapChi(arrTapChi[i]);
			}
	}
	private static void hienThiBao()
	{
		int n = sc.nextInt();
		Bao[] arrBao = new Bao[n];
		System.out.println("Hien thi danh sach bao");
		for (int i = 0; i < arrBao.length; i++) {
			Bao.hienThiBao(arrBao[i]);	
		}
	}

	private static void addSach()
	{
			//Sách, tạp chí, báo
			int n = sc.nextInt();
			System.out.println("Them moi sach");
			Sach[] arrSach = new Sach[n];
			for (int i = 0; i < arrSach.length; i++) {
				arrSach[i] = new Sach();
				System.out.println("Nhap thong tin sach thu: "+(i+1));
				Sach.nhapSach(arrSach[i]);
			}
	}
	private static void addTapChi()
	{
			int n = sc.nextInt();
			System.out.println("Them moi tap chi");
			TapChi[] arrTapChi = new TapChi[n];
			for (int i = 0; i < arrTapChi.length; i++) {
				arrTapChi[i] = new TapChi();
				System.out.println("Nhap thong tin tap chi: "+(i+1));
				TapChi.nhapTapChi(arrTapChi[i]);
			}
	}
	private static void addBao()
	{
			int n = sc.nextInt();
			System.out.println("Them moi bao");
			Bao[] arrBao = new Bao[n];
			for (int i = 0; i < arrBao.length; i++) {
				arrBao[i] = new Bao();
				System.out.println("Nhap thong tin bao thu: "+(i+1));
				Bao.nhapBao(arrBao[i]);
			}
	}
}
