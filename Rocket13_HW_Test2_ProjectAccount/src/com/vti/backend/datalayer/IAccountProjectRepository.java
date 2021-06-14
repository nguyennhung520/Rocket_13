package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountProjectRepository {
	public boolean isAccNameExists(String email) throws ClassNotFoundException, SQLException;
	public boolean loginAccount(String password, String email) throws ClassNotFoundException, SQLException;
	public boolean findAccountByID(int id) throws ClassNotFoundException, SQLException;
	public List<Account> getListAccount() throws ClassNotFoundException, SQLException;
	
}
