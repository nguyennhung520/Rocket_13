package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.DAO.DepartmentDao;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Exercise2_1 {
	private DepartmentDao depDao;

	public Exercise2_1() throws FileNotFoundException, IOException {
		super();
		depDao = new DepartmentDao();
	}

	public void question1() throws ClassNotFoundException, SQLException {
		List<Department> listDep = depDao.getListDepartment();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep) {
			System.out.format(leftAlignFormat, department.getDepartmentId(), department.getDepartmentName());
		}
		System.out.format("+--------+-----------------------+%n");
	}
	
	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("Truy tim thong tin co ID = 5");
		Department depQuestion2 = depDao.getDepByID(5);
		if(depQuestion2 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, depQuestion2.getDepartmentId(), depQuestion2.getDepartmentName());
			System.out.format("+--------+-----------------------+%n");
		}else {
			System.out.println("ID khong ton tai tren he thong");
		}
	}
	
	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tim kiem phong ban theo ID: ");
		System.out.println("Nhap vao id phong ban can tim kiem nao: ");
		int idFindbyDep = ScannerUltis.inputIntPositive();
		Department depQues3 = depDao.getDepByID(idFindbyDep);
		if (depQues3 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, depQues3.getDepartmentId(), depQues3.getDepartmentName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("ID ban can tim kiem khong co tren he thong!");
		}
	}
	
	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Kiem tra ten phong ban tren he thong");
		System.out.println("Nhap vao ten phong ban: ");
		String departmentCheck = ScannerUltis.inputString();
		Boolean checkResult = depDao.getDepByName(departmentCheck);
		if(checkResult) {
			System.out.println("Ten Ton tai tren he thong");
			question1();
		}else {
			System.out.println("Ten chua Ton tai tren he thong!");
		}
	}
	public void question5() throws ClassNotFoundException, SQLException {
		String newDepName = getNewDepartmentName();
		if(depDao.createDepartment(newDepName)) {
			System.out.println("Tao thanh cong ten phong ban");
			question1();
		}else {
			System.out.println("Loi!");
		}
	}

	private String getNewDepartmentName() throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.println("Nhap ten phong can tao: ");
			String newDepartmentName = ScannerUltis.inputString();
			if(depDao.getDepByName(newDepartmentName)) {
				System.out.println("Da ton tai ten phong tren he thong");
			}else {
				return newDepartmentName;
			}
		}
	}
	public void question6() throws ClassNotFoundException, SQLException {
		question1();
		int updateDepartmentID = getDepartmentIdUpdate();
		System.out.println("Nhap vao ten can update tren he thong: ");
		String newDepName = ScannerUltis.inputString();
		if(depDao.updateDepartmentName(updateDepartmentID, newDepName)) {
			System.out.println("Thanh cong");
			question1();
		}else {
			System.out.println("Loi!");
		}
	}

	private int getDepartmentIdUpdate() throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.println("Nhap ID phong can xoa: ");
			int depID = ScannerUltis.inputIntPositive();
			Department dep = depDao.getDepByID(depID);
			if(dep != null) {
				return depID;
			}else {
				System.out.println("Khong ton tai ID tren he thong!");
			}
		}
	}
	public void question7() throws ClassNotFoundException, SQLException {
		question1();
		int updateDepID = getDepartmentIdUpdate();
		if(depDao.delDepartmentID(updateDepID)) {
			System.out.println("Xao thanh cong");
			question1();
		}else {
			System.out.println("Da co loi xay ra");
		}
	}
}
