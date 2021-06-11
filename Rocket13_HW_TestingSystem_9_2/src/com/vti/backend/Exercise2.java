package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class Exercise2 {
	private jdbcUltis jdbc;
	
	public Exercise2() throws FileNotFoundException, IOException  {
		jdbc = new jdbcUltis();
	}
	
	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println("Test kết nối!");
		jdbc.connnectionTestting();
	}
	
	public void question2() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position;";
		ResultSet posResult = jdbc.executeQuery(sql);
		System.out.println("Thong tin Position dang co tren he thong: ");
		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | PositionName          |%n");
		System.out.format("+--------+-----------------------+%n");
		while (posResult.next()) {
			System.out.format(leftAlignFormat, posResult.getInt(1), posResult.getString(2));
		}
		System.out.format("+--------+-----------------------+%n");
	}
	
	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tao Position moi.");
		String sql = "INSERT INTO position (PositionName) VALUES(?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		System.out.println("Chon Position can tao 1.Dev, 2.Test, 3.Scrum Master, 4.PM: ");
		String name = getName();
		preStatement.setNString(1, name);
		if (preStatement.executeUpdate() == 1) {
			System.out.println("Tao thanh cong");
			question2();
		} else {
			System.out.println("Da co loi xay ra");
		}
	}

	private String getName() {
		while(true) {
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return "Dev";
			case 2:
				return "Test";
			case 3:
				return "Scrum Master";
			case 4:
				return "PM";
			default:
				System.out.println("SAI SAI ROI! NHAP LAI NAO: ");
				break;
			}
		}
	}
	
	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Update ten cua Position: ");
		System.out.println("Danh sach Position: ");
		question2();
		System.out.println("Chon ID can Update: ");
		int id = ScannerUltis.inputIntPositive();
		System.out.println("Chon ten Position can upadte: 1.Dev, 2.Test, 3.Scrum Master, 4.PM: ");
		String newName = getName();
		String sql = "UPDATE position SET PositionName = ? WHERE (PositionID = ?);";
		PreparedStatement pre4 = jdbc.createPrepareStatement(sql);
		pre4.setNString(id, newName);
		pre4.setInt(2, id);
		if (pre4.executeUpdate() == 1) {
			System.out.println("Update thanh cong");
			question2();
			
		} else {
			System.out.println("Co loi xay ra!");
		}
	}
	
	public void question5() throws ClassNotFoundException, SQLException {
		System.out.println("Xoa postion theo ID");
		question2();
		System.out.println("Chon ID can xoa: ");
		int id = ScannerUltis.inputIntPositive();
		String sql = "DELETE FROM position WHERE (PositionID = ?);";
		PreparedStatement pre5 = jdbc.createPrepareStatement(sql);
		pre5.setInt(1, id);
		if(pre5.executeUpdate()==1) {
			System.out.println("Xoa thanh cong");
			question2();
		}else {
			System.out.println("Xoa khong thanh cong");
		}
	}
	
}
