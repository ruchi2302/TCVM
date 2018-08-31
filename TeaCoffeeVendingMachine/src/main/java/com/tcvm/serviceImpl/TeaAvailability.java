package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;

public class TeaAvailability implements AllDrinkAvailability {
	final int TEA = 5;
	final int WATER = 60;
	final int MILK = 50;
	final int SUGAR = 15;
	
	public TeaAvailability(){
		
	}
 
	ContainerController containerController = new ContainerController();

	@Override
	public boolean checkAvailabilityForDrink(int productQuantity) throws IOException {
 
		int teaQuantity = containerController.getContainerInstance().getTeaContainer();
		int waterQuantity = containerController.getContainerInstance().getWaterContainer();
		int sugarQuantity = containerController.getContainerInstance().getSugarContainer();
		int milkQuantity = containerController.getContainerInstance().getMilkContainer();

		if (productQuantity * TEA < teaQuantity && productQuantity * WATER < waterQuantity
				&& productQuantity * SUGAR < sugarQuantity && productQuantity * MILK < milkQuantity)
			return true;

		return false;
	}

	
}
