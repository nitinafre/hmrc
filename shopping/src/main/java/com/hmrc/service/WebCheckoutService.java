package com.hmrc.service;

import com.hmrc.domain.Product;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nitinafre on 27/04/2015.
 */
public class WebCheckoutService implements CheckoutService {

	@Override
	public Double checkout(List<Product> products) {
		if (CollectionUtils.isEmpty(products)) {
			throw new IllegalArgumentException("Cannot checkout with empty basket");
		}
		assert null != products;
		Double checkoutAmount = 0.0;

		for (Product product : products) {
			if (null != product.getUnitPrice())
				checkoutAmount = checkoutAmount + product.getUnitPrice();
		}
		return checkoutAmount;
	}


}
