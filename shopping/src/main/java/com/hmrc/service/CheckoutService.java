package com.hmrc.service;

import com.hmrc.domain.Product;

import java.util.List;

/**
 * Created by nitinafre on 27/04/2015.
 */
public interface CheckoutService {

	public Double checkout(List<Product> products);

}
