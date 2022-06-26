package com.pet.home.petCenter.controller;

import com.pet.home.common.ResponseVo;
import com.pet.home.petCenter.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName IndexController
 * @Description 首页数据控制层
 * @Author RTID:236148
 * @Date 2021/8/26 22:57
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private IndexService indexService;

	/**
	 * @return com.pet.home.common.ResponseVo
	 * @Author RTID:236148
	 * @Description //获取首页相关数据
	 * @Date 23:35 2021/8/26
	 * @Param []
	 **/
	@GetMapping("/getIndexInfo")
	public ResponseVo getIndexInfo(@RequestBody Map<String, Object> params) {
		return ResponseVo.ok().data("indexVo", indexService.getIndexInfo(params));
	}
}
