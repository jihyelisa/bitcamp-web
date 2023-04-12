package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //사용자가 만든 콜백 메소드 (직접 호출 없이 자동 실행)
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello, Spring!");
		//↑ 이것과 같은 역할 - request.setAttribute("result", "Hello, Spring!");
		mav.setViewName("/hello");
		return mav;
	}
	
	@RequestMapping(value="/hello2.do", method=RequestMethod.GET)
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result2", "Have a nice day!");
		mav.setViewName("../WEB-INF/view2/hello2");
		//WEB-INF 안에 넣으면 jsp 파일을 직접 호출 불가 (.do로만 호출 가능)
		return mav;
	}
	
	@RequestMapping(value="/hello3.do", method=RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello3() {
		return "환영합니다";
		//return 타입이 String이면 파일명으로 인식
		//리턴된 String 값을 단순 문자열로 인식시키려면 @ResponseBody 사용
	}
}

/*
콜백 메소드란?
특정 시점에 운영체제, 스프링에 의해 호출되는 메소드
 */

/*
http://localhost:8080/Context명(Project명)/hello.do - 요청

DispatcherServlet

	↕ HandlerMapping

HelloController.java
*/