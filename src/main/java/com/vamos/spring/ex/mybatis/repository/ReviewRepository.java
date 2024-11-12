package com.vamos.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vamos.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	// 전달된 id와 일치하는 리뷰 행 조회
	// 파레메터를 xml로 전달하여 사용할때 사용할 이름 지정 @Param("")
	public Review selectReview(@Param("id")int id);
	
	//  전달받은 리뷰 정보를 기반으로 insert 한다
	// insert는 행의 개수가 리턴되기때문에 int
	public int insertReview(
			@Param("storeId")int storeId
			,@Param("menu") String menu
			,@Param("userName") String userName
			,@Param("point") double point
			,@Param("review") String review);
	
	
	// 전달받은 Review 객체로 insert 한다
	public int insertReviewByObject(Review review);
}
