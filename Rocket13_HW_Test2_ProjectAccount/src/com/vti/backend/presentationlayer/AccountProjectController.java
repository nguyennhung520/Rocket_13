package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountProjectService;
import com.vti.backend.businesslayer.IAccountProjectService;
import com.vti.entity.Account;
import com.vti.entity.Account.Staff;

public class AccountProjectController {

	private IAccountProjectService accountProjSer;

	public AccountProjectController() throws FileNotFoundException, IOException {
		super();
		accountProjSer = new AccountProjectService();
	}
	
	public boolean isAccNameExists(String email) throws ClassNotFoundException, SQLException {
		return accountProjSer.isAccNameExists(email);
	}

	public boolean loginAccount(String password, String email) throws ClassNotFoundException, SQLException {
		return accountProjSer.loginAccount(password, email);
	}

	public boolean findAccountByID(int id) throws ClassNotFoundException, SQLException {
		return accountProjSer.findAccountByID(id);
	}

	public List<Account> getListAccount(int ProjectId, String PrjectName, int teamSize, String FullName, String Email,
			String Password, Staff staff) throws ClassNotFoundException, SQLException {
		return accountProjSer.getListAccount();
	}
}
