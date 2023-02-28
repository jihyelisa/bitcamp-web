package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식으로 submit 된 데이터 받아 오기
		String name = request.getParameter("name");
		String gender = request.getParameter("gender"); //입력창에서 넘어오는 데이터는 String
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
//		if(Integer.parseInt(gender)==0) gender="남자";
		if(gender.equals("0")) gender="남자";
		else gender="여자";
		
		//response응답하기
		response.setContentType("text/html; charset=UTF-8"); //Java에서 html 사용하기
		PrintWriter out = response.getWriter(); //웹으로 가도록 출력 스트림 생성
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>");
		out.println("Profile");
		out.println("</h2>");

		out.println("<ul style='background-color: " + color + ";'>");
		out.println("<li>");
		out.println("이름: " + name);
		out.println("</li>");
		out.println("<li>");
		out.println("성별: " + gender);
		out.println("</li>");
		out.println("<li>");
		out.println("색깔: " + color);
		out.println("</li>");
		out.println("<li>");
		out.println("취미: ");
		for(String select : hobby) out.println(select + "  ");
		out.println("</li>");
		out.println("<li>");
		out.println("과목: ");
		for(String select : subject) out.println(select + "  ");
		out.println("</li>");
		out.println("</ul>");
		
		// 이전 버튼
		out.println("<input type='button' value='← 이전' onclick='history.go(-1)'>");
			
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {}


}
