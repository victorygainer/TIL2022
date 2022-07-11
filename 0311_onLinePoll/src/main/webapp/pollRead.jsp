<%@page import="kr.tjoeun.onLinePoll.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<!-- favicon: 인터넷 웹 브라우저의 주소창에 표시되는 웹 사이트나 웹 페이지를 대표하는 아이콘이다. -->
<link rel="icon" href="./favicon-16x16.png">
</head>
<body>

<!-- 투표 항목이 저장된 텍스트 파일의 데이터를 읽어서 웹 브라우저에 출력한다. -->
<%
//	이클립스는 프로젝트가 실행되면 프로젝트를 이클립스가 내부적으로 사용하는 서버에 복사하고 실행한다.
//	C:\kookgi\jsp\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\0311_onLinePoll\
//	application.getRealPath("/") 메소드를 실행하면 프로젝트가 실행되는 실제(real) 경로(path)를 얻어온다.
//	out.println(application.getRealPath("/")); // "/"는 web root(홈페이지에 최초 진입경로)를 의미한다.
	String filepath = application.getRealPath("/") + "poll.txt";
//	out.println(filepath);
	ArrayList<String> poll = PollRead.pollRead(filepath);
//	out.println(poll);
//	for (String str : poll) {
//		out.println(str + "<br>");
//	}
//	투표 항목의 개수
	int itemCount = (poll.size() - 1) / 2;
//	out.println(itemCount + "<br>");
%>

<form action="pollWrite.jsp" method="post">

	<!--
		cellpadding: 셀 안여백, 셀을 구성하는 선과 셀 내부 문자와의 간격
		cellspacing: 셀과 셀 사이의 간격
	-->
	<table width="500" border="1" align="center" cellpadding="5" cellspacing="0">
		<tr> <!-- 줄 -->
			<th> <!-- 칸, 표의 첫줄을 구성하는 칸, 굵게 및 가운데 정렬로 표시된다. -->
				<%=poll.get(0)%> <%-- EL(${ ~ })로 대체해서 사용한다. --%>
			</th>
		</tr>
	<%
//		for (int i=1; i<=itemCount; i++) { // jstl로 대체해서 사용한다.
		pageContext.setAttribute("poll", poll);
	%>
		<c:forEach var="i" begin="1" end="10" step="1"> <!-- jstl -->
		<tr>
			<td> <!-- 칸, 표의 첫줄을 제외한 나머지 줄을 구성하는 칸 -->
				<%-- <input type="radio" name="poll" value="<%=i%>"><%=poll.get(i)%> --%>
				<input type="radio" name="poll" value="${i}">${poll.get(i)}
			</td>
		</tr>
		</c:forEach>
	<%
//		}
	%>
		<tr>
			<td align="center">
				<input type="submit" value="투표하기">
				<input type="button" value="결과보기" onclick="location.href='pollResult.jsp'">
			</td>
		</tr>
	</table>

</form>

</body>
</html>











