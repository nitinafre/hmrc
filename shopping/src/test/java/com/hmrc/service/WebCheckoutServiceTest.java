package com.hmrc.service;

import com.hmrc.domain.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<Product, Integer> blankBasket = new HashMap<Product, Integer>();
		objectToTest.checkout(blankBasket);
	}

	@Test
	public void testSingleProductInBasket() {
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(p1, 1);
		assertEquals("The checkout calculation is flawed", new Double(10.0), objectToTest.checkout(basket));
	}

	/* This test can be changed if discounts are taken from the rules engine and more generic test cases can be added to verify the list of items. Apart from that the calculations can be verified using BDD*/
	@Test
	public void testMultipleSameProduct() {
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(p3, 4);
		assertEquals("The checkout calculation is flawed", new Double(120.0), objectToTest.checkout(basket));
	}

	@Test
	public void testMultipleProducts() {
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(p1, 1);
		basket.put(p2, 2);
		basket.put(p3, 3);
		basket.put(p4, 4);
		assertEquals("The checkout calculation is flawed", new Double(300.0), objectToTest.checkout(basket));
	}

	@Test
	public void testMultipleSameProductWithOrangeDiscounts() {
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(p2, 4);
		assertEquals("The checkout calculation is flawed and orange discount is not considered", new Double(60.0), objectToTest.checkout(basket));
		basket.clear();
		basket.put(p2, 3);
		assertEquals("The checkout calculation is flawed and orange discount is not considered", new Double(40.0), objectToTest.checkout(basket));
		basket.clear();
		basket.put(p2, 5);
		assertEquals("The checkout calculation is flawed and orange discount is not considered", new Double(80.0), objectToTest.checkout(basket));
		basket.clear();
		basket.put(p2, 6);
		assertEquals("The checkout calculation is flawed and orange discount is not considered", new Double(80.0), objectToTest.checkout(basket));
		basket.clear();
		basket.put(p2, 6000000);
		assertEquals("The checkout calculation is flawed and orange discount is not considered", new Double(80000000.0), objectToTest.checkout(basket));
	}

	@Test
	public void testMultipleApplesWithDiscounts() {
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(p1, 4);
		assertEquals("The checkout calculation is flawed and apple discount is not considered", new Double(20.0), objectToTest.checkout(basket));
	}

}
