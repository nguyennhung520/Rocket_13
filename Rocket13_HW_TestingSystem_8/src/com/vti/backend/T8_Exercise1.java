package com.vti.backend;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class T8_Exercise1 {
	private java.util.List<Student> listStudent;
	
	public void Exercise1() {
		listStudent = new ArrayList<Student>();
		System.out.println("Nhap vao so sinh vien muon them: ");
		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num - 3; i++) {
			Student st = new Student("Student: "+(i+1));
			listStudent.add(st);
		}
		Student st1 = new Student("Nguyen Van A");
		Student st2 = new Student("Nguyen Van B");
		Student st3 = new Student("Nguyen Van C");
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);
	}
	public void question1() {
		loadMenu();
		while(true) {
			loadMenu();
			int menuChoose = ScannerUltis.inputInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Tong so cac sinh vien la: "+listStudent.size());
				printStudent();
				break;
			case 2:
				System.out.println("Phan tu thu 4 la: "+listStudent.get(3));
				break;
			case 3:
				System.out.println("Phan tu dau la: "+listStudent.get(0));
				System.out.println("Phan tu cuoi la: "+listStudent.get(listStudent.size() - 1));
				break;
			case 4:
				int chooseCase4 = chooseSubMenu4();
				switch (chooseCase4) {
				case 1:
					System.out.println("Nhap ten sinh vien: ");
					String name = ScannerUltis.inputString();
					listStudent.add(0, new Student(name));
					printStudent();
					break;
				case 2:
					System.out.println("Nhap ten sinh vien: ");
					String name1 = ScannerUltis.inputString();
					listStudent.add(new Student(name1));
					printStudent();
					break;
				default:
					System.out.println("SAI SAI ROI! NHAP LAI: ");
					break;
				}
					break;
			case 5:
				System.out.println("Nhap ten sinh vien can them: ");
				String name3 = ScannerUltis.inputString();
				listStudent.add(new Student(name3));
				printStudent();
				break;
			case 6:
				Collections.reverse(listStudent);
				System.out.println("Da Dao nguoc vi tri: ");
				printStudent();
			case 7:
				System.out.println("Nhap vao ID can tim kiem: ");
				int id1 = ScannerUltis.inputIntPositive();
				for (Student student : listStudent) {
					if(student.getStudentId() == id1) {
						System.out.println(student);
					}
				}
				break;
			case 8:
				System.out.println("Nhap vao ten can tim kiem: ");
				String name4 = ScannerUltis.inputString();
				for (Student student : listStudent) {
					if (student.getStudentName().equals(name4)) {
						System.out.println(student);
					}
				}
				break;
			case 9:
				System.out.println("Cac sinh vien trung ten: ");
				for (int i = 0; i < listStudent.size(); i++) {
					for (int j = 0; j < listStudent.size(); j++) {
						if (listStudent.get(i).getStudentName().equals(listStudent.get(j).getStudentName())) {
							System.out.println(listStudent.get(i).toString());
						}
					}
				}
				break;
			case 10:
				System.out.println("Nhap vao Id can xoa ten: ");
				int id10 = ScannerUltis.inputIntPositive();
				Iterator<Student> it = listStudent.iterator();
				while(it.hasNext()) {
					Student student = it.next();
					if(student.getStudentId() == id10 ) {
						student.setStudentId(id10);
					}
					printStudent();
				}
				break;
			case 11:
				System.out.println("Nhap vao ten can xoa: ");
				String name11 = ScannerUltis.inputString();
				Iterator<Student> it11 = listStudent.iterator();
				while (it11.hasNext()) {
					Student student11 = it11.next();
					if(student11.getStudentName() == name11) {
						student11.setStudentName(name11);
					}
					printStudent();
				}
				break;
			case 12:
				System.out.println("Tao moi ArryCopy: ");
				java.util.List<Student> arrayCopy = new ArrayList<Student>();
				arrayCopy.addAll(listStudent);
				System.out.println("In phan tu trong ArrayCopy: ");
				for (Student student : arrayCopy) {
					System.out.println(student);
				}
				break;
			case 13:
				return;
			default:
				System.out.println("NAO NAO CHU Y! NHAP DUNG!!");
				break;
			}
		}
	}
	private int chooseSubMenu4() {
		System.out.println("Nao lua chon 1.Them vao dao, 2.Them vao cuoi");
		while (true) {
			int choose1 = ScannerUltis.inputIntPositive();
			switch (choose1) {
			case 1:
				return choose1;
			case 2:
				return choose1;
			default:
				System.out.println("SAI SAI! CHON LAI NAO!!: ");
				break;
			}
		}
	}
	private void printStudent() {
		
		for (Student student : listStudent) {
			System.out.println(student);
		}
	}
	private void loadMenu() {
		
		System.out.println("--- 			Lựa chọn chức năng muốn sử dụng 		   ---");
		System.out.println("--- 1.In ra tổng số phần tử của students ---------------------");
		System.out.println("--- 2.Lấy phần tử thứ 4 của students -------------------------");
		System.out.println("--- 3.In ra phần tử đầu và phần tử cuối của students ---------");
		System.out.println("--- 4.Thêm 1 phần tử vào vị trí đầu hoặc cuối của students ---");
		System.out.println("--- 5.Thêm 1 phần tử vào vị trí cuối của students ------------");
		System.out.println("--- 6.Đảo ngược vị trí của students --------------------------");
		System.out.println("--- 7.Tạo 1 method tìm kiếm student theo id ------------------");
		System.out.println("--- 8.Tạo 1 method tìm kiếm student theo name ----------------");
		System.out.println("--- 9.Tạo 1 method để in ra các student có trùng tên ---------");
		System.out.println("--- 10.Xóa name của student có id = 2 ------------------------");
		System.out.println("--- 11.Delete student có id = 5 ------------------------------");
		System.out.println("--- 12.Tạo 1 ArrayList tên là studentCopies và "
							+ "add tất cả students vào studentCopies ---------------------");
		System.out.println("--- 				13. Exit 							  ----");
	}
}
