package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanCallbacksForOrganizationAppp {

	/*
	 * <bean id="myorg" class="com.timbuchalka.springdemo.domain.Organization"
	 * scope="prototype" destroy-method="destroy" init-method="initialize"> ...
	 * </bean>
	 */

	/*
	 * <beans xmlns="http://www.springframework.org/schema/beans" ...
	 * default-init-method="postConstruct" default-destroy-method="preDestroy"> ..
	 * </beans>
	 */
	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-def-in-classpath.xml");

		/*
		 * EcommerceServiceImpl : postConstruct method called.
		 * 
		 * parameterized constructor called.
		 * 
		 * setPostalCode called.
		 * 
		 * setEmployeeCount called.
		 * 
		 * setBusinessService called.
		 * 
		 * Organization : postConstruct method called.
		 * 
		 * EcommerceServiceImpl : preDestroy method called.
		 */
		
		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
