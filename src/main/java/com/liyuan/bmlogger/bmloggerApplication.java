package com.liyuan.bmlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class bmloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(bmloggerApplication.class, args);
	}
}