<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	MultipartRequest multipartRequest = new MultipartRequest(
		request,
		application.getRealPath("./upload/"),
		5 * 1024 * 1024 * 1024, // 5GB
		"UTF-8",
		new DefaultFileRenamePolicy()
	);
	
//	단일 파일 업로드
//	getOriginalFileName(): 사용자가 업로드 한 파일 이름을 얻어온다.
	String filename = multipartRequest.getOriginalFileName("file");
//	getFilesystemName(): 업로드되서 실제 디스크에 저장된 파일 이름을 얻어온다.
	String fileRealname = multipartRequest.getFilesystemName("file");
	
	File realFilename = multipartRequest.getFile("file");
//	length(): 파일의 크기를 얻어온다.
	out.println("파일 크기: " + realFilename.length() + "<br/>");
	
//	업로드 제한
	if (realFilename.length() > 5 * 1024 * 1024) { // 용량
		out.println("<script>");
		out.println("alert('용량 초과');");
		out.println("</script>");
		// 업로드된 파일을 삭제하기 위해 File 객체를 생성한다.
		File file = new File(application.getRealPath("./upload/") + fileRealname);
		// delete(): 파일을 삭제한다.
		file.delete();
	} else if (!fileRealname.endsWith(".zip") && !fileRealname.endsWith(".txt")) { // 파일 종류
		// *.zip 파일과 *.txt 파일만 업로드 할 수 있도록 한다.
		// startsWith(): 인수로 지정된 문자열로 파일 이름이 시작하면 true, 그렇치 않으면 false를 리턴한다.
		// endsWith(): 인수로 지정된 문자열로 파일 이름이 끝나하면 true, 그렇치 않으면 false를 리턴한다.
		out.println("<script>");
		out.println("alert('업로드 할 수 있는 형식의 파일이 아닙니다.\\nzip 파일과 txt 파일만 업로드 가능합니다.')");
		out.println("</script>");
		File file = new File(application.getRealPath("./upload/") + fileRealname);
		file.delete();
	} else {
		out.println("원본 파일 이름: " + filename + "<br/>");
		out.println("실제 업로드된 파일 이름: " + fileRealname + "<br/>");
	}
	
%>

<a href="index.jsp">돌아가기</a>

</body>
</html>










