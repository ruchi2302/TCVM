package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.dto.ContainerDto;

public class ResetContainer {
 
	public boolean resetContainer() throws IOException {
		ContainerDto containerDto = new ContainerController().getContainerInstance();

		containerDto.setTeaContainer(2000);
		containerDto.setCoffeeContainer(2000);
		containerDto.setMilkContainer(10000);
		containerDto.setWaterContainer(15000);
		containerDto.setSugarContainer(8000);

		return true;
		
	}

}
