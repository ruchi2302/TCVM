package com.tcvm.dto;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;
import com.tcvm.service.TCVMMakingDrink;
import com.tcvm.serviceImpl.ProductRecord;
import com.tcvm.serviceImpl.WasteProductRecord;

public class MakeBlackCoffee implements TCVMMakingDrink {

	final int BLACK_COFFEE_PRICE = 10;
	final static int COFFEE = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;

	final static int WASTE_BLACK_COFFEE = 1;
	final static int WASTE_WATER = 5;
	final static int WASTE_SUGAR = 2;

	ContainerController containerController;
	ProductRecord productRecord;
	WasteProductRecord wasteProductRecord;
	AllDrinkAvailability drinkAvailability;

	public MakeBlackCoffee() {

		containerController = new ContainerController();
		productRecord = new ProductRecord();
		wasteProductRecord = new WasteProductRecord();

	}

	public MakeBlackCoffee(ContainerController containerController, ProductRecord productRecord,
			WasteProductRecord wasteProductRecord) {
		super();
		this.containerController = containerController;
		this.productRecord = productRecord;
		this.wasteProductRecord = wasteProductRecord;
	}

	
	public void makeProcess(int productQuantity) throws IOException {

		int coffeeAvailableQuantity = containerController.getContainerInstance().getTeaContainer();
		int waterAvailableQuantity = containerController.getContainerInstance().getWaterContainer();
		int sugarAvailableQuantity = containerController.getContainerInstance().getSugarContainer();

		updateQuantity(productQuantity, coffeeAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord
				.addProductInList(new ProductDto("black tea", productQuantity, productQuantity * BLACK_COFFEE_PRICE));

		System.out.println(productQuantity + " cup blak tea " + productQuantity + "*" + BLACK_COFFEE_PRICE + " = "
				+ productQuantity * BLACK_COFFEE_PRICE);
	}

	public void updateQuantity(int productQuantity, int coffeeAvailableQuantity, int waterAvailableQuantity,
			int sugarAvailableQuantity) throws IOException {

		int remainingCoffeeQuantity = substractQuantity(coffeeAvailableQuantity, COFFEE * productQuantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * productQuantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * productQuantity);

		containerController.getContainerInstance().setCoffeeContainer(remainingCoffeeQuantity);
		containerController.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerInstance().setSugarContainer(remainingSugarQuantity);
	}

	public int substractQuantity(int availableQuantity, int usedQuantity) {
		return availableQuantity - usedQuantity;

	}
}
