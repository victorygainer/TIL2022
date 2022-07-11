<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commons DBCP 연결하기</title>
</head>
<body>

<%
//	lib 폴더에 commons-dbcp-1.4.jar, commons-pool-1.5.7.jar 파일을 복사해 넣는다. => commonsDBCP 드라이버
//	src 폴더에 *.jocl 파일을 작성한다. => poll.jocl 파일을 복사해 넣는다. => 데이터베이스 연결 정보
//	oracle => <string value="jdbc:oracle:thin:@localhost:1521:xe"/>
//	mysql 5.x => <string value="jdbc:mysql://localhost:3306/javaam?useUnicode=true&amp;characterEncoding=UTF-8"/>
//	mysql 8.x => <string value="jdbc:mysql://localhost:3306/javaam?serverTimezone=UTC"/>
	Connection conn = null;
	try {
		// Class.forName("com.mysql.jdbc.Driver"); // mysql 5.x
		// Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 8.x
		Class.forName("oracle.jdbc.driver.OracleDriver"); // oracle
		Class.forName("org.apache.commons.dbcp.PoolingDriver"); // commonsDBCP
		String url = "jdbc:apache:commons:dbcp:/pool"; // 데이터베이스 연결 정보가 저장된 파일의 경로를 지정한다.
		conn = DriverManager.getConnection(url);
		out.println("연결성공: " + conn);
	} catch (ClassNotFoundException e) {
		out.println("드라이버 클래스를 읽어올 수 없습니다.");
	} catch (SQLException e) {
		System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
	}
%>

</body>
</html>











