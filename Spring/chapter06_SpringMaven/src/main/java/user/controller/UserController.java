package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(value="list")
	public String list() {
		//DB 필요 없음, 틀만 띄움
		return "user/list";
	}
	
	@PostMapping(value="getUserList")
	@ResponseBody
	public List<UserDTO> getUserList() {
		List<UserDTO> list = UserService.getUserList();
		return null;
	}
}
