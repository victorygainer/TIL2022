<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//	조회수를 증가시킨 글번호와 돌아갈 페이지 번호를 받는다.
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));

//	조회수가 증가되는 것을 확인하기 위해 list.nhn을 currentPage를 가지고 컨트롤러에 요청한다.
//	response.sendRedirect("list.nhn?currentPage=" + currentPage);

//	조회수를 증가시켰으면 컨트롤러에게 조회수를 증가시킨 글을 얻어오는 요청을 한다.
	response.sendRedirect("contentView.nhn?idx=" + idx + "&currentPage=" + currentPage);
%>

</body>
</html>