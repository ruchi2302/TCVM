package com.tcvm.controller;

import java.io.IOException;

public class TCVMController {

	public static void main(String[] args) throws IOException {
		new ContainerController().getContainerInstance();
		new TCVMControllerMenu(/*new InputScanner(), new MakeTea(), new RefillContainer()*/).chooseAnyOptions();
	} 
} 
