package com.timbuchalka.springdemo.domain;

import com.timbuchalka.springdemo.service.BusinessService;

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
	private String postalCode;
	private int employeeCount;
	private BusinessService businessService;

	// == constructors ==
	public Organization(String companyName, int yearOfIncorpotation_CP) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorpotation_CP;
		System.out.println("parameterized constructor called.");

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
	public void postConstruct() {
		System.out.println("Organization : postConstruct method called.");
	}

	public void preDestroy() {
		System.out.println("Organization : preDestroy method called.");
	}

	// == static factory methods ==

	/*
	 * <bean id="myorg" class="com.timbuchalka.springdemo.domain.Organization"
	 * scope="prototype" factory-method="createInstance">
	 */
	public static Organization createInstance(String companyName, int yearOfIncorpotation_CP) {
		System.out.println("static factory method invoked.");
		return new Organization(companyName, yearOfIncorpotation_CP);

	}

	// == public methods ==
	public String staticCorporateSlogan() {
		return "We build the ultimate driving machines!";
	}

	public String provideCorporateSlogan() {
		return businessService.offerService(companyName);
	}

	// == getters==
	public String getCompanyName() {
		return companyName;
	}

	// == setters ==
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called.");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmployeeCount called.");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called.");
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", businessService="
				+ businessService + "]";
	}
}
