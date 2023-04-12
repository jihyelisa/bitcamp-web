package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	@GetMapping(value="/sungJuk/input.do")
	public String input() {
		return "sungJuk/input";
	}
	
	@PostMapping(value="/sungJuk/result.do")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		model.addAttribute("name", sungJukDTO.getName());
		model.addAttribute("tot", sungJukDTO.getTot());
		model.addAttribute("avg", sungJukDTO.getAvg());
		return "sungJuk/result";
	}
}
