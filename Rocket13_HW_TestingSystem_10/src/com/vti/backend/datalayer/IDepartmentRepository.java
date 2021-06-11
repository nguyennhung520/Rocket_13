package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {
	public List<Department> getListDepartment() throws SQLException, ClassNotFoundException;
	public Department getDepById(int depId) throws SQLException, ClassNotFoundException;
	public boolean isDepNameExists(String depName) throws ClassNotFoundException, SQLException;
	public boolean createDep(String depName) throws ClassNotFoundException, SQLException;
	public boolean updateDepName(int id, String newDepName) throws ClassNotFoundException, SQLException;
	public boolean depDepById(int depId) throws ClassNotFoundException, SQLException;
}
