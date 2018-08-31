package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.dto.ContainerDto;

public class ContainerStatus {

	public ContainerStatus() {

	}

	public boolean showContainerStatus() throws IOException {

		ContainerDto container = new ContainerController().getContainerInstance();
		System.out.println("Container Status.....");
		System.out.println(
				"Tea Container :" + container.getTeaContainer() + "Coffee Container :" + container.getCoffeeContainer()
						+ "Milk Container :" + container.getMilkContainer() + "Sugar Container :"
						+ container.getSugarContainer() + "Water Container :" + container.getWaterContainer());
 
		return true;
	}

}
