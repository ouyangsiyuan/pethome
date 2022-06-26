package com.pet.home.common;

import com.pet.home.enumPackage.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResponseVo
 * @Description 统一返回结果
 * @Author RTID:236148
 * @Date 2021/8/26 23:03
 **/

@Data
@ApiModel(value = "全局统一返回结果")
public class ResponseVo {
	@ApiModelProperty(value = "是否成功")
	private Boolean success;
	@ApiModelProperty(value = "返回码")
	private Integer code;
	@ApiModelProperty(value = "返回消息")
	private String message;
	@ApiModelProperty(value = "返回数据")
	private Map<String, Object> data = new HashMap<>();

	private ResponseVo() {
	}

	public static ResponseVo ok() {
		ResponseVo r = new ResponseVo();
		r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
		r.setCode(ResultCodeEnum.SUCCESS.getCode());
		r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
		return r;
	}

	public static ResponseVo error() {
		ResponseVo r = new ResponseVo();
		r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
		r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
		r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
		return r;
	}

	public static ResponseVo setResult(ResultCodeEnum resultCodeEnum) {
		ResponseVo r = new ResponseVo();
		r.setSuccess(resultCodeEnum.getSuccess());
		r.setCode(resultCodeEnum.getCode());
		r.setMessage(resultCodeEnum.getMessage());
		return r;
	}

	public ResponseVo success(Boolean success) {
		this.setSuccess(success);
		return this;
	}

	public ResponseVo message(String message) {
		this.setMessage(message);
		return this;
	}

	public ResponseVo code(Integer code) {
		this.setCode(code);
		return this;
	}

	public ResponseVo data(String key, Object value) {
		this.data.put(key, value);
		return this;
	}

	public ResponseVo data(Map<String, Object> map) {
		this.setData(map);
		return this;
	}
}
