package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.service.UserService;

@Controller 
@RequestMapping(value="user")
public class UserController2 {
	@Autowired
	private UserService userService;
	
	//파일 업로드
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
	//파일 업로드
	@GetMapping(value="uploadForm_Ajax")
	public String uploadForm_Ajax() {
		return "user/uploadForm_Ajax";
	}
	
	@PostMapping(value="upload", produces="text/html")
	@ResponseBody
	public String upload(@RequestParam MultipartFile img, HttpSession session) {
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		//System.out.println("파일 업로드 시 저장되는 경로 = " + filePath);
		//파일 업로드 시 저장되는 경로 = D:\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chapter06_SpringMaven\WEB-INF\storage
		
		//가상 폴더를 만들어 두 곳에 업로드할 수도 있음 (이클립스에서 편하게 확인하기 위한 용도)
		String filePath_virtual = "D:/Spring/workspace/chapter06_SpringMaven/src/main/webapp/WEB-INF/storage";
		
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		File file_virtual = new File(filePath_virtual, fileName);
		
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_virtual)); //파일 복사
			img.transferTo(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "<img src='../storage/" + fileName + "'width='300' height='300' />";
	}
}
