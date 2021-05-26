package com.vti.entity;

import java.util.Scanner;

public class CanBo {
	private String hoTen;
	private int tuoi;
	private String gioiTinh;
	private String diaChi;
	public CanBo(String hoTen, int tuoi, String gioiTinh, String diaChi) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "CanBo [hoTen=" + hoTen + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public CanBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addCanBo(CanBo canBo)
	{
		this.addCanBo(canBo);
	}
	public static void nhapCanBo(CanBo canBo)
	{
		System.out.print("Nhap ho ten: ");
		canBo.setHoTen(new Scanner(System.in).nextLine());
		System.out.print("Nhap tuoi: ");
		canBo.setTuoi(new Scanner(System.in).nextInt());
		System.out.print("Nhap dia chi");
		canBo.setDiaChi(new Scanner(System.in).nextLine());
		System.out.print("Nhap gioi tinh: ");
		canBo.setGioiTinh(new Scanner(System.in).nextLine());
	}
	public static void xuatCanBo(CanBo canBo)
	{
		System.out.println(canBo.getHoTen()+" "+canBo.getTuoi()+" "+canBo.getDiaChi()+" "+canBo.getGioiTinh());
	}
}
