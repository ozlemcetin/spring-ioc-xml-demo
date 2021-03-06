package com.timbuchalka.springdemo.domain;

public class OrganizationFactory {

	// == factory methods ==

	/*
	 * <bean id="myorg" class="com.timbuchalka.springdemo.domain.Organization"
	 * scope="prototype" factory-method="Instanetce"
	 * factory-bean="organizationFactory">
	 */
	public Organization getInstance(String companyName, int yearOfIncorpotation_CP, String postalCode) {
		System.out.println("OrganizationFactory getInstance factory method invoked.");
		return new Organization(companyName, yearOfIncorpotation_CP, postalCode);

	}

}
