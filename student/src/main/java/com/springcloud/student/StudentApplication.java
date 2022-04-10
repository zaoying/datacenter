package com.springcloud.student;

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
public class StudentApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	   return application.sources(StudentApplication.class);
	}
 
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
}
