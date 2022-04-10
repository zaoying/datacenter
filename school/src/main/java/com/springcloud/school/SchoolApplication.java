package com.springcloud.school;

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
public class SchoolApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	   return application.sources(SchoolApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
}
