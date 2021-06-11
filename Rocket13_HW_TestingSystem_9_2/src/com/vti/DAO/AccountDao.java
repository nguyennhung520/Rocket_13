package com.vti.DAO;

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

public class AccountDao {
	private jdbcUltis jdbc;

	public AccountDao() throws FileNotFoundException, IOException {
		super();
		jdbc = new jdbcUltis();
	}
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		String sql = "SELECT * FROM Account";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Account> listAc = new ArrayList<Account>();
		while (resultSet.next()) {
			Account account = new Account();
			account.setAccID(resultSet.getInt(1));
			account.setEmail(resultSet.getNString(2));
			account.setUserName(resultSet.getNString(3));
			account.setFullName(resultSet.getNString(4));
			
			DepartmentDao depDao = new DepartmentDao();
			Department dep = depDao.getDepByID(resultSet.getInt(5));
			account.setDepartment(dep);
			
			PositionDao posDao = new PositionDao();
			Position pos = posDao.getPosByID(resultSet.getInt(6));
			account.setPosition(pos);
			
			LocalDate localDate = resultSet.getDate(7).toLocalDate();
			account.setCreateDate(localDate);
			listAc.add(account);
		}
		return listAc;
		
	}
	
	public Account getAccountByID(int accountId) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account WHERE AccountID = ?";
		PreparedStatement preparedStatement =jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, accountId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setAccID(resultSet.getInt(1));
			account.setEmail(resultSet.getNString(2));
			account.setUserName(resultSet.getNString(3));
			account.setFullName(resultSet.getNString(4));
			
			DepartmentDao depDao = new DepartmentDao();
			Department depart = depDao.getDepByID(resultSet.getInt(5));
			account.setDepartment(depart);
			
			PositionDao posDao = new PositionDao();
			account.setPosition(posDao.getPosByID(resultSet.getInt(6)));
			
			LocalDate localDate = Date.valueOf(resultSet.getDate(7).toString()).toLocalDate();
			account.setCreateDate(localDate);
			return account;
		} else {
			jdbc.disConnection();
			return null;
		}
	}
	
	public boolean isAccountNameExists(String accName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE UserName =?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setNString(1, accName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}
	
	public boolean createAccount(Account acc, int depId, int PosId) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?,?,?,now());";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setNString(1, acc.getEmail());
		preparedStatement.setNString(2, acc.getUserName());
		preparedStatement.setNString(3, acc.getFullName());
		preparedStatement.setInt(4, depId);
		preparedStatement.setInt(5, PosId);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}
	
	public boolean delAccountById(int accountId) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Account WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, accountId);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}
	
	public boolean upDateByEmail(int accountId, String newEmail) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET Email = ? WHERE(AccountID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setNString(1, newEmail);
		preparedStatement.setInt(2, accountId);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet==1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
		
	}
	
	public boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET Username = ? WHERE (AccountID =?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newUserName);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	
	public boolean upDateByFullName(int accountId, String newFullName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET Fullname =? WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newFullName);
		preparedStatement.setInt(2, accountId);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	
	}
	
	public boolean upDateByDepartmentId(int id, int depId) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET DepartmentID = ? WHERE(AccountID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, depId);
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
	
	public boolean upDateByPosistionId(int id, int positionId) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Account SET PositionID = ? WHERE(AccountID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, positionId);
		preparedStatement.setInt(2, id);
		int resultSet = preparedStatement.executeUpdate();
		if(resultSet == 1) {
			jdbc.disConnection();
			return true;
		}else {
			jdbc.disConnection();
			return false;
		}

	}
}
