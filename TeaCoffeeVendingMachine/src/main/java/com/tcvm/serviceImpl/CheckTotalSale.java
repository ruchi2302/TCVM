package com.tcvm.serviceImpl;

import java.io.IOException;

public class CheckTotalSale {
	public CheckTotalSale() {
		// TODO Auto-generated constructor stub
	}

	ProductRecord productRecord = new ProductRecord();

	public void productTotalSale() throws IOException {

		System.out.println(productRecord.getProductList().size());

		int totalTeaSaleQuantity = productRecord.getProductList().stream().filter(p -> p.getProductName().equals("tea"))
				.map(p -> p.getProductQuantity()).reduce(Integer::sum).get();

		int totalCoffeeSaleQuantity = productRecord.getProductList().stream()
				.filter(p -> p.getProductName().equals("coffee")).map(p -> p.getProductQuantity()).reduce(Integer::sum)
				.get();

		int totalBlackTeaSaleQuantity = productRecord.getProductList().stream()
				.filter(p -> p.getProductName().equals("black tea")).map(p -> p.getProductQuantity())
				.reduce(Integer::sum).get();

		int totalBlackCoffeeSaleQuantity = productRecord.getProductList().stream()
				.filter(p -> p.getProductName().equals("black coffee")).map(p -> p.getProductQuantity())
				.reduce(Integer::sum).get();

		int totalTeaSaleCost = productRecord.getProductList().stream().filter(p -> p.getProductName().equals("tea"))
				.map(p -> p.getProductCost()).reduce(Integer::sum).get();

		int totalCoffeeSaleCost = productRecord.getProductList().stream().filter(p -> p.getProductName().equals("tea"))
				.map(p -> p.getProductCost()).reduce(Integer::sum).get();

		int totalBlackTeaSaleCost = productRecord.getProductList().stream()
				.filter(p -> p.getProductName().equals("tea")).map(p -> p.getProductCost()).reduce(Integer::sum).get();

		int totalBlackCoffeeSaleCost = productRecord.getProductList().stream()
				.filter(p -> p.getProductName().equals("tea")).map(p -> p.getProductCost()).reduce(Integer::sum).get();

		int totalSaleCost = productRecord.getProductList().stream().filter(p -> p.getProductName().equals("tea"))
				.map(p -> p.getProductCost()).reduce(Integer::sum).get();

		System.out.println("Total TEA quantity = " + totalTeaSaleQuantity + ", price = " + totalTeaSaleCost);
		System.out.println("Total COFFEE quantity = " + totalCoffeeSaleQuantity + ", price = " + totalCoffeeSaleCost);
		System.out.println(
				"Total BLACKTEA quantity = " + totalBlackTeaSaleQuantity + ", price = " + totalBlackTeaSaleCost);
		System.out.println("Total BLACKCOFFEE quantity = " + totalBlackCoffeeSaleQuantity + ", price = "
				+ totalBlackCoffeeSaleCost);
		System.out.println("Total of All Product Sale Cost = " + totalSaleCost);

		// productRecord.getProductList().forEach(System.out::println);

	}

}
