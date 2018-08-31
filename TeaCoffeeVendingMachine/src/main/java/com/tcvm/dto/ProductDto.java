package com.tcvm.dto;

public class ProductDto {
	private String productName;
	private int productQuantity;
	private int productCost;

	public String getProductName() {
		return productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public int getProductCost() {
		return productCost;
	}

	public ProductDto(String productName, int productQuantity, int productCost) {
		super();
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productCost = productCost;
	}

}
