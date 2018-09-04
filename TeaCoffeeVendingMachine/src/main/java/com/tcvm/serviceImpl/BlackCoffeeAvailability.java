package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;

public class BlackCoffeeAvailability implements AllDrinkAvailability {
	final int COFFEE = 3;
	final int WATER = 100;
	final int SUGAR = 15;

	ContainerController containerController = new ContainerController();

	public BlackCoffeeAvailability() {
	}

	
	public boolean checkAvailabilityForDrink(int productQuantity) throws IOException {
		int coffeeQuantity = containerController.getContainerInstance().getTeaContainer();
		int sugarQuantity = containerController.getContainerInstance().getSugarContainer();
		int waterQuantity = containerController.getContainerInstance().getWaterContainer();

		if (productQuantity * COFFEE < coffeeQuantity && productQuantity * WATER < waterQuantity
				&& productQuantity * SUGAR < sugarQuantity)
			return true;

		return false;
	}

}
