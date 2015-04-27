package com.hmrc.domain;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by nitinafre on 27/04/2015.
 */
public class ProductTest {

	private Product p1 = new Product(1, "Product 1", 10.0);
	private Product p11 = new Product(1, "Product 1", 10.0);
	private Product p111 = new Product(1, "Product 1", 10.0);
	private Product p2 = new Product(2, "Product 2", 20.0);
	private Product p3 = new Product(3, "Product 3", 30.0);
	private Product p4 = new Product(4, "Product 4", 40.0);


	@Test
	public void testToItself() {
		assertTrue("Product 1 should be equal to itself", p1.equals(p1));
		assertTrue("Product 2 should be equal to itself", p2.equals(p2));
		assertTrue("Product 3 should be equal to itself", p3.equals(p3));
		assertTrue("Product 4 should be equal to itself", p4.equals(p4));
	}

	@Test
	public void testIncompatible() {
		assertFalse("Incompatible products. Should not be equal.", p1.equals(p2));
	}

	@Test
	public void testCompareNull() {
		assertFalse("Should return false with null", p1.equals(null));
	}

	@Test
	public void testSymmetric() {
		assertTrue("Should be equal reflexive products", p1.equals(p11));
		assertTrue("Should be equal symmetrical products", p11.equals(p1));
	}

	@Test
	public void testTransitive() {
		assertTrue("Should be equal transitive products", p1.equals(p11));
		assertTrue("Should be equal transitive products", p11.equals(p111));
		assertTrue("Should be equal transitive products", p111.equals(p1));
	}

	@Test
	public void testConsistent() {
		assertTrue("Should be equal consistently", p1.equals(p11));
		assertTrue("Should be equal consistently", p1.equals(p11));
		assertTrue("Should be equal consistently", p1.equals(p11));
		assertTrue("Should be equal consistently", p1.equals(p11));
		assertFalse("Should be equal inconsistently", p1.equals(p2));
		assertFalse("Should be equal inconsistently", p1.equals(p2));
		assertFalse("Should be equal inconsistently", p1.equals(p2));
		assertFalse("Should be equal inconsistently", p1.equals(p2));
		assertFalse("Should be equal inconsistently", p1.equals(p2));
		assertFalse("Should be equal inconsistently", p1.equals(p3));
		assertFalse("Should be equal inconsistently", p1.equals(p3));
		assertFalse("Should be equal inconsistently", p1.equals(p3));
		assertFalse("Should be equal inconsistently", p1.equals(p3));
		assertFalse("Should be equal inconsistently", p1.equals(p3));
	}
}
