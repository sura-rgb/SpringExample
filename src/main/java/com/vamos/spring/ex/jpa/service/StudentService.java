package com.vamos.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.spring.ex.jpa.domain.Student;
import com.vamos.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		// name = 멤버변수값, 뒤의 name = 파라메터 값 ex("김인규")	
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		
		// ntt 클래스 객체를 통해 ntt 클래스 객체를 생성해서 멤버변수 값을 채우면
		// 그 멤버변수에 대응되는 컬럼에 매칭이된 인서트 쿼리를 알아서 만들어서 인서트까지 진행
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// update 대상을 조회한다.
		// 조회된 결과 객체를 얻어온다.
		// 조회된 객체에서 수정사항을 적용한다.
		// 수정된 객체를 저장한다.
		
		// Optional 객체
		// null 일 수도 있는 객체를 null을 처리하는 기능으로 감싸놓은 객체
		// null 을 다룰때 발생될수 있는 NullPointerException 위험없이 처리하도록 도와준다.
		// null일수도 있는 객체를 리턴하는 메소드에서 리턴타입으로 주로 사용
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		// Optional안에 들어있는 <Student>가 null인 경우 어떻게 처리할지, 어떤값으로 리턴할지 지정
		// 즉, orElse가 리턴하는 값이 있을땐 실제 스튜던트 객체가 리턴, 없으면 인자로 전달된 값(new Student())이 리턴이된다
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();		
		
		// 세이브에 전달된 ntt클래스의 객체에 프라이머리키에 대응되는 멤버변수가 매칭되어있지 않으면 인서트,
		// 프라이머리키에 대응되는 멤버변수가 값이 매칭되어 있으면 업데이트 쿼리로 실행
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	public void deleteStudent(int id) {
		// 삭제대상을 조회한다.
		// 조회된 객체를 통해 삭제한다.
		// findById = 프라이머리 키를 통해 대응되는 한행을 리턴해주는 메소드
		// 대상이 되는 id를 파라메터로 전달해서 조회
		// But, findById로 조회한결과가 null일 가능성이 높기때문에
		// Optional객체로 리턴해준다
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
	}
	
	
	
	
}
