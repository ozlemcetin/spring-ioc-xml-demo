package com.timbuchalka.springdemo.domain.product;

import java.util.Random;

public abstract class GenericProduct {

	private int priceRandomizer = 1000;

	public int calculatePrice() {
		Random random = new Random();
		int price = random.nextInt(priceRandomizer);
		return price;
	}
}
