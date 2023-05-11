package user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@GetMapping("list")
	public String list() {
		return "user/list";
	}
	
	@GetMapping("updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@GetMapping("deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	@PostMapping("write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@PostMapping("isExistId")
	@ResponseBody
	public String isExistId(@RequestParam String id) {
		return userService.isExistId(id);
	}
	
	@PostMapping("getList")
	@ResponseBody
	public List<UserDTO> getList() {
		return userService.getList();
	}
	
	@PostMapping("search")
	@ResponseBody
	public List<UserDTO> search(@RequestParam Map<String, String> map) {
		return userService.search(map);
	}
	
	@PostMapping("searchById")
	@ResponseBody
	public Optional<UserDTO> searchById(@RequestParam String searchId) {
		return userService.searchById(searchId);
	}
	
	@PostMapping("delete")
	@ResponseBody
	public String delete(@RequestParam Map<String, String> map) {
		System.out.println("컨트롤러");
		System.out.println(map);
		return userService.delete(map);
	}
}
