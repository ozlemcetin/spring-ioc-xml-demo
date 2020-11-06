package com.timbuchalka.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.timbuchalka.springdemo.domain.Address;
import com.timbuchalka.springdemo.service.BusinessService;
import com.timbuchalka.springdemo.serviceimpl.CloudServiceImpl;

@Configuration
@ComponentScan("com.timbuchalka.springdemo")
@PropertySource(value = { "classpath:properties/organization.properties" })
public class PropertyConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public static Address address() {
		return new Address("Blue Berry Lane", "Los Angeles" , "75757");
	}

	@Bean
	public static BusinessService cloudService() {
		return new CloudServiceImpl();
	}

}
