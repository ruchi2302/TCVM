package com.tcvm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.tcvm.dto.ContainerDto;

public class WasteProductRecord {

	List<ContainerDto> wasteProductList = new ArrayList();

	public void addWasteProductInList(ContainerDto product) {
		wasteProductList.add(product);
	}

}
 