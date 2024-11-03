package com.vamos.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamos.spring.ex.database.domain.UsedGoods;
import com.vamos.spring.ex.database.service.UsedGoodsService;

// request, response 처리
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	//used_goods 테이블의 모든 정보를 json으로 response에 담는다.
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		// 중고 물품 게시글 정보 얻어오기, 컨트롤러 담당이 아님 -> service -> repository

		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
	}
}
