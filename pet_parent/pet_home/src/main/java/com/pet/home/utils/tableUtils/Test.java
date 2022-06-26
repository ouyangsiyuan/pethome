package com.pet.home.utils.tableUtils;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Test
 * @Description TODO
 * @Author RTID:236148
 * @Date 2021/8/26 22:40
 * 如果ResultMode.succeed=true 【增加成功】，返回的ResultMode.model为相应所需要的数据,ResultMode.errCode为相应【增加成功】编码,ResultMode.errMsg为相应【增加成功】描述；
 * 否则ResultMode.succeed=false【增加失败】，返回的ResultMode.model为空或者null,      ResultMode.errCode为相应【增加失败】编码,ResultMode.errMsg为相应【增加失败】描述。
 **/
@Data
public class Test implements Serializable {
	private  int id;
	private String name;
}
