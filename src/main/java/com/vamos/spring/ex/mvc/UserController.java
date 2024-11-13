package com.vamos.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.ex.mvc.domain.User;
import com.vamos.spring.ex.mvc.service.UserService;
@RequestMapping("/mvc/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
		// 사용자 정보를 request 파라미터로 전달받고, 저장하는 기능
//	@RequestMapping(path="/mvc/user/create", method=RequestMethod.POST)
	
	@PostMapping("/create")
	public  String createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce
			, Model model) {
		
//		int count = userService.addUser(name, birthday, email, introduce);
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		int count = userService.addUserByObject(user);
		
//		return "삽입 성공 : " + count + " id : " + user.getId();
		model.addAttribute("result",user);
		return "mvc/userInfo";
		
	}
	
	// html의 경로를 리턴 = String
	@GetMapping("/input")
	public String userInput() {
		return "mvc/userInput";
	}
	
	@GetMapping("/info")
	public String userInfo(Model model) {
		
		// 가장 최근에 등록한 사용자 정보 얻어오기
		User user = userService.getLastUser();
		
		// 리턴한 경로의 html에서 사용할 데이터를 model에 추가한다
		model.addAttribute("title","마지막 사용자 정보");
		model.addAttribute("result",user);
		
		return "mvc/userInfo";
	}

}
