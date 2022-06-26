package com.pet.home.petCenter.service;

import com.pet.home.petCenter.vo.IndexVo;

import java.util.Map;

public interface IndexService {
	/**
	 * @return com.pet.home.petCenter.vo.IndexVo
	 * @Author RTID:236148
	 * @Description //获取组装首页所需要的数据
	 * @Date 23:17 2021/8/27
	 * @Param [params]
	 **/
	IndexVo getIndexInfo(Map<String, Object> params);
}
