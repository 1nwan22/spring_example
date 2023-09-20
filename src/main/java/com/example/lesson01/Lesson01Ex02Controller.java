package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp를 뿌릴 때는 @ResponseBody가 없는 @Controller를 사용해야하 한다.
public class Lesson01Ex02Controller {
	
	// 요청 URL: http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() { // jsp는 스트링
		// jsp 경로를 리턴한다.
		//return "/WEB-INF/jsp/lesson01/ex02.jsp";
		//  /WEB-INF/  중간 경로    .jsp
		return "lesson01/ex02"; // jsp view 경로와 이름   request - response 주소는 연관 관계가 없음
	}
}
