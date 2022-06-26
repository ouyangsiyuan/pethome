package com.pet.home.petCenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.pet.home.admin.entity.TIndexImg;
import com.pet.home.admin.entity.TPromotion;
import com.pet.home.admin.service.TIndexImgService;
import com.pet.home.admin.service.TPromotionService;
import com.pet.home.common.ResponseVo;
import com.pet.home.petCenter.entity.TPetInfo;
import com.pet.home.petCenter.service.IndexService;
import com.pet.home.petCenter.service.TPetInfoService;
import com.pet.home.petCenter.vo.IndexVo;
import com.pet.home.user.entity.TUser;
import com.pet.home.user.service.TUserService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexServiceImpl
 * @Description TODO
 * @Author RTID:236148
 * @Date 2021/8/27 23:10
 * 如果ResultMode.succeed=true 【增加成功】，返回的ResultMode.model为相应所需要的数据,ResultMode.errCode为相应【增加成功】编码,ResultMode.errMsg为相应【增加成功】描述；
 * 否则ResultMode.succeed=false【增加失败】，返回的ResultMode.model为空或者null,      ResultMode.errCode为相应【增加失败】编码,ResultMode.errMsg为相应【增加失败】描述。
 **/
@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private TUserService tUserService;

	@Autowired
	private TPetInfoService tPetInfoService;

	@Autowired
	private TIndexImgService tIndexImgService;

	@Autowired
	private TPromotionService tPromotionService;

	@Override
	public IndexVo getIndexInfo(Map<String, Object> params) {
		//进入页面时申请定位权限，若用户未授权则默认“北京市”；若用户授权定位权限则调用 {定位功能} 获取用户当前登录地点
		IndexVo indexVo = new IndexVo();
		indexVo.setAddress("北京市");
		TUser user = tUserService.getById("");
		if (user != null) {
			//更新用户表登录信息
			TUser tUser = new TUser();
			tUser.setId(1);
			tUser.setLastLoginAddress("北京市");
			tUser.setLastLoginDate(new Date());
			tUserService.updateById(tUser);
			indexVo.setHeadImgUrl(user.getHeadImgUrl());
			indexVo.setUserName(user.getUserName());
		}

		//背景图片
		TIndexImg indexImg = tIndexImgService.getById("");
		if (indexImg != null) {
			indexVo.setBackgroundImgUrl(indexImg.getUrl());
		}

		//推广位
		QueryWrapper qwPro = new QueryWrapper();
		List<TPromotion> promotionList = tPromotionService.list(qwPro);
		if (CollectionUtils.isNotEmpty(promotionList)) {
			indexVo.setPromotionList(promotionList);
		}

		//宠物信息
		QueryWrapper qwPet = new QueryWrapper();
		String title = (String) params.get("title");
		qwPet.like("", title);
		List<TPetInfo> petInfoList = tPetInfoService.list(qwPet);
		if (CollectionUtils.isNotEmpty(petInfoList)) {
			indexVo.setPetInfoList(petInfoList);
		}
		return indexVo;
	}
}
