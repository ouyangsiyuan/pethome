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
@ApiModel(value="TAdoptInfo对象", description="")
public class TAdoptInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "领养信息编号")
    @TableField("ADOPT_ID")
    private Integer adoptId;

    @ApiModelProperty(value = "状态（0-待审核；1-已通过；2-已拒绝；3-已被别人领养）")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "性别（0-GG；1-MM；2-不清楚）")
    @TableField("SEX")
    private String sex;

    @ApiModelProperty(value = "联系方式")
    @TableField("CONTACT")
    private String contact;

    @ApiModelProperty(value = "省")
    @TableField("PROVINCE")
    private String province;

    @ApiModelProperty(value = "市")
    @TableField("CITY")
    private String city;

    @ApiModelProperty(value = "区/县")
    @TableField("AREA")
    private String area;

    @ApiModelProperty(value = "详细地址")
    @TableField("ADDRESS")
    private String address;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "留言")
    @TableField("MESSAGE")
    private String message;

    @ApiModelProperty(value = "反馈")
    @TableField("FEEDBACK")
    private String feedback;

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
