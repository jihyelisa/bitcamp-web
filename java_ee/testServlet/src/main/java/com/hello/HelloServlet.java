package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet") 이렇게 서버 접속할 수도 있음
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		System.out.println("init()");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html; charset=UTF-8"); //Java에서 html 사용하기		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Hi! test servlet"); //페이지소스 창에서 줄바꿈 - println
		out.println("<br>"); //브라우저 출력창에서 줄바꿈 - <br>
		out.println("하이! 테스트 서블렛");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {
		System.out.println("destroy()");
	}

}
