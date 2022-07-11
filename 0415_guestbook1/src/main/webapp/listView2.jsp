<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jstl을 사용하겠다고 알려준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>

<style type="text/css">

	span {
		color: red;
		font-weight: bold;
		background-color: dodgerblue;
	}

</style>

</head>
<body>
	
	<!-- jstl을 사용하는 POST 방식의 한글 깨짐 방지 -->
	<!-- request.setCharacterEncoding("UTF-8");와 같은 기능이 실행된다. -->
	<fmt:requestEncoding value="UTF-8"/>
	
<%--
	EL을 사용하면 request 영역에 저장된 데이터를 받는 처리없이 request 영역의 데이터를 사용할 수 있다.
	GuestbookList guestbookList = (GuestbookList) request.getAttribute("guestbookList");
	out.println(guestbookList);
	위의 2줄을 EL을 사용하면 ${guestbookList}와 같이 사용할 수 있다.
	EL을 사용하면 객체 내부의 데이터를 ${객체이름.필드이름} 형태로 얻어올 수 있다. => getter가 실행된다.
	out.println(guestbookList.getList());와 ${guestbookList.list}는 같은 기능이 실행된다.
	
	c:set => jstl 대입문
	<c:set var="변수 이름" value="변수에 저장할 데이터></c:set>
	ArrayList<GuestbookVO> view = guestbookList.getList();는 아래와 같이 jstl로 변환해서 사용한다.
	<c:set var="view" value="${guestbookList.list}"></c:set>
	
	c:if => jstl if문 => else가 없다. => else 처리가 필요하면 조건을 반대로 해서 별도의 if를 만들어 사용한다.
	<c:if test=${조건식}>
		조건식이 참일 경우 실행할 문장
	</c:if>
	
	c:forEach => jstl for문
	
	jstl 일반 for => 초기치 부터 최종치 까지 증가치 만큼 증가하며 반복한다. => 증가치는 생략하면 1이 기본값으로
	사용된다. => 증가치는 반드시 양수만 사용해야 한다.
	<c:forEach var="변수 이름" begin="초기치" end="최종치" [step="증가치"]>
		반복할 문장
	</c:forEach>
	
	jstl 향상된 for => 객체에 저장된 내용이 변수에 처음부터 마지막까지 차례대로 대입되며 반복한다.
	<c:forEach var="변수 이름" items=${배열이나 List 형태의 객체}>
		반복할 문장
	</c:forEach>
	
	jstl 함수 사용하기
	${fn:함수이름(인수)}
	
	jstl 날짜 서식 => 날짜 서식을 지정하는 방법은 자바와 같다.
	<fmt:formatDate value=${날짜 데이터} pattern="날짜 서식"></fmt:formatDate>
--%>
	<c:set var="view" value="${guestbookList.list}"/>
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>방명록 보기</th>
		</tr>
		<tr>
			<td align="right">
				${guestbookList.totalCount}개(${guestbookList.currentPage} / ${guestbookList.totalPage})
			</td>
		</tr>
		<tr>
			<td>
			
				<!-- 테이블에 저장된 글이 없으면 없다고 출력한다. -->
				<c:if test="${view.size() == 0}">
					<marquee>테이블에 저장된 글이 없습니다.</marquee>
				</c:if>
				
				<!-- 테이블에 저장된 글이 있으면 글 목록을 출력한다. -->
				<c:if test="${view.size() != 0}">
					<!-- 컴퓨터 시스템의 날짜와 시간을 얻어온다. -->
					<!-- useBean 액션 태그를 이용해 오늘 날짜를 기억하는 Date 클래스 객체를 선언한다. -->
					<jsp:useBean id="date" class="java.util.Date"/>
					
					<c:forEach var="vo" items="${view}">
						<table width="99%" align="center" border="1" cellpadding="5" cellspacing="0">
							<tr>
								<td>
									${vo.idx}. 
									
									<!-- 이름에 태그가 먹지 않도록 replace 함수를 적용시킨다. -->
									<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"></c:set>
									<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"></c:set>
									
									<!-- 이름에 포함된 검색어를 강조해서 표시한다. -->
									<c:if test="${category == null || category == '내용'}">
										${name}
									</c:if>
									<c:if test="${category == '이름' || category == '내용+이름'}">
										<c:set var="search" value="<span>${item}</span>"/>
										<!-- name에 저장된 모든 검색어를 <span>검색어</span>로 치환한다. -->
										${fn:replace(name, item, search)}
									</c:if>
									(${vo.ip})님이 
									
									<!-- 오늘 입력한 글은 시간만 어제 이전에 입력한 글은 날짜만 나오게 한다. -->
									<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month &&
											date.date == vo.writeDate.date}">
										<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm:ss"/>
									</c:if>
									
									<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month ||
											date.date != vo.writeDate.date}">
										<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
									</c:if>
																		
									에 남긴글
									
									<!-- 수정, 삭제 버튼 추가 -->
									<input type="button" value="수정" onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${guestbookList.currentPage}&job=update'"/>
									<input type="button" value="삭제" onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${guestbookList.currentPage}&job=delete'"/>
									
									<br/>
									<!-- 메모에 태그가 먹지 않고 줄바꿈이 되도록 replace 함수를 적용시킨다. -->
									<c:set var="memo" value="${fn:replace(vo.memo, '<', '&lt;')}"></c:set>
									<c:set var="memo" value="${fn:replace(memo, '>', '&gt;')}"></c:set>
									<c:set var="memo" value="${fn:replace(memo, enter, '<br/>')}"></c:set>
									
									<!-- 내용에 포함된 검색어를 강조해서 표시한다. -->
									<c:if test="${category == null || category == '이름'}">
										${memo}
									</c:if>
									<c:if test="${category == '내용' || category == '내용+이름'}">
										<c:set var="search" value="<span>${item}</span>"/>
										<!-- memo에 저장된 모든 검색어를 <span>검색어</span>로 치환한다. -->
										${fn:replace(memo, item, search)}
									</c:if>
									
								</td>
							</tr>
						</table>
						<hr color="red"/>
					</c:forEach>
					
				</c:if>
				
			</td>
		</tr>
		
		<!-- 페이지 이동 버튼 -->
		<tr>
			<td align="center">
			
				<!-- 처음으로 -->
				<c:if test="${guestbookList.currentPage > 1}">
					<button class="button button1" type="button" title="첫 페이지로 이동합니다." 
							onclick="location.href='?currentPage=1'">처음</button>
				</c:if>
				
				<c:if test="${guestbookList.currentPage <= 1}">
					<button class="button button2" type="button" title="이미 첫 페이지 입니다." 
							disabled="disabled">처음</button>
				</c:if>
				
				<!-- 10페이지 앞으로 -->
				<c:if test="${guestbookList.startPage > 1}">
					<button class="button button1" type="button" title="이전 10 페이지로 이동합니다." 
							onclick="location.href='?currentPage=${guestbookList.startPage - 1}'">
						이전
					</button>
				</c:if>
				
				<c:if test="${guestbookList.startPage <= 1}">
					<button class="button button2" type="button" title="이미 첫 10 페이지 입니다." 
							disabled="disabled">이전</button>
				</c:if>

				<!-- 페이지 이동 -->
				<c:forEach var="i" begin="${guestbookList.startPage}" end="${guestbookList.endPage}" step="1">
				
					<c:if test="${guestbookList.currentPage == i}">
						<button class="button button2" type="button" disabled="disabled">${i}</button>
					</c:if>
					
					<c:if test="${guestbookList.currentPage != i}">
						<button class="button button1" type="button" onclick="location.href='?currentPage=${i}'">
							${i}
						</button>
					</c:if>
				
				</c:forEach>

				<!-- 10페이지 뒤로 -->
				<c:if test="${guestbookList.endPage < guestbookList.totalPage}">
					<button class="button button1" type="button" title="다음 10 페이지로 이동합니다." 
							onclick="location.href='?currentPage=${guestbookList.currentPage + 10}'">다음</button>
				</c:if>
				
				<c:if test="${guestbookList.endPage >= guestbookList.totalPage}">
					<button class="button button2" type="button" title="이미 마지막 10 페이지 입니다." 
							disabled="disabled">다음</button>
				</c:if>
				
				<!-- 마지막으로 -->
				<c:if test="${guestbookList.currentPage < guestbookList.totalPage}">
					<button class="button button1" type="button" title="첫 페이지로 이동합니다." 
							onclick="location.href='?currentPage=${guestbookList.totalPage}'">마지막</button>
				</c:if>
				
				<c:if test="${guestbookList.currentPage >= guestbookList.totalPage}">
					<button class="button button2" type="button" title="이미 마지막 페이지 입니다." disabled="disabled">
						마지막
					</button>
				</c:if>
			
			</td>
		</tr>
		
		<!-- 카테고리별 검색어를 입력받는다. -->
		<tr>
			<td align="center">
				<form action="list.jsp" method="post">
					<select name="category">
						<option>내용</option>
						<option>이름</option>
						<option>내용+이름</option>
					</select>
					<input type="text" name="item" value="${item}"/>
					<input type="submit" value="검색"/>
				</form>
			</td>
		</tr>
		
		<!-- 글쓰기 버튼 -->
		<tr>
			<td align="right">
				<input type="button" value="글쓰기" onclick="location.href='insert.jsp'"/>
			</td>
		</tr>
	</table>

</body>
</html>












