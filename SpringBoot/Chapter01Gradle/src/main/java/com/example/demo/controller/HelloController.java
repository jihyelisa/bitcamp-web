package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController 기본생성자");
	}
	
	@GetMapping(value="/hello")
	// @ResponseBody 필요 없음
	// 그냥 @Controller와 달리 @RestController는 return값이 주소가 아닌 문자열임을 자동으로 구분함
	public String hello(String name) {
		return "안녕하세요 " + name + "님";
	}
}
