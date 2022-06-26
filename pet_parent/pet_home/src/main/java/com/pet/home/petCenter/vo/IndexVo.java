package com.pet.home.petCenter.vo;

import com.pet.home.admin.entity.TPromotion;
import com.pet.home.petCenter.entity.TPetInfo;
import lombok.Data;

import java.util.List;

/**
 * @ClassName IndexVo
 * @Description 首页数据VO
 * @Author RTID:236148
 * @Date 2021/8/26 22:58
 **/
@Data
public class IndexVo {
	//登录地址
	private String address;
	//头像url地址
	private String headImgUrl;
	//用户名称
	private String userName;
	//背景图片
	private String backgroundImgUrl;
	//推广位
	private List<TPromotion> promotionList;
	//宠物信息
	private List<TPetInfo> petInfoList;
}
