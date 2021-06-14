package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Account.Staff;
import com.vti.ultis.jdbcUltis;

public class AccountProjectRepository implements IAccountProjectRepository{
	private jdbcUltis jdbc;
	
	
	public AccountProjectRepository() throws FileNotFoundException, IOException {
		super();
		jdbc = new jdbcUltis();
	}

	@Override
	public boolean isAccNameExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE ProjectID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, email);
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
	public boolean loginAccount(String password, String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account acc WHERE acc.Email = ? AND acc.possword = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setNString(1, password);
		preparedStatement.setNString(2, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean findAccountByID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account acc WHERE aac.ProjectID = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
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
	public List<Account> getListAccount() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account ORDER BY ProjectID";
		ResultSet resulSet = jdbc.executeQuery(sql);
		List<Account> listAcc = new ArrayList<Account>();
		while (resulSet.next()) {
//			Account acc = new Account(resulSet.getInt("ProjectID"), resulSet.getString("ProjectName"), resulSet.getInt("TeamSize"),
//					resulSet.getNString("FullName"), resulSet.getNString("Email"), resulSet.getNString("Password"),resulSet.getStaff("Staff"));
			Account acc = new Account(resulSet.getInt("ProjectID"), resulSet.getString("ProjectName"), resulSet.getInt("TeamSize"),
					resulSet.getNString("FullName"), resulSet.getNString("Email"), resulSet.getNString("Password"),null);
			//Loi getStaff
			listAcc.add(acc);
		}
		jdbc.disConnection();
		return listAcc;
	}
	

}
