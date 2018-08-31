package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;

public class CoffeeAvailability implements AllDrinkAvailability {
	final int COFFEE = 4;
	final int SUGAR = 15;
	final int WATER = 20;
	final int MILK = 80;

	ContainerController containerController = new ContainerController();

	public CoffeeAvailability() {
	}

	@Override
	public boolean checkAvailabilityForDrink(int productQuantity) throws IOException {
		int coffeeQuantity = containerController.getContainerInstance().getCoffeeContainer();
		int sugarQuantity = containerController.getContainerInstance().getSugarContainer();
		int waterQuantity = containerController.getContainerInstance().getWaterContainer();
		int milkQuantity = containerController.getContainerInstance().getMilkContainer();

		if (productQuantity * COFFEE < coffeeQuantity && productQuantity * WATER < waterQuantity
				&& productQuantity * SUGAR < sugarQuantity && productQuantity * MILK < milkQuantity)
			return true;

		return false;
	}

}
