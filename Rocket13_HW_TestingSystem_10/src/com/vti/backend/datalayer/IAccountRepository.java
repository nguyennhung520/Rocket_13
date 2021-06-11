package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	public Account getAccountById(int accountId) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	public boolean isAccountNameExists(String accountName) throws ClassNotFoundException, SQLException;
	public boolean isAccountIdExists(int aaccountId) throws ClassNotFoundException, SQLException;
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException;
	public boolean delAccountById(int accountId) throws SQLException, ClassNotFoundException;
	public boolean updateByEmail(int accountId, String newEmail) throws ClassNotFoundException, SQLException;
	public boolean updateByUserName(int accountId, String newUserName) throws ClassNotFoundException, SQLException;
	public boolean updateByFullName(int accountId, String newFullName) throws ClassNotFoundException, SQLException;
	public boolean updateByDepartmentId(int id, int depId) throws ClassNotFoundException, SQLException;
	public boolean updateByPosId(int id, int posId) throws ClassNotFoundException, SQLException;
}
