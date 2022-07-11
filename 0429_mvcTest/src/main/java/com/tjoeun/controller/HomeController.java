package com.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	브라우저 주소창의 contextPath(/0429_mvcTest) 뒤에 @WebServlet 어노테이션에서 지정된 요청이
//	들어오면 @WebServlet 어노테이션이 붙어있는 클래스(컨트롤러)에서 get 방식으로 요청이 들어오면
//	doGet() 메소드가 자동으로 실행되고 post 방식으로 요청이 들어오면 doPost() 메소드가 자동으로
//	실행된다.
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

//  get 방식으로 컨트롤러에 요청이 들어올 때 자동으로 실행되는 메소드 => submit 버튼이 클릭되지 않은 경우
//  request와 response는 jsp에서는 내장 객체로 제공되지만 서블릿에서는 기본적으로 제공되지 않기 때문에
//  필요할 때 마다 만들어 사용해야 한다.
//  request는 정보를 받을 때 사용하고 response는 정보를 보낼 때 사용한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		// get 방식으로 요청될 때 넘어오는 데이터를 받는다.
		String name = request.getParameter("name");
		System.out.println(name);
		
		request.setAttribute("name", name);
		
		// view 페이지 이름을 만든다.
		String viewpage = "/WEB-INF/hello.jsp";
		// RequestDispatcher 인터페이스 객체를 이용해서 브라우저로 요청된 요청에 따른 실제
		// view 페이지를 호출해서 브라우저에 표시한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		// 요청에 따른 view 페이지를 호출한다.
		dispatcher.forward(request, response);
		
	}

//  post 방식으로 컨트롤러에 요청이 들어올 때 자동으로 실행되는 메소드 => submit 버튼이 클릭된 경우
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}








