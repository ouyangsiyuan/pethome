package com.pet.home.petCenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="TReliefStations对象", description="")
public class TReliefStations implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "名称")
    @TableField("SITE_NAME")
    private String siteName;

    @ApiModelProperty(value = "创始人")
    @TableField("FOUNDER")
    private String founder;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "创立时间")
    @TableField("SET_TIME")
    private Date setTime;

    @ApiModelProperty(value = "开户人")
    @TableField("ACCOUNT_HOLDER")
    private String accountHolder;

    @ApiModelProperty(value = "开户行")
    @TableField("OPENING_BANK")
    private String openingBank;

    @ApiModelProperty(value = "银行账号")
    @TableField("BANK_ID")
    private String bankId;

    @ApiModelProperty(value = "支付宝开户人名字")
    @TableField("ALIPAY_NAME")
    private String alipayName;

    @ApiModelProperty(value = "支付宝账号")
    @TableField("ALIPAY_ID")
    private String alipayId;

    @ApiModelProperty(value = "物资援助")
    @TableField("SUPPLIES_AID")
    private String suppliesAid;

    @ApiModelProperty(value = "介绍")
    @TableField("INTRODUCE")
    private String introduce;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATE_NAME")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "修改人")
    @TableField("UPDATE_NAME")
    private String updateName;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATE_DATE")
    private Date updateDate;

    @ApiModelProperty(value = "版本号")
    @TableField("VARSION")
    private Integer varsion;

    @ApiModelProperty(value = "删除标识")
    @TableField("DEL_FLAG")
    private String delFlag;


}
