package com.tcvm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.tcvm.dto.ProductDto;

public class ProductRecord {

	private static List<ProductDto> list;

	private List<ProductDto> getProductArrayList() {
		if (list == null) {
			list = new ArrayList();
			list.add(new ProductDto("tea", 0, 0));
			list.add(new ProductDto("coffee", 0, 0));
			list.add(new ProductDto("black tea", 0, 0));
			list.add(new ProductDto("black coffee", 0, 0));
		}
		return list;
	}

	public void addProductInList(ProductDto product) {

		getProductArrayList().add(product);
	}

	public List<ProductDto> getProductList() {
		return getProductArrayList();
	}
}
