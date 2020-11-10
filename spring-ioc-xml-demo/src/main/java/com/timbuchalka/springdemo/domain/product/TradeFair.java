package com.timbuchalka.springdemo.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeFair {

	private IndustrialProduct industrialProduct;
	private ConsumerProduct consumerProduct;

	// == constructor ==

	@Autowired
	public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
		this.industrialProduct = industrialProduct;
		this.consumerProduct = consumerProduct;
	}

	// == setters ==

//	@Autowired
//	public void setIndustrialProduct(IndustrialProduct industrialProduct) {
//		this.industrialProduct = industrialProduct;
//	}
//

//	@Autowired
//	public void setConsumerProduct(ConsumerProduct consumerProduct) {
//		this.consumerProduct = consumerProduct;
//	}

	// == public methods ==
	public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}

	public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}

	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product is priced at $" + declareIndustrialProductPrice(industrialProduct)
				+ " and " + "Consumer Product is priced at $" + declareConsumerProductPrice(consumerProduct);
		return priceInfo;
	}
}
