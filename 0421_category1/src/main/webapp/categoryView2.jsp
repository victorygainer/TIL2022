<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 프로젝트</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body class="p-3">

	<h1 class="m-3">Category Project</h1>
	
	<!-- jquery로 메인 카테고리 폼 입력 체크 -->
	<form id="form" class="row m-3" action="insert.jsp" method="post">
		<div class="col-md-3">
			<input id="category" class="form-control" type="text" name="category"/>
		</div>
		<div class="col-md-2">
			<input class="btn btn-outline-primary" type="submit" value="메인 카테고리 만들기"/>
		</div>
	</form>
	<hr style="height: 5px; color: red;">
	
	<!-- 카테고리 개수만큼 반복하며 카테고리 목록을 출력한다. -->
	<c:forEach var="vo" items="${categoryList.list}">
	
		<!-- 서브 카테고리를 입력하는 모든 폼에 다른 name 속성이 지정되야 식별이 가능하므로 폼 이름을 만든다. -->
		<c:set var="formName" value="form${vo.idx}"></c:set>
	
		<!-- jquery로 서브 카테고리 폼 입력 체크 -->
		<form class="sub_form row m-1" action="reply.jsp" method="post" name=${formName}>
		
			<!-- idx, gup, lev, seq를 표시하는 텍스트 상자는 테스트가 완료되면 모두 hidden으로 처리한다. -->
			<div class="col-md-4">
				<input type="text" name="idx" value="${vo.idx}" size="1"/>
				<input type="text" name="gup" value="${vo.gup}" size="1"/>
				<input type="text" name="lev" value="${vo.lev}" size="1"/>
				<input type="text" name="seq" value="${vo.seq}" size="1"/>
				
				<!-- 카테고리 레벨(lev)에 따른 들여쓰기를 한다. -->
				<c:if test="${vo.lev > 0}">
					<c:forEach var="i" begin="1" end="${vo.lev}" step="1">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<img alt="화살표" src="./images/arrow.png" width="20"/>
				</c:if>
				
				<c:if test="${vo.deleteCheck == 'YES'}">
					삭제된 카테고리입니다.
				</c:if>
				<c:if test="${vo.deleteCheck != 'YES'}">
					<c:if test="${vo.deleteReport > 10}">
						신고 만땅먹은 카테고리입니다.
					</c:if>
					<c:if test="${vo.deleteReport <= 10}">
						<span>${vo.category}</span>(신고횟수: ${vo.deleteReport}번)
					</c:if>
				</c:if>
				
			</div>
			
			<c:if test="${vo.deleteCheck == 'YES'}">
				<div class="col-md-8">
					<input 
						class="btn btn-outline-success" 
						type="button" 
						value="복구"
						onclick="mySubmitRestore(${formName})"
					/>
				</div>
			</c:if>
			
			<c:if test="${vo.deleteCheck != 'YES'}">
				
				<c:if test="${vo.deleteReport > 10}">
					<div class="col-md-3">
						<input class="sub_category form-control" type="text" name="category" disabled="disabled"/>
					</div>
					<div class="col-md-5">
						<input class="btn btn-outline-success" type="submit" value="서브 카테고리 만들기" disabled="disabled"/>
						<input class="btn btn-outline-danger" type="button" value="삭제" disabled="disabled"/>
						<input class="btn btn-outline-warning" type="button" value="신고" disabled="disabled"/>
						<input class="btn btn-outline-info" type="button" value="수정" disabled="disabled"/>
					</div>
				</c:if>
				
				<c:if test="${vo.deleteReport <= 10}">
					<div class="col-md-3">
						<input class="sub_category form-control" type="text" name="category"/>
					</div>
					<div class="col-md-5">
						<input class="btn btn-outline-success" type="submit" value="서브 카테고리 만들기"/>
						<!--
						<input class="btn btn-outline-danger" type="button" value="삭제" onclick="location.href='delete.jsp?idx=${vo.idx}'"/>
						-->
						<input class="btn btn-outline-danger" type="button" value="삭제" onclick="mySubmitDelete(${formName})"/>
						<input class="btn btn-outline-warning" type="button" value="신고" onclick="mySubmitDeleteReport(${formName})"/>
						<input class="btn btn-outline-info" type="button" value="수정" onclick="mySubmitUpdate(${formName})"/>
					</div>
				</c:if>
			
		</c:if>
		
		</form>
	</c:forEach>

	<script type="text/javascript" src="./js/formCheck.js"></script>
</body>
</html>









