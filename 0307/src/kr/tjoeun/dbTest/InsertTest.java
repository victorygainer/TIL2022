package kr.tjoeun.dbTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		
//		테이블에 저장할 데이터를 키보드로 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine().trim();
		System.out.print("메모: ");
		String memo = scanner.nextLine().trim();
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
//		MySQL에 연결한다.
		conn = DBUtil.getMySQLConnection();
		if (conn != null) {
//			System.out.println("연결성공: " + conn);
//			MySQL 연결했으므로 입력받은 데이터를 테이블에 저장한다.
			
			try {
				/*
//				Statement를 사용해서 입력받은 데이터를 테이블에 저장한다.
//				sql 명령을 만든다.
//				문자열 데이터는 반드시 작은따옴표로 묶어야 한다.
//				sql 명령 끝에 ";"를 입력하면 안된다.
//				String sql = "insert into memo(name, password, memo) values ('" + name + "', '" + password +"', '" + memo + "')";
				String sql = String.format("insert into memo(name, password, memo) values ('%s', '%s', '%s')", name, password, memo);
//				System.out.println(sql);
//				sql 명령을 실행할 준비를 한다.
				stmt = conn.createStatement();
//				sql 명령을 실행한다.
//				executeQuery(): 테이블에 저장된 내용이 변경되지 않는 sql 명령을 실행한다. => select
//				executeUpdate(): 테이블에 저장된 내용이 변경되는 sql 명령을 실행한다. => insert, update, delete
				stmt.executeUpdate(sql);
				*/
				
//				PreparedStatement를 사용해서 입력받은 데이터를 테이블에 저장한다.
//				sql 명령을 만든다.
//				변수에 저장된 데이터가 대입될 자리에 "?"를 입력한다.
//				나중에 "?"에 데이터를 대입한다.
//				문자열 데이터가 입력될 자리에 작은따옴표를 사용하지 않는다.
				String sql = "insert into memo(name, password, memo) values (?, ?, ?)";
//				sql 명령을 임시로 만든다.
				pstmt = conn.prepareStatement(sql);
//				"?"에 데이터를 넣어준다.
				pstmt.setString(1, name); // 1번째 "?"에 name에 저장된 값을 넣어준다.
				pstmt.setString(2, password); // 2번째 "?"에 password에 저장된 값을 넣어준다.
				pstmt.setString(3, memo); // 3번째 "?"에 memo에 저장된 값을 넣어준다.
//				"?"에 데이터가 채워진 sql 명령을 실행한다.
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("MySQL 연결실패");
		}
		DBUtil.close(conn);
		
	}
	
}



















