package com.luwei.bbs;

import com.luwei.bbs.filter.EncodingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ServletComponentScan
@SpringBootApplication
public class BbsApplication {
	@Bean
	public FilterRegistrationBean registrationBean(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(this.encodingFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("encoder", "utf-8");
		filterRegistrationBean.setName("EncodingFilter");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
	@Bean(name = "EncodingFilter")
	public EncodingFilter encodingFilter(){
		return new EncodingFilter();
	}
	public static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args);
	}

}
