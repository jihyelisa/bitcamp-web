package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	urlPatterns = {"*.do"},
	initParams = {
			@WebInitParam(name="propertyConfig", value="command.properties")
	}
)

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig);
		
		String realFolder = config.getServletContext().getRealPath("/WEB-INF");
		String realPath = realFolder + "/" + propertyConfig;
		System.out.println("realPath = " + realPath);
		
		FileInputStream fin = null;
		Properties properties = new Properties();
  
		try {
	        //fin = new FileInputStream(propertyConfig);
			fin = new FileInputStream(realPath);
	                 
	        properties.load(fin);
	        System.out.println("properties = "+properties);
	        
	     } catch (IOException e) {
	        e.printStackTrace();
	     }finally{
	        try {
	           fin.close();
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	     }
	     System.out.println();
	     
	     Iterator it = properties.keySet().iterator();
	     while(it.hasNext()) {
	        String key = (String)it.next();
	        System.out.println("key = "+key);
	        
	        String className = properties.getProperty(key);
	        System.out.println("className = "+className);
	        
	        try {
	           Class<?> classType = Class.forName(className);
	           Object ob = classType.newInstance();
	           
	           System.out.println("ob = "+ob);
	           
	           map.put(key, ob);
	           
	        } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	        } catch (InstantiationException e) {
	           e.printStackTrace();
	        } catch (IllegalAccessException e) {
	           e.printStackTrace();
	        } catch (IllegalArgumentException e) {
	           e.printStackTrace();
	        } 
	        
	        System.out.println();
	     }//while
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		
		//post 방식일 때 한글 인코딩
		if(request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
		
		//요청이 들어왔을 때 => http://localhost:8080/mvcmember/member/writeForm.do
		String category = request.getServletPath(); //요청한 주소의 뒷부분 가져옴 ↓
		System.out.println("category = "+category); // 출력결과: /member/writeForm.do
		
		//command.properties 파일에 등록된 key값과 value값을 매칭해 꺼내옴
		//member.service.WriteFormService
		CommandProcess com = (CommandProcess)map.get(category);
		String view = null;
		
		try {
		   view = com.requestPro(request, response); // "/member/writeForm.jsp"
		} catch (Throwable e) {
		   e.printStackTrace();
		}
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);//상대번지
		dispatcher.forward(request, response);//제어권 넘기기
	}
}
