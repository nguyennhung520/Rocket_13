package com.vti.entity;

public class KySu extends CanBo{
	private String nganhDaoTao;

	

	public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.nganhDaoTao = nganhDaoTao;
	}

	public KySu() {
		// TODO Auto-generated constructor stub
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	@Override
	public String toString() {
		return "KySu [nganhDaoTao=" + nganhDaoTao + "]";
	}
	public static void nhapKySu(KySu kySu)
	{
		kySu.nhapCanBo(kySu);
		System.out.println("Nganh đao tao: ");
	}
	public static void xuatKySu(KySu kySu)
	{
		kySu.xuatCanBo(kySu);
		System.out.println(kySu.getNganhDaoTao());
	}
	
}
