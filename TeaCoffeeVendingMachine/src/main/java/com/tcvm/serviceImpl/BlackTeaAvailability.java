package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;

public class BlackTeaAvailability implements AllDrinkAvailability {
	final int TEA = 3;
	final int SUGAR = 2;
	final int WATER = 100;

	ContainerController containerController = new ContainerController();

	public BlackTeaAvailability() {
	}

	@Override
	public boolean checkAvailabilityForDrink(int productQuantity) throws IOException {
		int teaQuantity = containerController.getContainerInstance().getTeaContainer();
		int sugarQuantity = containerController.getContainerInstance().getSugarContainer();
		int waterQuantity = containerController.getContainerInstance().getWaterContainer();

		if (productQuantity * TEA < teaQuantity && productQuantity * WATER < waterQuantity
				&& productQuantity * SUGAR < sugarQuantity)
			return true;

		return false;
	}

}
