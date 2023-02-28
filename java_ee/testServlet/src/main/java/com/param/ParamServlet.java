package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식으로 submit 된 데이터 받아 오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); //입력창에서 넘어오는 데이터는 문자열 타입
		
		//reponse응답하기
		response.setContentType("text/html; charset=UTF-8"); //Java에서 html 사용하기		
		PrintWriter out = response.getWriter(); //웹으로 가도록 출력 스트림 생성
		out.println("<html>");
		out.println("<body>");

		out.println("나의 이름은  " + name + "이고 나이는 " + age + "세이므로");
		if(age >= 20) out.println("성인입니다.");
		else out.println("청소년입니다.");
		
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {}
}
