package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;

public class Ex5_Staff {

	private static ArrayList<CanBo> cbList = new ArrayList<CanBo>();
	private static Scanner sc=new Scanner(System.in);;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		question2();
	}
	private static void question2() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("======================================================================");
			System.out.println("--------------Lựa chọn chức năng bạn muốn sử dụng---------------------");
			System.out.println("===           1. Thêm mới cán bộ.                                  ===");
			System.out.println("===           2. Tìm kiếm theo họ tên.                             ===");
			System.out.println("===           3. Hiển thị thông tin và danh sách cán bộ.           ===");
			System.out.println("===           4. Nhập vào tên của cán bộ và delete cán bộ đó.      ===");
			System.out.println("===           5. Thoát khỏi chương trình.                          ===");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Thêm mới cán bộ: ");
				int menuchoose3 = sc.nextInt();
				switch (menuchoose3) {
				case 1:
					addCongNhan();
					break;
				case 2:
					addKySu();
				case 3:
					addNhanVien();
				default:
					System.out.println("Nhap sai du lieu!");
					break;
				}
				break;
			case 2:
				System.out.println("Tìm kiếm theo tên");
				searchFullName();
				break;
			case 3:
				System.out.println("Hiển thị thông tin về danh sách cán bộ");
				int menuchoose2 = sc.nextInt();
				switch (menuchoose2) {
				case 1:
					listCongNhan();
					break;
				case 2:
					listKySu();
					break;
				case 3:
					listNhanVien();
				default:
					System.out.println("Nhap sai du lieu");
					break;
				}
				break;
			case 4:
				System.out.println("Nhập vào tên của cán bộ và delete cán bộ");
				deleteCanBoOfName();
				break;
			case 5:
				return;
			default:
				System.out.println("Nhập sai dữ liệu!");
				break;
			}
		}
	}

	private static void addCongNhan() {
		// TODO Auto-generated method stub
		CongNhan congNhan = new CongNhan();
		System.out.print("Nhap ho ten: ");
		congNhan.setHoTen(new Scanner(System.in).nextLine());
		System.out.print("Nhap tuoi: ");
		congNhan.setTuoi(new Scanner(System.in).nextInt());
		System.out.print("Nhap dia chi: ");
		congNhan.setDiaChi(new Scanner(System.in).nextLine());
		System.out.print("Nhap gioi tinh: ");
		congNhan.setGioiTinh(new Scanner(System.in).nextLine());
		System.out.print("Nhap cap bac: ");
		congNhan.setBac(new Scanner(System.in).nextInt());
		System.out.println(congNhan.getHoTen() + " "+congNhan.getTuoi() +" " +congNhan.getDiaChi() + 
				" "+congNhan.getGioiTinh() +" "+ congNhan.getBac());
		congNhan.addCanBo(congNhan);
	}
	private static void addNhanVien() {
		// TODO Auto-generated method stub
		NhanVien nhanVien = new NhanVien();
		System.out.print("Nhap ho ten: ");
		nhanVien.setHoTen(new Scanner(System.in).nextLine());
		System.out.print("Nhap tuoi: ");
		nhanVien.setTuoi(new Scanner(System.in).nextInt());
		System.out.print("Nhap dia chi: ");
		nhanVien.setDiaChi(new Scanner(System.in).nextLine());
		System.out.print("Nhap gioi tinh: ");
		nhanVien.setGioiTinh(new Scanner(System.in).nextLine());
		System.out.println("Nhap cong viec nhan vien: ");
		nhanVien.setCongViec(new Scanner(System.in).nextLine());
		nhanVien.addCanBo(nhanVien);
		System.out.println(nhanVien.getHoTen() + " "+nhanVien.getTuoi() +" " +nhanVien.getDiaChi() + 
				" "+nhanVien.getGioiTinh() +" "+ nhanVien.getCongViec());
	}
	private static void addKySu() {
		// TODO Auto-generated method stub
		KySu kySu = new KySu();
		System.out.print("Nhap ho ten: ");
		kySu.setHoTen(new Scanner(System.in).nextLine());
		System.out.print("Nhap tuoi: ");
		kySu.setTuoi(new Scanner(System.in).nextInt());
		System.out.print("Nhap dia chi: ");
		kySu.setDiaChi(new Scanner(System.in).nextLine());
		System.out.print("Nhap gioi tinh: ");
		kySu.setGioiTinh(new Scanner(System.in).nextLine());
		System.out.println("Nhap nganh dao tao: ");
		kySu.setNganhDaoTao(new Scanner(System.in).nextLine());
		kySu.addCanBo(kySu);
		System.out.println(kySu.getHoTen() + " "+kySu.getTuoi() +" " +kySu.getDiaChi() + 
				" "+kySu.getGioiTinh() +" "+ kySu.getNganhDaoTao());
	}
	private static void searchFullName() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ten can bo can tim kiem: ");
		String hoTen = sc.nextLine();
		System.out.println(cbList.contains(hoTen));
	}

	private static void listCongNhan()
	{
		int j = sc.nextInt();
			CongNhan[] arrCN = new CongNhan[j];
			System.out.println("Danh sach cong nhan");
			for (int i = 0; i < arrCN.length; i++) {
				CongNhan.xuatCongNhan(arrCN[i]);
			}
	}
	private static void listKySu()
	{
		int j = sc.nextInt();
			KySu[] arrKS = new KySu[j];
			System.out.println("Danh sach ky su");
			for (int i = 0; i < arrKS.length; i++) {
				KySu.xuatKySu(arrKS[j]);
			}
	}
	private static void listNhanVien()
	{
		int j = sc.nextInt();
			NhanVien[] arrNV = new NhanVien[j];
			System.out.println("Danh sach nhan vien");
			for (int i = 0; i < arrNV.length; i++) {
				NhanVien.xuatNhanVien(arrNV[i]);
			}
	}
	private static void deleteCanBoOfName() {
		// TODO Auto-generated method stub
		System.out.println("Nhap ten can bo can xoa: ");
		String hoTen = sc.nextLine();
		cbList.removeAll(cbList);
		System.out.println("Danh sach can bo: "+cbList.toString());
	}
}
