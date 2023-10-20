package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;  // mybatis
	
	@Autowired
	private StudentRepository studentRepository;  // JPA
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}

	// JPA
	// input:parameters output:StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp 있으면 생략 가능 LocalDateTime(kst) 
				.build();
		return studentRepository.save(student);
	}
}
