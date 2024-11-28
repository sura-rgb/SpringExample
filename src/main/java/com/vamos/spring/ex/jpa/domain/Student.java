package com.vamos.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder(toBuilder=true) // 원하는 멤버변수로만 생성
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 멤버변수를 전달받아서 값을 세팅하는 생성자
@Getter
@Table(name="`new_student`") // 이클래스가 어떤 테이블과 연동되는지
@Entity // 요놈이 ntt클래스다 정확히 알리는용도
public class Student {
	
	@Id //프라이머리키에 대응되는 멤버변수에 컬럼에대한 정보를 매칭
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 
	private int id;
	private String name;
	
	// 데이터 베이스의 기본 규격인 스네이크 케이스 기반으로 매칭을 시키려고 시도하나, 우리는 그방식이 아니기때문에
	// 카멜 케이스로 되어있는 컬럼에 매칭되는 멤버변수에만 @Column
	// snake_case
	// camelCase
	// PascalCase
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@Column(name="createdAt")
	@CreationTimestamp // 대응되는 컬럼의 값을 인서트할때 알아서 채워준다 시간을
	private LocalDateTime createdAt;
	
	
	@Column(name="updatedAt")
	@UpdateTimestamp // 업데이트할때 알아서 채워줌
	private LocalDateTime updatedAt;
	
	
}
