package com.vamos.spring.ex.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.spring.ex.mybatis.domain.RealEstate;
import com.vamos.spring.ex.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	// 전달받은 id와 일치하는 부동산 매물 정보 얻어오기
	public RealEstate getRealEstate(int id) {
		// 전달받은 id와 일치하는 real_estate 행 조회
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		return realEstate;
	}
	
	// 전달받은 월세보다 낮은 매물정보를 얻어온다
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		// 전달받은 월세보다 낮은 매물을 real_estate에서 조회
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByAreaAndPrice(area, price);
		return realEstateList;
	}
}
