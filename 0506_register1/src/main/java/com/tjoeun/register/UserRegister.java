package com.tjoeun.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("UserRegister 서블릿의 doGet() 메소드 실행");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("UserRegister 서블릿의 doPost() 메소드 실행");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("UserRegister 서블릿의 actionDo() 메소드 실행");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userID = request.getParameter("userID").trim();
		String userPassword1 = request.getParameter("userPassword1").trim();
		String userPassword2 = request.getParameter("userPassword2").trim();
		String userName = request.getParameter("userName").trim();
		String userAge = request.getParameter("userAge").trim();
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail").trim();
		
		// 입력 체크
		if (userID == null || userID.equals("") ||
				userPassword1 == null || userPassword1.equals("") ||
				userPassword2 == null || userPassword2.equals("") ||
				userName == null || userName.equals("") ||
				userAge == null || userAge.equals("") ||
				userGender == null || userGender.equals("") ||
				userEmail == null || userEmail.equals("")) {
			// 입력 체크 실패시 메시지를 session에 저장한다.
			// getSession(): 서블릿에서 session을 얻어온다.
			request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요"); // ①
			response.sendRedirect("index.jsp"); // ①
			return;
		}
		
		// 비밀번호 체크
		if (!userPassword1.equals(userPassword2)) {
			// 비밀번호 불일치 메시지 session에 저장한다.
			request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다."); // ①
			response.sendRedirect("index.jsp"); // ①
			return;
		}
		
		// 넘어온 데이터가 정상이므로 RegisterVO 클래스 객체를 만들어 저장한다.
		RegisterVO vo = new RegisterVO();
		vo.setUserID(userID);
		vo.setUserPassword(userPassword1);
		vo.setUserName(userName);
		vo.setUserAge(Integer.parseInt(userAge));
		vo.setUserGender(userGender);
		vo.setUserEmail(userEmail);
		// System.out.println(vo);
		
		// 테이블에 회원 정보를 저장하는 메소드를 실행한다.
		int result = new RegisterDAO().register(vo);
		// System.out.println(result);
		
		// 저장 체크
		if (result == 1) {
			// insert sql 명령이 정상적으로 실행되었을 때 메시지를 session에 저장한다.
			request.getSession().setAttribute("messageType", "성공 메시지"); // ①
			request.getSession().setAttribute("messageContent", "회원가입에 성공했습니다."); // ①
		} else {
			// insert sql 명령이 정상적으로 실행되지 않았을 때 메시지를 session에 저장한다.
			request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			request.getSession().setAttribute("messageContent", "이미 존재하는 아이디 입니다."); // ①
		}
		response.sendRedirect("index.jsp"); // ①
	}

}






