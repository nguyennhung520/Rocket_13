package com.vti.entity;

import java.util.Scanner;

public class TaiLieu {
	private int maTL;
	private String tenNXB;
	private int soPhatHanh;
	
	public int getMaTL() {
		return maTL;
	}

	public void setMaTL(int maTL) {
		this.maTL = maTL;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	@Override
	public String toString() {
		return "TaiLieu [maTL=" + maTL + ", tenNXB=" + tenNXB + ", soPhatHanh=" + soPhatHanh + "]";
	}

	public TaiLieu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiLieu(int maTL, String tenNXB, int soPhatHanh) {
		super();
		this.maTL = maTL;
		this.tenNXB = tenNXB;
		this.soPhatHanh = soPhatHanh;
	}
	public static void nhapTaiLieu(TaiLieu taiLieu)
	{
		System.out.println("Nhap ma tai lieu: ");
		taiLieu.setMaTL(new Scanner(System.in).nextInt());
		System.out.println("Nhap ten NXB: ");
		taiLieu.setTenNXB(new Scanner(System.in).nextLine());
		System.out.println("Nhap so ban phat hanh: ");
		taiLieu.setSoPhatHanh(new Scanner(System.in).nextInt());
	}
	public static void hienThiTaiLieu(TaiLieu taiLieu)
	{
		System.out.println(taiLieu.getMaTL() + taiLieu.getTenNXB() + taiLieu.getSoPhatHanh());
	}
}
