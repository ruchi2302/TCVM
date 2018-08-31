package com.tcvm.dto;

public class ContainerDto {

	private int teaContainer;
	private int coffeeContainer;
	private int sugarContainer;
	private int waterContainer;
	private int milkContainer;

	public ContainerDto() {
 
	} 

	public ContainerDto(int teaContainer, int coffeeContainer, int sugarContainer, int waterContainer,
			int milkContainer) {
		super();
		this.teaContainer = teaContainer;
	 	this.coffeeContainer = coffeeContainer;
		this.sugarContainer = sugarContainer;
		this.waterContainer = waterContainer;
		this.milkContainer = milkContainer;
	}

	public int getTeaContainer() {
		return teaContainer;
	}

	public void setTeaContainer(int teaContainer) {
		this.teaContainer = teaContainer;
	}

	public int getCoffeeContainer() {
		return coffeeContainer;
	}

	public void setCoffeeContainer(int coffeeContainer) {
		this.coffeeContainer = coffeeContainer;
	}
 
	public int getSugarContainer() {
		return sugarContainer;
	}

	public void setSugarContainer(int sugarContainer) {
		this.sugarContainer = sugarContainer;
	}

	public int getWaterContainer() {
		return waterContainer;
	}

	public void setWaterContainer(int waterContainer) {
		this.waterContainer = waterContainer;
	}

	public int getMilkContainer() {
		return milkContainer;
	}

	public void setMilkContainer(int milkContainer) {
		this.milkContainer = milkContainer;
	}

}
