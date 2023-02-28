package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식으로 submit 된 데이터 받아 오기
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y")); //입력창에서 넘어오는 데이터는 문자열 타입
		
		//response응답하기
		response.setContentType("text/html; charset=UTF-8"); //Java에서 html 사용하기
		PrintWriter out = response.getWriter(); //웹으로 가도록 출력 스트림 생성
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h3>");
		out.println(x + " + " + y + " = " + (x+y) + "<br>");
		out.println(x + " - " + y + " = " + (x-y) + "<br>");
		out.println(x + " * " + y + " = " + x*y + "<br>");
		out.println(x + " / " + y + " = " + (double)x/y);
		out.println("</h3>");

		out.println("<input type='button' value='뒤로' onclick='history.go(-1)'>");
		out.println("<input type='button' value='뒤로' onclick=location.href='http://localhost:8080/testServlet/input.html'>");
		out.println("<input type='button' value='연령제한' onclick=location.href='http://localhost:8080/testServlet/param.html'>");
			
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {}

}
