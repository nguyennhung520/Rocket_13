package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.jdbcUltis;

public class DepartmentDao {
	private jdbcUltis jdbc;

	public DepartmentDao() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM Department ";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Department> listDep = new ArrayList<Department>();
		while(resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			listDep.add(dep);
		}
		jdbc.disConnection();
		return listDep;
	}
	
	public Department getDepByID(int departmentId) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, departmentId);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			Department dep = new Department(result.getInt("DepartmentID"), result.getString("DepartmentName"));
			return dep;
		} else {
			System.out.println("Cannot find department which has id = "+departmentId);
			jdbc.disConnection();
			return null;
		}
	}
	 
	public boolean getDepByName(String departmentName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(2, departmentName);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			jdbc.disConnection();
			return true;
			
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	public boolean createDepartment(String departmentName) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(2, departmentName);
		int result = preStatement.executeUpdate();
		if(result == 2 ) {
			jdbc.disConnection();
			return true;
		}else {
			jdbc.disConnection();
			return false;
		}
	}
	public boolean updateDepartmentName(int departmentID, String newDepartmentName) throws ClassNotFoundException, SQLException {
		Department depID = getDepByID(departmentID);
		if (depID == null) {
			return false;
		} else {
			String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setString(1, newDepartmentName);
			preStatement.setInt(2, departmentID);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}
		}
	}
	
	public boolean delDepartmentID(int departmentID) throws ClassNotFoundException, SQLException {
		Department depID = getDepByID(departmentID);
		if (depID != null) {
			String sql = "DELETE FROM department WHERE (DepartmentID = ?);";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setInt(1, departmentID);
			int result = preStatement.executeUpdate();
			if(result == 1) {
				jdbc.disConnection();
				return true;
			}else {
				jdbc.disConnection();
				return false;
			}
		} else {
			jdbc.disConnection();
			return false;
		}
	}
}
