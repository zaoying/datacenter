package com.springcloud.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangzurong
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TeacherApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	   return application.sources(TeacherApplication.class);
	}
 
	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}
}
