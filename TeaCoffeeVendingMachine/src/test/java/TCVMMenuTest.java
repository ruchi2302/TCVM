import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.TCVMControllerMenu;
import com.tcvm.dto.MakeBlackCoffee;
import com.tcvm.dto.MakeBlackTea;
import com.tcvm.dto.MakeCoffee;
import com.tcvm.dto.MakeTea;
import com.tcvm.serviceImpl.BlackCoffeeAvailability;
import com.tcvm.serviceImpl.BlackTeaAvailability;
import com.tcvm.serviceImpl.CheckTotalSale;
import com.tcvm.serviceImpl.CoffeeAvailability;
import com.tcvm.serviceImpl.ContainerStatus;
import com.tcvm.serviceImpl.InputScanner;
import com.tcvm.serviceImpl.RefillContainer;
import com.tcvm.serviceImpl.ResetContainer;
import com.tcvm.serviceImpl.TeaAvailability;

@RunWith(MockitoJUnitRunner.class)
public class TCVMMenuTest {

	@InjectMocks
	TCVMControllerMenu tcvmMenu;

	@Mock
	InputScanner inputScanner;

	@Mock
	TeaAvailability teaAvailability;

	@Mock
	CoffeeAvailability coffeeAvailability;

	@Mock
	BlackCoffeeAvailability blackCoffeeAvailability;

	@Mock
	BlackTeaAvailability blackTeaAvailability;

	@Mock
	MakeTea makeTea;

	@Mock
	MakeCoffee makeCoffee;

	@Mock
	MakeBlackTea makeBlackTea;

	@Mock
	MakeBlackCoffee makeBlackCoffee;

	@Mock
	RefillContainer refillContainer;

	@Mock
	CheckTotalSale checkTotalSale;

	@Mock
	ContainerStatus containerStatus;

	@Mock
	ResetContainer resetContainer;

	@Test
	public void shouldCheckSwitchCaseOneMakeTea() throws IOException {

		when(inputScanner.nextInt()).thenReturn(1);
		when(teaAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(true);
		Mockito.doNothing().when(makeTea).makeProcess(Mockito.anyInt());
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(teaAvailability).checkAvailabilityForDrink(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseOneMakeTeaNegativeCase() throws IOException {

		when(inputScanner.nextInt()).thenReturn(1);
		when(teaAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(false);
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(teaAvailability).checkAvailabilityForDrink(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseTwoMakeCoffe() throws IOException {

		when(inputScanner.nextInt()).thenReturn(2);
		when(coffeeAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(true);
		Mockito.doNothing().when(makeCoffee).makeProcess(Mockito.anyInt());
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(coffeeAvailability).checkAvailabilityForDrink(Mockito.anyInt());

	}

	@Test
	public void shouldCheckSwitchCaseTwoMakeCoffeNegative() throws IOException {

		when(inputScanner.nextInt()).thenReturn(2);
		when(coffeeAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(false);
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(coffeeAvailability).checkAvailabilityForDrink(Mockito.anyInt());

	}

	@Test
	public void shouldCheckSwitchCaseThreeMakeBlackTea() throws IOException {
		when(inputScanner.nextInt()).thenReturn(3).thenReturn(1);
		when(blackTeaAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(true);
		Mockito.doNothing().when(makeBlackTea).makeProcess(Mockito.anyInt());
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(blackTeaAvailability).checkAvailabilityForDrink(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseThreeMakeBlackTeaNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(3).thenReturn(1);
		when(blackTeaAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(false);
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(blackTeaAvailability).checkAvailabilityForDrink(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseFourMakeBlackCoffee() throws IOException {
		when(inputScanner.nextInt()).thenReturn(4).thenReturn(1);
		when(blackCoffeeAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(true);
		Mockito.doNothing().when(makeBlackCoffee).makeProcess(Mockito.anyInt());
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(blackCoffeeAvailability).checkAvailabilityForDrink(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseFourMakeBlackCoffeeNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(4).thenReturn(1);
		when(blackCoffeeAvailability.checkAvailabilityForDrink(Mockito.anyInt())).thenReturn(false);
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(blackCoffeeAvailability).checkAvailabilityForDrink(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseFiveRefillContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(5).thenReturn(1);
		Mockito.doNothing().when(refillContainer).refillContainer(Mockito.anyInt());
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(refillContainer).refillContainer(Mockito.anyInt());

	}

	@Test
	public void shouldCheckSwitchCaseSixCheckTotalSale() throws IOException {
		when(inputScanner.nextInt()).thenReturn(6).thenReturn(1);
		Mockito.doNothing().when(checkTotalSale).productTotalSale();

		tcvmMenu.chooseAnyOptions();
		Mockito.verify(checkTotalSale).productTotalSale();

	}

	@Test
	public void shouldCheckSwitchCaseSevenContainerStatus() throws IOException {
		when(inputScanner.nextInt()).thenReturn(7).thenReturn(0).thenReturn(1);
		Mockito.when(containerStatus.showContainerStatus()).thenReturn(true);
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(containerStatus).showContainerStatus();

	}

	@Test
	public void shouldCheckSwitchCaseEightResetContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(8).thenReturn(0).thenReturn(1);
		Mockito.when(resetContainer.resetContainer()).thenReturn(true);
		tcvmMenu.chooseAnyOptions();
		Mockito.verify(resetContainer).resetContainer();
	}

	@Test
	public void shouldExitFromSystem() throws IOException {
		when(inputScanner.nextInt()).thenReturn(9);
		// Mockito.when(resetContainer.resetContainer()).thenReturn(true);
		tcvmMenu.chooseAnyOptions();
		// Mockito.verify(resetContainer).resetContainer();
	}

	@Test
	public void shouldDefault() throws IOException {
		when(inputScanner.nextInt()).thenReturn(10).thenReturn(1);
		tcvmMenu.chooseAnyOptions();
	}

	@Test
	public void shouldCallTCVMControllerMenu() {
		TCVMControllerMenu tcvmControllerMenu = new TCVMControllerMenu();
	}
}
