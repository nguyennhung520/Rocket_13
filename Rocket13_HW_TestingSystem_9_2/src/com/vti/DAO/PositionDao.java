package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class PositionDao {
	private jdbcUltis jdbc;

	public PositionDao() throws FileNotFoundException, IOException {
		super();
		jdbc = new jdbcUltis();
	}
	
	public List<Position> getListPositions() throws ClassNotFoundException, Exception{
		String sql = "SELECT * FROM Position";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Position> listPositions = new ArrayList<Position>();
		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getNString(2));
			listPositions.add(pos);
		}
		jdbc.disConnection();
		return listPositions;
	}
	public Position getPosByID(int posId) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Position WHERE PositionID = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, posId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getNString(2));
			return pos;
		} else {
			jdbc.disConnection();
			return null;
		}
	}
}
