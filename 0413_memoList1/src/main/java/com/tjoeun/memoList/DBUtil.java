package com.tjoeun.memoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

//	mysql에 연결한 connection을 리턴하는 메소드
	public static Connection getMysqlConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 5.x 사용자
			// Class.forName("com.mysql.cj.jdbc.Driver"); // 8.x 사용자
			String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; // 5.x 사용자
			// String url = "jdbc:mysql://localhost:3306/javaam?serverTimezone=UTC"; // 8.x 사용자
			conn = DriverManager.getConnection(url, "root", "0000");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		}
		return conn;
	}

//	connection 객체를 닫는 메소드
	public static void close(Connection conn) {
		if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
	
}




