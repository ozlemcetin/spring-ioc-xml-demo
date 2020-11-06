package com.timbuchalka.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.timbuchalka.springdemo.service.BusinessService;

@Component("myorg")
public class Organization {

	/*
	 * Well what we can do is,
	 * 
	 * we do an inversion of control.
	 * 
	 * So that is we take away the control
	 * 
	 * of object instantiation from Cooperation
	 * 
	 * and we hand it over to an ObjectFactory.
	 * 
	 * And as an example of that would be the Spring container.
	 */

	// == fields ==

	private String companyName;

	private int yearOfIncorporation;

	private Address address;

	// @Value("${org.employeeCount}")
	private int employeeCount;

	private BusinessService businessService;

	@Value("${org.slogan:We build world class software!}")
	private String slogan;

	private String missionStatement;

	@Autowired
	private Environment environment;

	// == constructors ==

	@Autowired
	public Organization(@Value("${org.companyName}") String companyName,
			@Value("${org.yearOfIncorporation}") int yearOfIncorpotation_CP, Address address) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorpotation_CP;
		this.address = address;
		// System.out.println("parameterized constructor called.");

	}

	// == bean life cycle methods ==

	/*
	 * <bean id="myorg" class="com.timbuchalka.springdemo.domain.Organization"
	 * scope="prototype" destroy-method="destroy" init-method="initialize">
	 */

	/*
	 * public void initialize() {
	 * System.out.println("Organization : initialize method called."); }
	 * 
	 * public void destroy() {
	 * System.out.println("Organization : destroy method called."); }
	 */

	// == bean life cycle methods ==

	/*
	 * <beans xmlns="http://www.springframework.org/schema/beans" ...
	 * default-init-method="postConstruct" default-destroy-method="preDestroy">
	 */

	/*
	 * public void postConstruct() {
	 * System.out.println("Organization : postConstruct method called."); }
	 * 
	 * public void preDestroy() {
	 * System.out.println("Organization : preDestroy method called."); }
	 */

	// == static factory methods ==

	/*
	 * <bean id="myorg" class="com.timbuchalka.springdemo.domain.Organization"
	 * scope="prototype" factory-method="createInstance">
	 */

	/*
	 * public static Organization createInstance(String companyName, int
	 * yearOfIncorpotation_CP) { // System.out.println("Organization static
	 * createInstance factory method // invoked."); return new
	 * Organization(companyName, yearOfIncorpotation_CP);
	 * 
	 * }
	 */

	// == public methods ==
	public String staticCorporateSlogan() {
		missionStatement = environment.getProperty("missionStatement");
		return slogan + " " + missionStatement + " And also we build the ultimate driving machines!";
	}

	public String provideCorporateSlogan() {
		return businessService.offerService(companyName);
	}

	// == getters==
	public String getCompanyName() {
		return companyName;
	}

	// == setters ==
	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * @Autowired is used for the setter injection
	 */

	@Autowired
	public void setEmployeeCount(@Value("${org.employeeCount}") int employeeCount) {
		this.employeeCount = employeeCount;
		// System.out.println("setEmployeeCount called.");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		// System.out.println("setBusinessService called.");
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", address=" + address + ", employeeCount=" + employeeCount + ", businessService=" + businessService
				+ "]";
	}
}
