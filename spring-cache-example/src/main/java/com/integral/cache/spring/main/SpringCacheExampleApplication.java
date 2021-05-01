package com.integral.cache.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.integral.cache")
public class SpringCacheExampleApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringCacheExampleApplication.class, args);
	}
}
