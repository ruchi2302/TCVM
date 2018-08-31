package com.tcvm.serviceImpl;

import java.io.IOException;

import com.tcvm.controller.ContainerController;
import com.tcvm.controller.TCVMControllerMenu;
import com.tcvm.dto.ContainerDto;

public class RefillContainer {

	TCVMControllerMenu tcvmMenu;
	InputScanner inputScanner;
	ContainerDto containerDto = new ContainerDto();
	
	public RefillContainer() {
		inputScanner = new InputScanner();
		
	}

	public ContainerDto getContainer() throws IOException {
		return new ContainerController().getContainerInstance();
	}
	
	public void inputChoiceForContainer() throws IOException{
		System.out.println("Press 0 for main menu");
		int m = inputScanner.nextInt();
		if (m == 0)
			tcvmMenu.chooseAnyOptions();
	}

	public void refillContainer(int input) throws IOException {

	//	inputScanner.nextInt();

		switch (input) { 

		case 1:
			containerDto.setTeaContainer(2000);
			System.out.println("Tea Container is filled");
			inputChoiceForContainer();
			
			break; 

		case 2:
			containerDto.setCoffeeContainer(6000);
			System.out.println("Coffee Container is filled");
			inputChoiceForContainer();
			break;
		case 3:
			containerDto.setSugarContainer(8000);

			System.out.println("Sugar Container is filled");
			System.out.println("Press 0 for main menu");
			inputChoiceForContainer();
			break;
		case 4:
			containerDto.setWaterContainer(10000);
			System.out.println("Water Container is filled");
			inputChoiceForContainer();
			break;
		case 5:
			containerDto.setMilkContainer(20000);
			System.out.println("Milk Container is filled");
			inputChoiceForContainer();
			break;

		default:
			System.out.println(input + "Wrong choice");
		}
		System.out.println("Container filled with Selected material ...");
	}
}
