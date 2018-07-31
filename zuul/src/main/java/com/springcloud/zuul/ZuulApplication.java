package com.springcloud.zuul;

import com.springcloud.zuul.filter.RateLimitFilter;
import com.springcloud.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author huangzurong
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    @Bean
    public RateLimitFilter rateLimitFilter(){
        return new RateLimitFilter();
    }

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
