package com.vti.entity;

import java.util.Scanner;

public class TapChi extends TaiLieu{
	private int soTPhatHanh;
	private int thangPhatHanh;
	public TapChi(int soTPhatHanh, int thangPhatHanh) {
		super();
		this.soTPhatHanh = soTPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
	}
	public TapChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TapChi(int maTL, String tenNXB, int soPhatHanh) {
		super(maTL, tenNXB, soPhatHanh);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TapChi [soTPhatHanh=" + soTPhatHanh + ", thangPhatHanh=" + thangPhatHanh + "]";
	}
	public int getSoTPhatHanh() {
		return soTPhatHanh;
	}
	public void setSoTPhatHanh(int soTPhatHanh) {
		this.soTPhatHanh = soTPhatHanh;
	}
	public int getThangPhatHanh() {
		return thangPhatHanh;
	}
	public void setThangPhatHanh(int thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}
	public static void nhapTapChi(TapChi tapChi)
	{
		nhapTaiLieu(tapChi);
		System.out.println("So phat hanh: ");
		tapChi.setSoTPhatHanh(new Scanner(System.in).nextInt());
		System.out.println("Thang phat hanh: ");
		tapChi.setThangPhatHanh(new Scanner(System.in).nextInt());
	}
	public static void hienThiTapChi(TapChi tapChi)
	{
		hienThiTaiLieu(tapChi);
		System.out.println(tapChi.getSoTPhatHanh() + tapChi.getThangPhatHanh());
	}
}
