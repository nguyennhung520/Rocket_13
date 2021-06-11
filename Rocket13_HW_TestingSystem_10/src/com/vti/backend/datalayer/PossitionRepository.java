package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class PossitionRepository implements IPossitionRepository{

	private jdbcUltis jdbc;
	
	public PossitionRepository() throws FileNotFoundException, IOException {
		super();
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Position> getListPositions() throws ClassNotFoundException, SQLException {
		List<Position> lisPositions = new ArrayList<Position>();
		String sql = "SELECT * FROM Position";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getNString(2));
			lisPositions.add(pos);
		}
		jdbc.disConnection();
		return lisPositions;
	}

	@Override
	public Position getPosById(int posId) throws ClassNotFoundException, SQLException {
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
