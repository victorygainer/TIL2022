package kr.tjoeun.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionTest2 {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.getMySQLConnection();
		if (conn != null) {
			System.out.println("연결성공: " + conn);
		} else {
			System.out.println("MySQL 연결실패");
		}
		DBUtil.close(conn);
		
	}
	
}








