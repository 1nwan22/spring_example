package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {
	
	// input(Controller로부터 요청 받음): X (조건 없이 전부 달라함)
	// output(Controller에게 돌려줌): List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		
		return
	}
}
