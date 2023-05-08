package person.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import person.bean.PersonDTO;
import person.service.PersonService;

// @RestController // HTML만 가능 (JSP 연결 불가)
@Controller
public class PersonController {
	@Autowired
	PersonService personService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("person/writeForm")
	public String writeForm() {
		return "/person/writeForm";
	}
	
	@GetMapping("person/list")
	public String list() {
		return "/person/list";
	}
	
	@PostMapping("person/write")
	public void write(@RequestParam MultipartFile img,
					  @ModelAttribute PersonDTO personDTO,
					  HttpSession session) {
		
		// 실제폴더
		String filePath = session.getServletContext().getRealPath("/storage");
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName); //파일 생성
		
		try {
			img.transferTo(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		personDTO.setPhoto(fileName);

		System.out.println(personDTO.getName());
		System.out.println(personDTO.getAge());
		System.out.println(personDTO.getPhoto());
		
		personService.write(personDTO);
	}
	
	@PostMapping("person/getList")
	public List<PersonDTO> getList() {
		return personService.getList();
	}
}
