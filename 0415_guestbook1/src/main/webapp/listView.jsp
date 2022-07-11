<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tjoeun.vo.GuestbookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
//	list.jsp에서 1페이지 분량의 글 목록과 페이징 작업에 사용할 변수를 저장해서 request 영역에 저장한
//	GuestbookList 클래스 객체를 받는다.
//	request 영역에 저장된 데이터는 Object 타입이므로 반드시 데이터를 얻어온 다음에 형변환 시켜야 한다.
	GuestbookList guestbookList = (GuestbookList) request.getAttribute("guestbookList");
//	out.println(guestbookList);
//	out.println(guestbookList.getList());

//	브라우저에 출력할 1페이지 분량의 글 목록(guestbookList.getList())만 꺼내서 별도의 ArrayList를
//	만들어 사용한다.
	ArrayList<GuestbookVO> view = guestbookList.getList();
//	out.println(view);
//	for (GuestbookVO vo : view) {
//		out.println(vo + "<br/>");
//	}
%>

	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>방명록 보기</th>
		</tr>
		<tr>
			<td align="right">
				<%=guestbookList.getTotalCount()%>개(<%=guestbookList.getCurrentPage()%> / <%=guestbookList.getTotalPage()%>)
			</td>
		</tr>
		<tr>
			<td>
<%
	if (view.size() == 0) {
		out.println("<marquee>테이블에 저장된 글이 없습니다.</marquee>");
	} else {
		
		// 컴퓨터 시스템의 날짜와 시간을 얻어온다.
		Date date = new Date();
		// 날짜, 시간 서식을 만든다.
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
		
		for (GuestbookVO vo : view) {
%>
				<table width="99%" align="center" border="1" cellpadding="5" cellspacing="0">
					<tr>
						<td>
							<%=vo.getIdx()%>. <%=vo.getName().replace("<", "&lt;").replace(">", "&gt;")%>
							(<%=vo.getIp()%>)님이
<%
			// 오늘 입력된 글은 시간만 표시하고 어제 이전에 입력된 글은 날짜만 표시한다.
			if (sdf2.format(date).equals(sdf2.format(vo.getWriteDate()))) {
				out.println(sdf1.format(vo.getWriteDate()));
			} else {
				out.println(sdf2.format(vo.getWriteDate()));
			}
%>							
							 에 남긴글<br/>
							<%=vo.getMemo().replace("<", "&lt;").replace(">", "&gt;").replace("\r\n", "<br/>")%>
						</td>
					</tr>
				</table>
<%
		}
	}
%>
			</td>
		</tr>
		
		<!-- 페이지 이동 버튼 -->
		<tr>
			<td align="center">
			
<%
	if (guestbookList.getCurrentPage() > 1) {
%>
				<button class="button button1" type="button" title="첫 페이지로 이동합니다." 
						onclick="location.href='?currentPage=1'">처음</button>
<%
	} else {
%>
				<button class="button button2" type="button" title="이미 첫 페이지 입니다." 
						disabled="disabled">처음</button>
<%	
	}

	if (guestbookList.getStartPage() > 1) {
%>
				<button class="button button1" type="button" title="이전 10 페이지로 이동합니다." 
						onclick="location.href='?currentPage=<%=guestbookList.getStartPage() - 1%>'">
					이전
				</button>
<%
	} else {
%>
				<button class="button button2" type="button" title="이미 첫 10 페이지 입니다." 
						disabled="disabled">이전</button>
<%
	}
	
	for (int i=guestbookList.getStartPage(); i<=guestbookList.getEndPage(); i++) {
		if (guestbookList.getCurrentPage() == i) {
%>
				<button class="button button2" type="button" disabled="disabled"><%=i%></button>
<%
		} else {
%>
				<button class="button button1" type="button" onclick="location.href='?currentPage=<%=i%>'">
					<%=i%>
				</button>
<%
		}
	}

	if (guestbookList.getEndPage() < guestbookList.getTotalPage()) {
%>
			<button class="button button1" type="button" title="다음 10 페이지로 이동합니다." 
					onclick="location.href='?currentPage=<%=guestbookList.getCurrentPage() + 10%>'">다음</button>
<%
	} else {
%>
			<button class="button button2" type="button" title="이미 마지막 10 페이지 입니다." 
					disabled="disabled">다음</button>
<%
	}

	if (guestbookList.getCurrentPage() < guestbookList.getTotalPage()) {
%>
			<button class="button button1" type="button" title="첫 페이지로 이동합니다." 
					onclick="location.href='?currentPage=<%=guestbookList.getTotalPage()%>'">마지막</button>
<%
	} else {
%>
			<button class="button button2" type="button" title="이미 마지막 페이지 입니다." disabled="disabled">
				마지막
			</button>
<%
	}
%>			
			
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<input type="button" value="글쓰기" onclick="location.href='insert.jsp'"/>
			</td>
		</tr>
	</table>

</body>
</html>









