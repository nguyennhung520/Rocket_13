package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.vti.backend.presentationlayer.AccountProjectController;
import com.vti.entity.Account;
import com.vti.ultis.ScannerUltis;

public class Function {
	private AccountProjectController accountProController;
	
	public Function() throws FileNotFoundException, IOException {
		super();
		accountProController = new AccountProjectController();
	}
	
	public void getLogin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào Password: ");
		String pass = ScannerUltis.inputPassword();
		if (accountProController.loginAccount(pass, email)) {
			System.out.println("Chào mừng " + email + " đăng nhập hệ thống :):):)");
			System.out.println();
			System.out.println();
		} else {
			System.out.println("Tài khoản không chính xác");
			return;
		}
	}

	public boolean findAccountofProID() {
		System.out.println("Nhap vao ProjectID can tim kiem: ");
		ArrayList<Account> accList = new ArrayList<Account>();
		for (Account account : accList) {
			if (account.equals(accList)) {
				return true;
			}
		}
		return false;
	}
	
	public void getAccountManager() {
		
	}
}
