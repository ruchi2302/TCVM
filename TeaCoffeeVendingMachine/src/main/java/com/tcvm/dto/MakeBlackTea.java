package com.tcvm.dto;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.TCVMMakingDrink;
import com.tcvm.serviceImpl.ProductRecord;
import com.tcvm.serviceImpl.WasteProductRecord;

public class MakeBlackTea implements TCVMMakingDrink {

	final static int BLACK_TEA_PRICE = 5;
	final static int TEA = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;

	final static int WASTE_BLACK_TEA = 1;
	final static int WASTE_WATER = 5;
	final static int WASTE_SUGAR = 2;

	ContainerController containerController;
	ProductRecord productRecord;
	WasteProductRecord wasteProductRecord;

	public MakeBlackTea() {
		containerController = new ContainerController();
		productRecord = new ProductRecord();
		wasteProductRecord = new WasteProductRecord();

	}

	public MakeBlackTea(ContainerController containerController, ProductRecord productRecord,
			WasteProductRecord wasteProductRecord) {
		super();
		this.containerController = containerController;
		this.productRecord = productRecord;
		this.wasteProductRecord = wasteProductRecord;
	}

	
	public void makeProcess(int productQuantity) throws IOException {

		int teaAvailableQuantity = containerController.getContainerInstance().getTeaContainer();
		int waterAvailableQuantity = containerController.getContainerInstance().getWaterContainer();
		int sugarAvailableQuantity = containerController.getContainerInstance().getSugarContainer();

		updateQuantity(productQuantity, teaAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord.addProductInList(new ProductDto("black tea", productQuantity, productQuantity * BLACK_TEA_PRICE));

		System.out.println(productQuantity + " cup blak tea " + productQuantity + "*" + BLACK_TEA_PRICE + " = "
				+ productQuantity * BLACK_TEA_PRICE);
	}

	public void updateQuantity(int productQuantity, int teaAvailableQuantity, int waterAvailableQuantity,
			int sugarAvailableQuantity) throws IOException {

		int remainingTeaQuantity = substractQuantity(teaAvailableQuantity, TEA * productQuantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * productQuantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * productQuantity);

		containerController.getContainerInstance().setTeaContainer(remainingTeaQuantity);
		containerController.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerInstance().setSugarContainer(remainingSugarQuantity);
	}

	public int substractQuantity(int availableQuantity, int usedQuantity) {
		return availableQuantity - usedQuantity;

	}

}
