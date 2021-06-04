package com.vti.frontend;

import com.vti.ultis.FileUltis;
import com.vti.ultis.ScannerUltis;

public class Exercise3_File_Ques1 {
	public static void main(String[] args) throws Exception {
		
		checkFileIsExists();
		createNewFile();
		deleteFile();
		checkPathIsFileOrFloder();
		getAllFile();
		copyFile();
		movingFile();
		renameFile();
		createNewFloder();
		downloadFile();
	}

	private static void downloadFile() {
		// TODO Auto-generated method stub
		// random
		// if(FileUltis.isFolderOrFile == null)
		//		FileUltis.createNewFloder()
		// else 
		//     FileUltis.createNewFloder() +..random
	}

	private static void createNewFloder() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao duong dan folder moi: ");
		String path = ScannerUltis.inputString();
		FileUltis.createNewFolder(path);
	}

	private static void renameFile() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao duong dan file can rename: ");
		String pathNameOld = ScannerUltis.inputString();
		System.out.println("Nhap vao duong dan file doi ten moi: ");
		String pathNameNew = ScannerUltis.inputString();
		FileUltis.renameFile(pathNameOld, pathNameNew);
	}

	private static void movingFile() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao duong dan file can doi: ");
		String pathFileOld = ScannerUltis.inputString();
		if(FileUltis.isFolder(pathFileOld)) {
			System.out.println("File khong ton tai!");
		}else {
			System.out.println("Nhap vao duong dan file can move toi: ");
			String pathFileNew = ScannerUltis.inputString();
			FileUltis.moveFile(pathFileOld, pathFileNew);
			FileUltis.deleteFile(pathFileOld);
		}
	}

	private static void copyFile() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao duong dan file: ");
		String path = ScannerUltis.inputString();
		if(FileUltis.isFileExists(path)) {
			System.out.println("File chua ton tai");
		}else {
			System.out.println("File da ton tai!!");
			FileUltis.copyFile(path, path);
		}
	}

	private static void getAllFile() {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao duong dan folder: ");
		String path = ScannerUltis.inputString();
		String[] fileStrings = FileUltis.getAllFileName(path);
		for (String string : fileStrings) {
			System.out.println(string);
		}
	}

	private static void checkPathIsFileOrFloder() {
		// TODO Auto-generated method stub
		// Question5: check path co the la file hay Folder
		System.out.println("Check path is file or folder");
		System.out.println("Nhap vao tat ca dong dan: ");
		String path2 = ScannerUltis.inputString();
		FileUltis.isFolderOrFile(path2);
	}

	private static void deleteFile() throws Exception {
		// TODO Auto-generated method stub
		//Question 4: delete file
		System.out.println("Xoa 1 file moi, chu y nhap ca duong dan: ");
		String path = ScannerUltis.inputString();
		if(FileUltis.isFolder(path)) {
			System.out.println("File ton tai tren he thong!");
			FileUltis.deleteFile(path);
		}else {
			System.out.println("File khong ton tai tren he thong!");
			
		}
		
	}

	private static void createNewFile() throws Exception {
		// TODO Auto-generated method stub
		// Question 2: create new file
		System.out.println("Tao file moi, chu y nhap tat ca duong dan file: ");
		String path1 = ScannerUltis.inputString();
		if(FileUltis.isFolder(path1)) {
			System.out.println("File chua ton tai he thong!!.Moi ban tao file moi");
			FileUltis.createNewFile(path1);
		}else {
			System.out.println("File da ton tai tren he thong!");
			
		}
	}

	private static void checkFileIsExists() {
//		 TODO Auto-generated method stub
//		 Question 1: Check file is exists
		System.out.println("Nhap vao tat ca duong dan file: ");
		String path = ScannerUltis.inputString();
		if(FileUltis.isFolder(path)) {
			System.out.println("File da ton toi tren he thong.");
		}else {
			System.out.println("File khong ton tai tren he thong!!");
		}
		
	}
}
