package com.vti.entity;

import java.util.Scanner;

public class Sach extends TaiLieu{
	private String tenTacGia;
	private int soTrang;
	public Sach(String tenTacGia, int soTrang) {
		super();
		this.tenTacGia = tenTacGia;
		this.soTrang = soTrang;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sach(int maTL, String tenNXB, int soPhatHanh) {
		super(maTL, tenNXB, soPhatHanh);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sach [tenTacGia=" + tenTacGia + ", soTrang=" + soTrang + "]";
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public static void nhapSach(Sach sach)
	{
		nhapTaiLieu(sach);
		System.out.println("Nhap ten tac gia: ");
		sach.setTenTacGia(new Scanner(System.in).nextLine());
		System.out.println("Nhap so trang:");
		sach.setSoTrang(new Scanner(System.in).nextInt());
	}
	public static void hienThiSach(Sach sach)
	{
		hienThiTaiLieu(sach);
		System.out.println(sach.getTenTacGia() + sach.getSoTrang());
	}
}
