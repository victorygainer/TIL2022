<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오라클 연결하기</title>
</head>
<body>

<!--
	오라클 연결
	시작 버튼 => 오라클 => Run SQL Commend Line 실행 => 까만창이 두둥....
	
	SQL> connect system
	Enter password: => 비밀번호(오라클 설치시 지정한 비밀번호)를 입력한다. 비밀번호 입력할 때 아무 문자도 나타나지 않는다.
	Connected.
	
	사용자 계정 생성
	SQL> create user 계정이름 identified by 비밀번호;
	User created.
	
	현재 생성된 계정 확인
	SQL> select * from all_users;
	생성된 계정 목록이 주르륵~~~~~~ 나오니 확인하면 된다.
	
	권한 설정
	grant connect, resource to 권한을부여할계정이름;
	Grant successed.
	
	오라클 11g 잠긴 계정 풀기
	1. 계정 상태 확인
	   select * from dva_user;
	2. Lock 해제
	    alter user 계정이름 account unlock;
	3. 계정 비밀번호 변경
	   alter user 계정이름 identified by 새비밀번호;
	   
	오라클 12 이상(클라우드) 버전에서 계정 만들기
	create user C##계정이름 identified by 비밀번호;
	alter user C##계정이름 default tablespace users quote unlimited on users;
	
	오라클 11 SID => xe
	오라클 12 SID => orcl
-->

<%
	Connection conn = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "tjoeunit", "0000");
		out.println("연결성공: " + conn);
	} catch (ClassNotFoundException e) {
		out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
	} catch (SQLException e) {
		out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
	}
%>

</body>
</html>
















