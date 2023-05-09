package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@PostMapping("write")
	public String write(@ModelAttribute UserDTO userDTO) {
		return "user/writeForm";
	}
}
