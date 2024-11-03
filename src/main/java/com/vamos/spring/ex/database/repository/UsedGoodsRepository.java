package com.vamos.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vamos.spring.ex.database.domain.UsedGoods;

// 데이터베이스 관련 처리
// mybatis Framework
@Mapper
public interface UsedGoodsRepository {
	// used_goods 테이블 모든 행 조회 -> 데이터 베이스 한행을 클래스로 저장 -> domain
	// return 타입이 domain에서 만든 클래스가 됨
	// 인터페이스이기 때문에 구현하기 위해서는 resources에 나뭇잎 mapper사용, 둘이 연결해줘야함
	// 이 메소드를 호출했을때 쿼리수행, 쿼리결과 리턴받을건데, 그 구현과정을 Mapper에서
	public List<UsedGoods> selectUsedGoodsList();
}
