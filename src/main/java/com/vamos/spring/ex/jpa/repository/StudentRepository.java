package com.vamos.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vamos.spring.ex.jpa.domain.Student;

// Student = ntt클래스에 대응되는	 테이블을 위한 레파지토리로 세팅된다
// primary키 타입 = Integer
public interface StudentRepository extends JpaRepository<Student, Integer>{

	// id기준으로 내림차순 정렬된 결과 조회
	// ORDER BY `id` DESC
	public List<Student> findAllByOrderByIdDesc();
	
	// id기준으로 내림차순으로 정렬된 결과를 2개만 조회
	// ORDER BY `id` DESC LIMIT 2
	public List<Student> findTop2ByOrderByIdDesc();
	
	// 전달받은 이름과 일치하는 행 조회
	// WHERE `name` = #{name}
	public List<Student> findByName(String name);
	
	// 전달받은 이름들과 일치하는 행 조회
	// WHERE `name` IN (#{},#{})
	public List<Student> findByNameIn(List<String> nameList);
	
	
	// 전달받은 키워드가 포함된 email컬럼을 가진 행조회
	// WHERE `email` LIKE `%${keyword}%`;
	public List<Student> findByEmailContaining(String keyword);
	
	// id 컬럼 값이 특정한 값들 사이에 포함되는 행을 id기반으로 내림차순해서 조회
	// WHERE `id` BETWEEN 1 AND 3 ORDER BY `id` DESC;
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	
	// 쿼리를 직접작성
	// Native Query
	// dreamJob 일치하는 행조회
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> selectByDreamJob(@Param("dreamJob")String dreamJob);
}
