<%@page import="com.tjoeun.service.UpdateService"%>
<%@page import="com.tjoeun.service.DeleteService"%>
<%@page import="com.tjoeun.service.SelectService"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
//	update.jsp에서 넘어오는 데이터를 받는다.
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
%>

	<jsp:useBean id="vo" class="com.tjoeun.vo.GuestbookVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>

<%
//	수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교하기 위해 수정할 글을 얻어온다.
	GuestbookVO original = SelectService.getInstance().selectByIdx(vo.getIdx());

//	oracle은 필드의 데이터 타입을 char로 선언하면 필드의 자리수보다 입력된 문자의 개수가 적을 때 남는 
//	자리가 모두 공백으로 리턴된다.
//	테이블을 설계할 때 char 대신 varchar2를 사용한다.
//	이미 테이블이 char로 설계된 상태라면 trim() 메소드로 불필요한 빈 칸을 제거해서 사용한다.
//	out.println("수정하기 위해 입력한 비밀번호의 글자수: " + vo.getPassword().length());
//	out.println("수정할 글의 비밀번호 글자수: " + original.getPassword().trim().length());

//	수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교한다.
	out.println("<script>");
	if (original.getPassword().trim().equals(vo.getPassword())) {
		// 비밀번호가 일치하면 글을 수정하는 메소드를 실행한다.
		UpdateService.getInstance().update(vo);
		// 글을 수정하고 수정 완료 메시지를 출력한다.
		out.println("alert('" + original.getIdx() + "번 글 수정완료!!!')");
	} else {
		// 비밀번호가 일치하지 않기 때문에 오류 메시지를 출력한다.
		out.println("alert('비밀번호가 일치하지 않습니다.')");
	}
	out.println("location.href='list.jsp?currentPage=" + currentPage + "'");
	out.println("</script>");
%>

</body>
</html>










