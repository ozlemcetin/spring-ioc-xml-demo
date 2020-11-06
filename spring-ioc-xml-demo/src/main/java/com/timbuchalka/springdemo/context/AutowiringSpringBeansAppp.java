package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.promotion.TradeFair;

public class AutowiringSpringBeansAppp {

	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-def-in-classpath.xml");

		TradeFair fair = (TradeFair) ctx.getBean("tradeFair");
		System.out.println(fair.specialPromotionalPricing());

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
