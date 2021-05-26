package com.vti.entity;

import java.util.Scanner;

public class CongNhan extends CanBo{

	private int bac;
	
	@Override
	public String toString() {
		return "CongNhan [bac=" + bac + "]";
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	
	public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.bac = bac;
	}

	public CongNhan()
	{
		super();
	}
	public static void nhapCongNhan(CongNhan congNhan)
	{
		nhapCanBo(congNhan);
		System.out.println("Nhap cap bac: ");
		congNhan.setBac(new Scanner(System.in).nextInt());
	}
	public static void xuatCongNhan(CongNhan congNhan)
	{
		xuatCanBo(congNhan);
		System.out.println(congNhan.getBac());
	}
}
