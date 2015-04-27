package com.hmrc.service;

import com.hmrc.domain.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nitinafre on 27/04/2015.
 */
public class WebCheckoutServiceTest {

	private Product p1 = new Product(1, "Product 1", 10.0);
	private Product p2 = new Product(2, "Product 2", 20.0);
	private Product p3 = new Product(3, "Product 3", 30.0);
	private Product p4 = new Product(4, "Product 4", 40.0);

	private CheckoutService objectToTest = new WebCheckoutService();

	@Test (expected = IllegalArgumentException.class)
	public void testNullList() {
		objectToTest.checkout(null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testWithBlankBasket() {
		List<Product> blankBasket = new ArrayList<Product>();
		objectToTest.checkout(blankBasket);
	}

	@Test
	public void testSingleProductInBasket() {
		List<Product> basket = new ArrayList<Product>();
		basket.add(p1);
		assertEquals("The checkout calculation is flawed", new Double(10.0), objectToTest.checkout(basket));
	}

	@Test
	public void testMultipleSameProduct() {
		List<Product> basket = new ArrayList<Product>();
		basket.add(p1);
		basket.add(p1);
		basket.add(p1);
		basket.add(p1);
		assertEquals("The checkout calculation is flawed", new Double(40.0), objectToTest.checkout(basket));
	}

	@Test
	public void testMultipleProducts() {
		List<Product> basket = new ArrayList<Product>();
		basket.add(p1);
		basket.add(p2);
		basket.add(p3);
		basket.add(p4);
		assertEquals("The checkout calculation is flawed", new Double(100.0), objectToTest.checkout(basket));
	}

}
