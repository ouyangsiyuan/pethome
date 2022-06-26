package com.pet.home.enumPackage;

import lombok.Getter;

/**
 * @ClassName ResultCodeEnum
 * @Description 返回码
 * @Author RTID:236148
 * @Date 2021/8/26 23:08
 **/
@Getter
public enum ResultCodeEnum {
	SUCCESS(true, 20000, "成功"),
	UNKNOWN_REASON(false, 20001, "未知错误");
	private Boolean success;
	private Integer code;
	private String message;

	ResultCodeEnum(Boolean success, Integer code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}
}
