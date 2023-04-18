package user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@PostMapping(value="write")
	@ResponseBody //DispatcherServlet으로 돌아가지 못하게 막고, 데이터 형태를 JSON으로 변경해 ajax로 보냄
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
		//return ""; //return값을 단순 문자열이 아닌 파일명으로 인식
	}
	
	@PostMapping(value="isExistId")
	@ResponseBody
	public String isExistId(@RequestParam String id) {
		return userService.isExistId(id);
	}
	
	@GetMapping(value="list")
	public String list(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
		//DB를 거치지 않고 바로 화면에 틀만 띄움
		model.addAttribute("pg", pg);
		return "user/list";
	}
	
	@PostMapping(value="getUserList")
	@ResponseBody
	public Map<String, Object> getUserList(@RequestParam String pg) {
		return userService.getUserList(pg);
	}
	
	@GetMapping(value="updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@PostMapping(value="update")
	@ResponseBody
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
}
