package com.tcvm.dto;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;
import com.tcvm.service.TCVMMakingDrink;
import com.tcvm.serviceImpl.ProductRecord;
import com.tcvm.serviceImpl.WasteProductRecord;

public class MakeCoffee implements TCVMMakingDrink {

	final int COFFEE_PRICE = 15;
	final static int COFFEE = 4;
	final static int WATER = 20;
	final static int MILK = 80;
	final static int SUGAR = 15;

	final static int WASTE_COFFEE = 1;
	final static int WASTE_WATER = 5;
	final static int WASTE_MILK = 4;
	final static int WASTE_SUGAR = 2;

	ContainerController containerController;
	ProductRecord productRecord;
	WasteProductRecord wasteProductRecord;
	AllDrinkAvailability drinkAvailability;

	public MakeCoffee() {

	}

	public MakeCoffee(ContainerController containerController, ProductRecord productRecord,
			WasteProductRecord wasteProductRecord) {
		super();
		this.containerController = containerController;
		this.productRecord = productRecord;
		this.wasteProductRecord = wasteProductRecord;
	}

	@Override
	public void makeProcess(int productQuantity) throws IOException {

		int coffeeAvailableQuantity = containerController.getContainerInstance().getCoffeeContainer();
		int waterAvailableQuantity = containerController.getContainerInstance().getWaterContainer();
		int milkAvailableQuantity = containerController.getContainerInstance().getMilkContainer();
		int sugarAvailableQuantity = containerController.getContainerInstance().getSugarContainer();

		updateQuantity(productQuantity, coffeeAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity,
				sugarAvailableQuantity);
		productRecord.addProductInList(
				new ProductDto("coffee", productQuantity, productQuantity * COFFEE_PRICE));
		System.out.println(productQuantity + " cup tea " + productQuantity + "*" + COFFEE_PRICE + " = "
				+ productQuantity * COFFEE_PRICE);

	}

	public void updateQuantity(int productQuantity, int coffeeAvailableQuantity, int waterAvailableQuantity,
			int milkAvailableQuantity, int sugarAvailableQuantity) throws IOException {
		int remainingCoffeeQuantity = substractQuantity(coffeeAvailableQuantity, COFFEE * productQuantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * productQuantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * productQuantity);
		int remainingMilkQuantity = substractQuantity(milkAvailableQuantity, MILK * productQuantity);

		containerController.getContainerInstance().setTeaContainer(remainingCoffeeQuantity);
		containerController.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerInstance().setSugarContainer(remainingSugarQuantity);
		containerController.getContainerInstance().setMilkContainer(remainingMilkQuantity);
	}

	public int substractQuantity(int availableQuantity, int usedQuantity) {
		return availableQuantity - usedQuantity;

	}
}
