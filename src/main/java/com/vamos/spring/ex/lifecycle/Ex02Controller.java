package com.vamos.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")
	public String thymeleafEx() {
		//해당 주소에 찾아가서 실행시킨걸 문자열로 만들어전송할것이라 리스폰바디X
		// 앞에 슬래시도 없음
		return "lifecycle/ex02";
	}
}
