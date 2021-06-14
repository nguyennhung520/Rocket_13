package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Account.Staff;

public interface IAccountProjectService {
	public boolean isAccNameExists(String email) throws ClassNotFoundException, SQLException;
	public boolean loginAccount(String password, String email) throws ClassNotFoundException, SQLException;
	public boolean findAccountByID(int id) throws ClassNotFoundException, SQLException;
	public List<Account> getListAccount() throws ClassNotFoundException, SQLException;
}
