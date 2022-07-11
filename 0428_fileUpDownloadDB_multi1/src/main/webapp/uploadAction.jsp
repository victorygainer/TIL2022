<%@page import="com.tjoeun.fileupload.FileDAO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
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
		// application.getRealPath("./upload/"),
		// 보안성 향상을 위해 upload 폴더를 webapp 외부에 만든다.
		"C:/upload/",
		5 * 1024 * 1024 * 1024,
		"UTF-8",
		new DefaultFileRenamePolicy()
	);
	
//	다중 파일 업로드
//	index.jsp에서 넘어오는 업로드 할 파일 이름 여러개를 받는다.
	Enumeration filenames = multipartRequest.getFileNames();

//	hasMoreElements(): Enumeration 인터페이스 객체에 저장된 다음 데이터가 있으면 true, 없으면 false를 리턴시킨다.
	while (filenames.hasMoreElements()) { // 업로드 할 파일이 있는 동안 반복한다.
		
		// nextElement(): Enumeration 인터페이스 객체에 저장된 다음에 처리할 데이터를 얻어온다.
		String parameter = (String) filenames.nextElement();
		// 업로드 페이지의 type 속성이 file로 설정된 객체를 역순으로 얻어온다.
		// out.println(parameter + "<br/>");
		String filename = multipartRequest.getOriginalFileName(parameter);
		String fileRealname = multipartRequest.getFilesystemName(parameter);
				
		// 업로드 할 파일이 넘어오지 않았으면 다음 파일을 처리한다. => 남은 반복을 실행할 필요없다.
		if (filename == null) {
			continue;
		}
		// out.println("업로드한 파일: " + filename + ", 업로드된 파일: " + fileRealname + "<br/>");
		
		// 업로드 제한
		File realFilename = new File("C:/upload/" + fileRealname);
		// out.println("파일 크기: " + realFilename.length() + "<br/>");

		if (realFilename.length() > 5 * 1024 * 1024) {
			out.println("<script>");
			out.println("alert('용량 초과');");
			out.println("</script>");
			realFilename.delete();
		} else if (!fileRealname.endsWith(".zip") && !fileRealname.endsWith(".txt")) {
			out.println("<script>");
			out.println("alert('업로드 할 수 있는 형식의 파일이 아닙니다.\\nzip 파일과 txt 파일만 업로드 가능합니다.')");
			out.println("</script>");
			realFilename.delete();
		} else {
			out.println("원본 파일 이름: " + filename + "<br/>");
			out.println("실제 업로드된 파일 이름: " + fileRealname + "<br/>");
			
			// filename과 fileRealname을 테이블에 저장하는 메소드를 호출한다.
			new FileDAO().upload(filename, fileRealname);
		}
		
	}
%>

	<a href="index.jsp">돌아가기</a>

</body>
</html>




