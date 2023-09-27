package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// URL: http://localhost/lesson04/ex02/add-student-view
	// 학생 정보 추가 화면
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 가입 처리 후 가입된 사람 정보 뿌려주기
	// URL: http://localhost/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, // 태그의 name 속성과 일치하는 필드에 매핑된다.
			Model model
			) {
		
		// DB insert
		studentBO.addStudent(student); // stack에서 heap을 참조하는 주소는 같기 때문에 DB insert를 거쳐서 올라오면서 data가 채워져 있다
	
		
		// DB select => 방금 가입된 사람 //mybatis 문법 세션안이기 때문에 insert하고 select해도 같은 범주안에 있기 때문에 방금 넣은 것을 select 할 수 있다
//		int id = student.getId();
		Student latestStudent = studentBO.getStudentById(student.getId());
		model.addAttribute("student", latestStudent);
		
		return "lesson04/afterAddStudent";
	}
}
