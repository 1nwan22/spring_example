package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;


@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	// C U D
	@Autowired
	private StudentBO studentBO;
	
	// C:create, insert
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "후추";
		String phoneNumber = "010-2929-2929";
		String email = "pepper@pepper.com";
		String dreamJob = "강아지";
		
		// 지금 들어간 id 값도 바로 꺼낼 수 있다. getId(); select도 바로 해주는 것
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: update
	@GetMapping("/2")
	public StudentEntity update() {
		// id:4 dreamJob을 변경
		// JSON
		return studentBO.updateStudentDreamJobById(4, "디자이너");
	}
	
	// D: delete
	@GetMapping("/3")
	public String delete() {
		// id:7
		studentBO.deleteStudentById(7);
		return "삭제 완료";
	}
}
