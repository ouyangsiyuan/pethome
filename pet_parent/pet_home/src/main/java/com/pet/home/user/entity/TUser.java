package com.pet.home.user.entity;

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
@ApiModel(value="TUser对象", description="")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "账号")
    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty(value = "昵称")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "账号类型（1-个人；2-机构）")
    @TableField("ACCOUNT_TYPE")
    private String accountType;

    @ApiModelProperty(value = "状态（1-停用；2-启用）")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "手机号码")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "头像url地址")
    @TableField("HEAD_IMG_URL")
    private String headImgUrl;

    @ApiModelProperty(value = "最后登录日期")
    @TableField("LAST_LOGIN_DATE")
    private Date lastLoginDate;

    @ApiModelProperty(value = "最后登录地址")
    @TableField("LAST_LOGIN_ADDRESS")
    private String lastLoginAddress;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATE_NAME")
    private String createName;

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
