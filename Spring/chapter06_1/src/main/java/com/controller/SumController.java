package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.SumDTO;

@Controller
public class SumController {
	//@RequestMapping(value="/input.do", method=RequestMethod.POST)
	@GetMapping(value="/sum/input.do")
	public String input() {
		return "sum/input"; 
	}
	
	/* 방법1
	//@RequestMapping(value="/result.do", method=RequestMethod.GET)
	@PostMapping(value="/result.do")
	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("sum/result");
		return mav;
	}
	*/
	
	/* 방법2 - 사용자가 값을 입력하지 않았을 때 404 에러 방지를 위해 default 값 지정
	//@RequestMapping(value="/result.do", method=RequestMethod.GET)
	@PostMapping(value="/result.do")
	public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x,
							   @RequestParam(required = false, defaultValue = "0") String y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("sum/result");
		return mav;
	}
	*/
	
	/* 방법3
	@PostMapping(value="/result.do")
	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
		modelMap.put("x", map.get("x"));
		modelMap.put("y", map.get("y"));
		return "sum/result";
	}
	*/
	
	@PostMapping(value="/sum/result.do")
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
		return "sum/result";
	}

}
