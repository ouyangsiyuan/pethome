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
@ApiModel(value="TIndexImg对象", description="")
public class TIndexImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "配图类型（0-页面顶部横图）")
    @TableField("IMG_TYPE")
    private String imgType;

    @ApiModelProperty(value = "图片url")
    @TableField("URL")
    private String url;

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
