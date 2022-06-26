package com.pet.home;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName PetHomeApplication
 * @Description petHome启动类
 * @Author RTID:236148
 * @Date 2021/8/27 23:06
 **/

@SpringBootApplication
@MapperScan({"com.pet.home.*.mapper"})
@Slf4j
public class PetHomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetHomeApplication.class, args);
		log.info("ㄟ( ▔, ▔ )ㄏ终于启动成功了！！！o(￣皿￣///)");
	}
}
