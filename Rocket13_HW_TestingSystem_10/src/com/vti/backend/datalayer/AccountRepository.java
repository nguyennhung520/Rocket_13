package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class AccountRepository implements IAccountRepository{
	private jdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException {
		super();
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account ORDER BY AccountID";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Account> listAccount = new ArrayList<Account>();
		while (resultSet.next()) {
			Account account = new Account();
			account.setAccID(resultSet.getInt(1));
			account.setEmail(resultSet.getNString(2));
			account.setUserName(resultSet.getNString(3));
			account.setFullName(resultSet.getNString(4));
			
			IDepartmentRepository depRepository = new DepartmentRepository();
			Department dep = depRepository.getDepById(resultSet.getInt(5));
			account.setDepartment(dep);
			
			IPossitionRepository posRDao = new PossitionRepository();
			Position pos = posRDao.getPosById(resultSet.getInt(6));
			
			LocalDate localD = resultSet.getDate(7).toLocalDate();
			account.setCreateDate(localD);
			
			listAccount.add(account);
		}
		return listAccount;
	}

	@Override
	public Account getAccountById(int accountId) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account WHERE AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, accountId);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setAccID(resultSet.getInt(1));
			account.setEmail(resultSet.getNString(2));
			account.setUserName(resultSet.getNString(3));
			account.setFullName(resultSet.getNString(4));
			
			IDepartmentRepository depRDao = new DepartmentRepository();
			Department dep = depRDao.getDepById(resultSet.getInt(5));
			account.setDepartment(dep);
			
			IPossitionRepository posRPos = new PossitionRepository();
			account.setPosition(posRPos.getPosById(resultSet.getInt(6)));
			
			LocalDate localD = Date.valueOf(resultSet.getDate(7).toString()).toLocalDate();
			account.setCreateDate(localD);
			return account;
		} else {
			jdbc.disConnection();
			return null;
		}
		
	}

	@Override
	public boolean isAccountNameExists(String accountName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE UserName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, accountName);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean isAccountIdExists(int aaccountId) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, aaccountId);
		ResultSet resulSet = preStatement.executeQuery();
		if (resulSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?,?,?,now());";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, acc.getEmail());
		preparedStatement.setString(2, acc.getUserName());
		preparedStatement.setString(3, acc.getFullName());
		preparedStatement.setInt(4, depId);
		preparedStatement.setInt(5, posId);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet ==1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean delAccountById(int accountId) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM Account WHERE (AccountID =?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, accountId);
		int resultSet = preStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean updateByEmail(int accountId, String newEmail) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET Email = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newEmail);
		preStatement.setInt(2, accountId);
		int resultSet = preStatement.executeUpdate();
		if (resultSet ==1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean updateByUserName(int accountId, String newUserName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET UserName = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newUserName);
		preStatement.setInt(2, accountId);
		int resultSet = preStatement.executeUpdate();
		if (resultSet ==1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean updateByFullName(int accountId, String newFullName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET FullName = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newFullName);
		preStatement.setInt(2, accountId);
		int resultSet = preStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean updateByDepartmentId(int id, int depId) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET DepartmentID = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, depId);
		preStatement.setInt(2, id);
		int resultSet = preStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public boolean updateByPosId(int id, int posId) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET PositionID = ? WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, posId);
		preparedStatement.setInt(2, id);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}
}
