package com.pet.home.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @ClassName PetHomeMetaHandler
 * @Description TODO
 * @Author RTID:236148
 * @Date 2021/8/27 22:43
 * 如果ResultMode.succeed=true 【增加成功】，返回的ResultMode.model为相应所需要的数据,ResultMode.errCode为相应【增加成功】编码,ResultMode.errMsg为相应【增加成功】描述；
 * 否则ResultMode.succeed=false【增加失败】，返回的ResultMode.model为空或者null,      ResultMode.errCode为相应【增加失败】编码,ResultMode.errMsg为相应【增加失败】描述。
 **/
public class PetHomeMetaHandler  implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
//		this.setFieldValByName()
	}

	@Override
	public void updateFill(MetaObject metaObject) {

	}
}
