package com.tcvm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.tcvm.dto.ContainerDto;

public class ContainerController { 

	static ContainerDto containerDto;

	public ContainerDto getContainerInstance() throws IOException {
		Map<String, Integer> containerData = createContainerData();
 
		if (containerDto == null) {
			containerDto = new ContainerDto(containerData.get("teaContainer"),
					containerData.get("coffeeContainer"), containerData.get("sugarContainer"),
					containerData.get("waterContainer"), containerData.get("milkContainer"));
		}
		return containerDto;

	}

	public Map createContainerData() {
		Map<String, Integer> containerData = new HashMap<>();
		containerData.put("teaContainer", 2000);
		containerData.put("coffeeContainer", 2000);
		containerData.put("sugarContainer", 8000);
		containerData.put("waterContainer", 15000);
		containerData.put("milkContainer", 10000);

		return containerData;
	}
 
}
