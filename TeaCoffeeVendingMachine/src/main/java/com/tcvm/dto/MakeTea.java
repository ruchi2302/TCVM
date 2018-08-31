package com.tcvm.dto;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;
import com.tcvm.service.TCVMMakingDrink;
import com.tcvm.serviceImpl.ProductRecord;
import com.tcvm.serviceImpl.WasteProductRecord;

public class MakeTea implements TCVMMakingDrink {

	final static int TEA_PRICE = 10;
	final static int TEA = 5;
	final static int WATER = 60;
	final static int MILK = 40;
	final static int SUGAR = 15;

	final static int WASTE_TEA = 1;
	final static int WASTE_WATER = 5;
	final static int WASTE_MILK = 4;
	final static int WASTE_SUGAR = 2;

	ContainerController containerController;
	WasteProductRecord wasteProductRecord;
	ProductRecord productRecord;
	AllDrinkAvailability drinkAvailability;

	public MakeTea() {

	}

	public MakeTea(ContainerController containerController, ProductRecord productRecord,
			WasteProductRecord wasteProductRecord) {
		super();
		this.containerController = containerController;
		this.wasteProductRecord = wasteProductRecord;
		this.productRecord = productRecord;
	}

	@Override
	public void makeProcess(int productQuantity) throws IOException {

		
			int teaAvailableQuantity = containerController.getContainerInstance().getTeaContainer();
			int waterAvailableQuantity = containerController.getContainerInstance().getWaterContainer();
			int milkAvailableQuantity = containerController.getContainerInstance().getMilkContainer();
			int sugarAvailableQuantity = containerController.getContainerInstance().getSugarContainer();

			updateQuantity(productQuantity, teaAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity,
					sugarAvailableQuantity);
			productRecord.addProductInList(
					new ProductDto("Tea", productQuantity, productQuantity * TEA_PRICE));

			System.out.println(productQuantity + " cup tea " + productQuantity + "*" + TEA_PRICE + " = "
					+ productQuantity * TEA_PRICE);
		}
	

	public void updateQuantity(int productQuantity, int teaAvailableQuantity, int waterAvailableQuantity,
			int milkAvailableQuantity, int sugarAvailableQuantity) throws IOException {
		int remainingTeaQuantity = substractQuantity(teaAvailableQuantity, TEA * productQuantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * productQuantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * productQuantity);
		int remainingMilkQuantity = substractQuantity(milkAvailableQuantity, MILK * productQuantity);

		containerController.getContainerInstance().setTeaContainer(remainingTeaQuantity);
		containerController.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerInstance().setSugarContainer(remainingSugarQuantity);
		containerController.getContainerInstance().setMilkContainer(remainingMilkQuantity);
	}

	public int substractQuantity(int availableQuantity, int usedQuantity) {
		return availableQuantity - usedQuantity;

	}
}
