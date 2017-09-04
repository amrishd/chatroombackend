package com.chatroom.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.chatroom")
public class WebConfig {

	
	
		/*
		@Bean
		public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver= new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;

		}
		*/

		public void addResourceHandlers(ResourceHandlerRegistry registry)
		{
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
		}
		@Bean(name="multipartResolver")
		public CommonsMultipartResolver getCommonsMultipartResolver()
		{
	     return new CommonsMultipartResolver();
         }
	
}
