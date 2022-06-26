package com.pet.home.petCenter.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author miller.ou
 * @since 2021-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TPetInfo对象", description = "")
public class TPetInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	@TableId(value = "ID", type = IdType.ID_WORKER_STR)
	private Integer id;

	@ApiModelProperty(value = "编号")
	private String adoptId;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "状态（0-待审核；1-待领养；2-已领养；3-已下架；4-已删除；5-已拒绝）")
	private String status;

	@ApiModelProperty(value = "物种（0-狗狗；1-猫猫；3-其他）")
	private String species;

	@ApiModelProperty(value = "品种")
	private String varieties;

	@ApiModelProperty(value = "名字")
	private String name;

	@ApiModelProperty(value = "年龄")
	private Integer age;

	@ApiModelProperty(value = "性别（0-GG；1-MM；2-不清楚）")
	private String sex;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "市")
	private String city;

	@ApiModelProperty(value = "区")
	private String area;

	@ApiModelProperty(value = "详细地址")
	private String address;

	@ApiModelProperty(value = "介绍")
	private String introduce;

	@ApiModelProperty(value = "领养方式（0-有偿领养；1-无偿领养）")
	private String adoptWay;

	@ApiModelProperty(value = "是否绝育（0-是；1-否；2-不清楚）")
	private String sterilization;

	@ApiModelProperty(value = "是否驱虫（0-是；1-否；2-不清楚）")
	private String insectRepellent;

	@ApiModelProperty(value = "是否疫苗（0-是；1-否；2-不清楚）")
	private String vaccine;

	@ApiModelProperty(value = "领养条件")
	private String adoptionConditions;

	@ApiModelProperty(value = "图片1URL")
	private String pictureUrl1;

	@ApiModelProperty(value = "图片2URL")
	private String pictureUrl2;

	@ApiModelProperty(value = "图片3URL")
	private String pictureUrl3;

	@ApiModelProperty(value = "图片4URL")
	private String pictureUrl4;

	@ApiModelProperty(value = "图片5URL")
	private String pictureUrl5;

	@ApiModelProperty(value = "赞数")
	private Integer praiseNum;

	@ApiModelProperty(value = "违法信息留证标识")
	private String violateLawFlag;

	@ApiModelProperty(value = "审核反馈")
	private String reviewFeedback;

	@ApiModelProperty(value = "创建人")
	private String createName;

	@ApiModelProperty(value = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;

	@ApiModelProperty(value = "修改人")
	private String updateName;

	@ApiModelProperty(value = "修改时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

	@ApiModelProperty(value = "版本号")
	@TableField("VARSION")
	private Integer varsion;

	@ApiModelProperty(value = "删除标识")
	@TableLogic
	private String delFlag;


}
