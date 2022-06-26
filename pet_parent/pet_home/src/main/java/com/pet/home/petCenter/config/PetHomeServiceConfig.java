package com.pet.home.petCenter.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName PetHomeServiceConfig
 * @Description TODO
 * @Author RTID:236148
 * @Date 2021/8/27 22:52
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("com.pet.home.petCenter.mapper")
public class PetHomeServiceConfig {
	/**
	 * 逻辑删除插件
	 */
	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}
}
