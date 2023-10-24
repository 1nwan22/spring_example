package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	// Spring Data JPA: JpaRepository  기본 메소드 생성 (C U D )
	
	// save() - insert
	// save(객체)  - update
	// findById() - select
	// delete() - delete
	// findAll() - 전체 조회
	
	// JPQL 문법 - ex02/1 !! Console에 쿼리문 찍힌 거 보기
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	// ex02/2
	// 1) JPQL 엔티티로 조회
	//@Query(value = "select st from new_student st where st.dreamJob = :dreamJob") // :dreamJob = @Param("dreamJob")
	
	// 2) native query로 조회
	@Query(value = "select * from `new_student` where dreamJob = :dreamJob", nativeQuery=true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); // import org.springframework.data.repository.query.Param;
	
	
	
}
