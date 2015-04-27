package com.hmrc.domain;

/**
 * Created by nitinafre on 27/04/2015.
 */
public class Product {

	private Integer id;
	private String name;
	private Double unitPrice;

	public Product(Integer id, String name, Double unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int hashCode() {
		return id.hashCode();
	}

	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}
		if (!(o instanceof Product)) {
			return false;
		}

		Product p = (Product) o;
		return this.id.equals(p.getId());
	}
}
