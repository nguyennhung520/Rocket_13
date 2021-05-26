package com.vti.entity;

import java.util.Scanner;

public class Bao extends TaiLieu{
	private int ngayPhatHanh;

	public Bao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bao(int maTL, String tenNXB, int soPhatHanh) {
		super(maTL, tenNXB, soPhatHanh);
		// TODO Auto-generated constructor stub
	}

	public Bao(int ngayPhatHanh) {
		super();
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public String toString() {
		return "Bao [ngayPhatHanh=" + ngayPhatHanh + "]";
	}

	public int getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(int ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}
	public static void nhapBao(Bao bao)
	{
		nhapTaiLieu(bao);
		System.out.println("Nhap ngay phat hanh: ");
		bao.setNgayPhatHanh(new Scanner(System.in).nextInt());
	}
	public static void hienThiBao(Bao bao)
	{
		hienThiTaiLieu(bao);
		System.out.println(bao.getNgayPhatHanh());
	}
}
