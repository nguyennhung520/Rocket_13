package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.DAO.AccountDao;
import com.vti.DAO.DepartmentDao;
import com.vti.DAO.PositionDao;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

public class Exercise2_Q8 {
	private AccountDao accountDao;

	public Exercise2_Q8() throws FileNotFoundException, IOException {
		super();
		accountDao = new AccountDao();
	}

	public void question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> listAcc1 = accountDao.getListAccounts();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		System.out.format("|ID | Email | Username | FullName | Department | Position | Create Date |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		for (Account account : listAcc1) {
			System.out.format(leftAlignFormat, account.getAccID(), account.getEmail(), account.getUserName(),
					account.getFullName(), account.getDepartment(), account.getPosition(), account.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
	}
	
	public void question2() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tim thong tin Account co ID = 5");
		Account account2 = accountDao.getAccountByID(5);
		if (account2 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format("+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format("|ID | Email | Username | FullName | Department | Position | Create Date |%n");
			System.out.format("+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(leftAlignFormat, account2.getAccID(), account2.getEmail(), account2.getUserName(), account2.getFullName(), account2.getDepartment(), account2.getPosition(), account2.getCreateDate());
			System.out.format("+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		} else {
			System.out.println("ID nay khong ton tai tren he thong!");
		}
	}
	
	public void question3() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tim kiem Account theo ID");
		System.out.println("Nhap ID can tim kiem: ");
		int idAccountFind = ScannerUltis.inputIntPositive();
		Account account3 = accountDao.getAccountByID(idAccountFind);
		if (account3 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format("+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format("|ID | Email | Username | FullName | Department | Position | Create Date |%n");
			System.out.format("+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(leftAlignFormat, account3.getAccID(), account3.getEmail(), account3.getUserName(), account3.getFullName(), account3.getDepartment(), account3.getPosition(), account3.getCreateDate());
			System.out.format("+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		} else {
			System.out.println("Khong ton tai phong nay tren the thong!");
		}
	}
	public void question4() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Kiem tra account da co tren he thong");
		System.out.println("Nhap vao ten can kiem tra: ");
		String nameCheck = ScannerUltis.inputString();
		boolean checkResutl = accountDao.isAccountNameExists(nameCheck);
		if (checkResutl) {
			System.out.println("Ten da co tren he thong");
			question1();
		} else {
			System.out.println("Ten khong ton tai tren he thong");
		}
	}
	
	public void question5() throws Exception {
		Account account5 = new Account();
		System.out.println("Nhap vao Email: ");
		account5.setEmail(ScannerUltis.inputString());;
		System.out.println("Nhap vao username: ");
		account5.setUserName(ScannerUltis.inputString());;
		System.out.println("Nhap vao fullname: ");
		account5.setFullName(ScannerUltis.inputString());;
		System.out.println("Chon phong ban nhan vien: ");
		int depId = getDepartment();
		System.out.println("Hay chon Possition cho nhan vien: ");
		int posId = getPosition();
		if (accountDao.createAccount(account5, depId, posId)) {
			System.out.println("Thanh cong");
			question1();
		} else {
			System.out.println("Khong thanh cong, xin hay kiem tra lai!");
		}
	}

	private int getPosition() throws ClassNotFoundException, Exception {
		while (true) {
			PositionDao posDao = new PositionDao();
			List<Position> lisPosition = posDao.getListPositions();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Position Name |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : lisPosition) {
				System.out.format(leftAlignFormat, position.getPosId(), position.getPosName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chon position theo ID: ");
			int choosePos = ScannerUltis.inputIntPositive();
			if (posDao.getPosByID(choosePos)!=null) {
				return choosePos;
			} else {
				System.out.println("Khong ton tai position tren he thong, hay chon lai: ");
			}
		}
	}

	private int getDepartment() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentDao depDao = new DepartmentDao();
			List<Department> listDep = depDao.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Depament Name |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getDepartmentId(), department.getDepartmentName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chon phong theo iD: ");
			int chooseDep = ScannerUltis.inputIntPositive();
			if (depDao.getDepByID(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Khong ton tai phong nay tren he thong, xin hay chon lai: ");
			}
			
		}
	}
	public void question6() throws Exception {
		while(true) {
			switch (getMenu6()) {
			case 1:
				int id = getIdCase1();
				System.out.println("Nhap vao new email: ");
				String newEmail = ScannerUltis.inputString();
				if (accountDao.upDateByEmail(id, newEmail)) {
					System.out.println("Update thanh cong");
					question1();
				} else {
					System.out.println("Update khong thanh cong, xin thu lai:  ");
				}
				break;
			case 2:
				int id2 = getIdCase1();
				System.out.println("Nhap vao username: ");
				String newUserName = ScannerUltis.inputString();
				if (accountDao.updateByUserName(id2, newUserName)) {
					System.out.println("Update thanh cong");
					question1();
				} else {
					System.out.println("Update khong thanh cong, xin thu lai: ");
				}
				break;
			case 3:
				int id3 = getIdCase1();
				System.out.println("Nhap vao full name: ");
				String newFullName = ScannerUltis.inputString();
				if (accountDao.upDateByFullName(id3, newFullName)) {
					System.out.println("Update thanh cong");
					question1();
				} else {
					System.out.println("Update khong thanh cong, xin thu lai: ");
				}
				break;
			case 4:
				int id4 = getIdCase1();
				int idDep = getnewIdDep();
				if (accountDao.upDateByDepartmentId(id4, idDep)) {
					System.out.println("Update thanh cong");
					question1();
				} else {
					System.out.println("Update khong thanh cong, xin hay nhap lai: ");
				}
				break;
			case 5:
				int id5 = getIdCase1();
				int idPos = getNewIdPos();
				if (accountDao.upDateByPosistionId(id5, idPos)) {
					System.out.println("Update thanh cong");
					question1();
				} else {
					System.out.println("Update khong thanh cong, xin hay thu lai: ");
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Sai!");
				break;
			}
		}
	}

	private int getNewIdPos() throws Exception {
		DepartmentDao depDao = new DepartmentDao();
		System.out.println("Chon Position: ");
		while (true) {
			PositionDao posDao = new PositionDao();
			List<Position> listPos = posDao.getListPositions();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Position Name |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listPos) {
				System.out.format(leftAlignFormat, position.getPosId(), position.getPosName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chon Id cua position can update: ");
			int id = ScannerUltis.inputIntPositive();
			if (posDao.getPosByID(id)!= null) {
				return id;
			} else {
				System.out.println("Khong ton tai tren he thong, xin hay nhap lai: ");
			}
		}
	}

	private int getnewIdDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentDao depDao = new DepartmentDao();
		System.out.println("Chhon phong: ");
		while (true) {
			List<Department> listDep = depDao.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Depament Name |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getDepartmentId(), department.getDepartmentName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chon id cau phong can update: ");
			int id = ScannerUltis.inputIntPositive();
			if (depDao.getDepByID(id)!= null) {
				return id;
			} else {
				System.out.println("Khong ton tai tren he thong xin thu lai: ");
			}
		}
		
	}

	private int getIdCase1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			System.out.println("Nhap va0 id cua account can update: ");
			int id = ScannerUltis.inputIntPositive();
			if (accountDao.getAccountByID(id) != null) {
				return id;
			} else {
				System.out.println("Khong ton tai, xin hay thu lai: ");
			}
		}
	
	}

	private int getMenu6() {
		while (true) {
			System.out.println("Chon truong muon uapdate: ");
			System.out.println("1. Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 0.Exit");
			int i = ScannerUltis.inputIntPositive();
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 0) {
				return i;
			}else {
				System.out.println("Chon lai: ");
			}
		}
		
	}
	public void question7() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		int id = getIdQ7();
		if (accountDao.delAccountById(id)) {
			System.out.println("Xoa thanh cong");
			question7();
		} else {
			System.out.println("Loi!");
		}
	}

	private int getIdQ7() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			System.out.println("Nhap vao ID Account can xoa: ");
			int id = ScannerUltis.inputIntPositive();
			if (accountDao.getAccountByID(id)!=null) {
				return id;
			} else {
				System.out.println("Khong ton tai trn HT, xin nhap lai: ");
			}
		}
		
	}
}
