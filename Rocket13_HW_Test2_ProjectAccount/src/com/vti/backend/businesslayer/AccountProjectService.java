package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountProjectRepository;
import com.vti.backend.datalayer.IAccountProjectRepository;
import com.vti.entity.Account;
import com.vti.entity.Account.Staff;

public class AccountProjectService implements IAccountProjectService{
	private IAccountProjectRepository accountProRepos;

	public AccountProjectService() throws FileNotFoundException, IOException {
		super();
		accountProRepos = new AccountProjectRepository();
	}

	@Override
	public boolean isAccNameExists(String email) throws ClassNotFoundException, SQLException {
		return accountProRepos.isAccNameExists(email);
	}

	@Override
	public boolean loginAccount(String password, String email) throws ClassNotFoundException, SQLException {
		return accountProRepos.loginAccount(password, email);
	}

	@Override
	public boolean findAccountByID(int id) throws ClassNotFoundException, SQLException {
		return accountProRepos.findAccountByID(id);
	}

	@Override
	public List<Account> getListAccount() throws ClassNotFoundException, SQLException {
		return accountProRepos.getListAccount();
	}
	
}
