package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	// URL: http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	// URL: http://localhost/lesson05/ex02
	@GetMapping("/ex02")
	public String  ex02(Model model) {
		// List<String>
		List<String> fruits = List.of("apple", "melon", "peach", "grape", "mango");
		model.addAttribute("fruits", fruits);
		
		// List<Map<String, Object>>
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "pepper");
		user.put("age", 4);
		user.put("hobby", "ball");
		list.add(user);
		
		user = new HashMap<>();
		user.put("name", "salt");
		user.put("age", 5);
		user.put("hobby", "tug");
		list.add(user);
		
		model.addAttribute("users", list);
		
		return "lesson05/ex02";
	}
	
}
