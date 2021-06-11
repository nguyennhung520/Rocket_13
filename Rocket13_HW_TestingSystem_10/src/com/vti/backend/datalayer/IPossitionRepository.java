package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Position;

public interface IPossitionRepository {
	public List<Position> getListPositions() throws ClassNotFoundException, SQLException;
	public Position getPosById(int posId) throws ClassNotFoundException, SQLException;
}
