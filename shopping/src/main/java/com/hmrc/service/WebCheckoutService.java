package com.hmrc.service;

import com.hmrc.domain.Product;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by nitinafre on 27/04/2015.
 */
public class WebCheckoutService implements CheckoutService {

	@Override
	public Double checkout(Map<Product, Integer> products) {
		if (MapUtils.isEmpty(products)) {
			throw new IllegalArgumentException("Cannot checkout with empty basket");
		}

		Double checkoutAmount = 0.0;

		for (Product product : products.keySet()) {
			if (null != product.getUnitPrice())
				checkoutAmount = checkoutAmount + (product.getUnitPrice() * checkOffer(product.getId(), products.get(product)));
		}
		return checkoutAmount;
	}

	/* In order to avoid complex rule engine code, this simple approach is taken. It can be improvised using various rule engines tool (as it is generally very short timed and changed frequently)
	 * Later the return type can be changed to float to include offer like buy 1 get second half price.
	 *  */
	private int checkOffer(Integer productId, Integer count) {
		if (productId.equals(1)) { // Consider this as an Apple (buy 1 get 1 free)
			return (count / 2) + (count % 2);
		}
		if (productId.equals(2)) { // Consider this as an Orange (buy 2 get 1 free or 3 for price of 2)
			return ((count / 3) * 2) + (count % 3);
		}
		return count;
	}


}
