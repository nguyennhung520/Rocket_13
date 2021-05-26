package com.vti.entity;

public class NhanVien extends CanBo{
	private String congViec;

	

	public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return "NhanVien [congViec=" + congViec + "]";
	}
	public static void nhapNhanVien(NhanVien nhanVien)
	{
		nhanVien.nhapCanBo(nhanVien);
		System.out.println("Cong viec: ");
	}
	public static void xuatNhanVien(NhanVien nhanVien)
	{
		nhanVien.xuatCanBo(nhanVien);
		System.out.println(nhanVien.getCongViec());
	}
}
