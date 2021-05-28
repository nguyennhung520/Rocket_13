package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Article;
import com.vti.entity.Book;
import com.vti.entity.Document;
import com.vti.entity.Magazine;

public class Question4 {
	public static int ID = 0;
	private Scanner sc;
	private ArrayList<Document> documentList;
	public void question4(){
		sc = new Scanner(System.in);
		documentList = new ArrayList<Document>();
	}
	public void qLDocument()
	{
		while (true) {
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("=== 			1. Thêm mới tài liệu. 							   ===");
			System.out.println("=== 			2. Xoá tài liệu theo mã tài liệu. 				   ===");
			System.out.println("=== 			3. Hiện thị thông tin về danh sách các tài liệu.   ===");
			System.out.println("=== 			4. Tìm kiếm tài liệu theo loại: Sách, tập chí, báo ===");
			System.out.println("=== 			5. Thoát khỏi chương trình. 					   ===");
			System.out.println("======================================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Mời bạn thêm tài liệu");
				addDocument();
				break;
			case 2:
				findDocument();
				break;
			case 3:
				printListDocument();
				break;
			case 4:
				deleteById();
				break;
			case 5:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}
	private void findDocument() {
		// TODO Auto-generated method stub
		System.out.println("Nhập vào loại tài liệu cần tìm kiếm 1.Sách, 2.Báo, 3.Tạp chí: ");
		int chooseCategory = sc.nextInt();
		switch (chooseCategory) {
		case 1:
			for (Document document : documentList) {
				if (document instanceof Book) {
					System.out.println(document);
				}
			}
			break;
		case 2:
			for (Document document : documentList) {
				if (document instanceof Article) {
					System.out.println(document);
				}
			}
			break;
		case 3:
			for (Document document : documentList) {
				if (document instanceof Magazine) {
					System.out.println(document);
				}
			}
			break;
		default:
			System.out.println("Nhập không đúng.!!");
			break;
		}
	}

	private void printListDocument() {
		// TODO Auto-generated method stub
		for (Document document : documentList) {
			System.out.println(document);
		}
	}
	private void deleteById() {
		// TODO Auto-generated method stub
		System.out.println("Nhập vào mã tài liệu muốn xóa: ");
		int idDel = sc.nextInt();
		Boolean flagCheckExists = false;
		for (Document document : documentList) {
			if (document.getId() == idDel) {
				flagCheckExists = true;
			}
		}
		if (flagCheckExists) {
			documentList.removeIf(doc -> doc.getId() == idDel);
			for (Document document : documentList) {
				System.out.println("Xóa tài liệu thành công, danh sách tài liệu còn lại:");
				System.out.println(document);
			}
		} else {
			System.out.println("Mã tài liệu bạn nhập không có trên hệ thống.");

		}
	}
	private void addDocument() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------");
		System.out.println("--------Lựa chọn chức năng bạn muốn sử dụng---------");
		System.out.println("--- 	1. Thêm báo 						 	 ---");
		System.out.println("--- 	2. Thêm sách 						     ---");
		System.out.println("--- 	3. Thêm tạp chí						 	 ---");
		System.out.println("----------------------------------------------------");
		int choose1 = sc.nextInt();
		switch (choose1) {
		case 1:
			System.out.println("Nhập vào tên nhà xuất bản: ");
			String publisherArticle = sc.nextLine();
			System.out.println("Nhập vào số bản phát hành: ");
			int numReleaseArticle = sc.nextInt();
			System.out.println("Nhập vào ngày phát hành: ");
			int day = sc.nextInt();
			System.out.println("Nhập vào tháng phát hành: ");
			int month = sc.nextInt();
			System.out.println("Nhập vào năm phát hành: ");
			int year = sc.nextInt();
			LocalDate dayReleaseArticle = LocalDate.of(year, month, 
			day);
			ID++;
			Document artice = new Article(ID, publisherArticle, 
			numReleaseArticle, dayReleaseArticle);
			documentList.add(artice);
			break;
		case 2:
			System.out.println("Nhập vào tên nhà xuất bản: ");
			String publisher = sc.nextLine();
			System.out.println("Nhập vào số bản phát hành: ");
			int numRelease = sc.nextInt();
			System.out.println("Nhập vào tên tác giả: ");
			String authorName = sc.next();
			System.out.println("Nhập vào số trang: ");
			int numPage = sc.nextInt();
			ID++;
			Document book = new Book(ID, publisher, numRelease, 
			authorName, numPage);
			documentList.add(book);
			break;
		case 3:
			System.out.println("Nhập vào tên nhà xuất bản: ");
			String publisherMagazine = sc.nextLine();
			System.out.println("Nhập vào số bản phát hành: ");
			int numReleaseMagazine = sc.nextInt();
			System.out.println("Nhập vào số phát hành: ");
			int idReleaseMagazine = sc.nextInt();
			System.out.println("Nhập vào ngày phát hành: ");
			int day1 = sc.nextInt();
			System.out.println("Nhập vào tháng phát hành: ");
			int month1 = sc.nextInt();
			System.out.println("Nhập vào năm phát hành: ");
			int year1 = sc.nextInt();
			LocalDate monthReleaseMagazine = LocalDate.of(year1, month1, 
			day1);
			ID++;
			Document magazine = new Magazine(ID, publisherMagazine, 
			numReleaseMagazine, idReleaseMagazine,
			monthReleaseMagazine);
			documentList.add(magazine);
			break;
		default:
			System.out.println("Nhập sai dữ liệu");
			break;
		}
	}
}
