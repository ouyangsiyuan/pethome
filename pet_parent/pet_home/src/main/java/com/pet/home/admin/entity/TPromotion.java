package com.pet.home.admin.entity;

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
@ApiModel(value="TPromotion对象", description="")
public class TPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "标题")
    @TableField("TITLE")
    private String title;

    @ApiModelProperty(value = "链接")
    @TableField("LINK")
    private String link;

    @ApiModelProperty(value = "编号（0-推广位1；1-推广位2；2-推广位3；3-推广位4；4-手机推广位1；5-手机推广位2）")
    @TableField("CODE")
    private String code;

    @ApiModelProperty(value = "图片1URL")
    @TableField("PICTURE_URL_1")
    private String pictureUrl1;

    @ApiModelProperty(value = "图片2URL")
    @TableField("PICTURE_URL_2")
    private String pictureUrl2;

    @ApiModelProperty(value = "图片3URL")
    @TableField("PICTURE_URL_3")
    private String pictureUrl3;

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
