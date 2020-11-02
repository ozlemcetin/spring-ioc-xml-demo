package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;

public class SingletonPrototypeScopeForOrganizationAppp {

	/*
	 * <bean id="myorg" class="com.timbuchalka.springdemo.domain.Organization"
	 * scope="singleton">
	 * ...
	 * </bean>
	 */
	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-def-in-classpath.xml");

		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");

		// see the created bean
		System.out.println(org);

		Organization orgAnother = (Organization) ctx.getBean("myorg");
		orgAnother.setPostalCode("98989");

		// see the created bean
		System.out.println(org);
		System.out.println(orgAnother);

		if (org == orgAnother) {
			System.out.println("Singletpn Scope Test : Both Org Variables Point to the Same Instance!");
		}else {
			System.out.println("Prototype Scope Test : They are Separate Instances!");
		}

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
