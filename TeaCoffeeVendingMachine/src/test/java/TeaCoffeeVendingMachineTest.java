import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.ContainerController;
import com.tcvm.service.AllDrinkAvailability;
import com.tcvm.serviceImpl.BlackCoffeeAvailability;
import com.tcvm.serviceImpl.BlackTeaAvailability;
import com.tcvm.serviceImpl.CoffeeAvailability;
import com.tcvm.serviceImpl.TeaAvailability;

@RunWith(MockitoJUnitRunner.class)
public class TeaCoffeeVendingMachineTest {

	@InjectMocks
	ContainerController containerController;

	@Mock
	AllDrinkAvailability drinkAvailability;

	@Test
	public void shouldHaveContainerWithMaximumCapicity() throws IOException {
		assertEquals(2000, containerController.getContainerInstance().getTeaContainer());
		assertEquals(2000, containerController.getContainerInstance().getCoffeeContainer());
		assertEquals(15000, containerController.getContainerInstance().getWaterContainer());
		assertEquals(8000, containerController.getContainerInstance().getSugarContainer());
		assertEquals(10000, containerController.getContainerInstance().getMilkContainer());
	}
  
	@Test
	public void shouldContainerFilledWithNeededMaterialForMakingDrink() throws IOException {
		AllDrinkAvailability teaAvailability = new TeaAvailability();
		AllDrinkAvailability coffeAvailability = new CoffeeAvailability();
		AllDrinkAvailability blackTeaAvailability = new BlackTeaAvailability();
		AllDrinkAvailability blackCoffeAvailability = new BlackCoffeeAvailability();

		Assert.assertTrue(teaAvailability.checkAvailabilityForDrink(2));
		Assert.assertTrue(coffeAvailability.checkAvailabilityForDrink(2));
		Assert.assertTrue(blackTeaAvailability.checkAvailabilityForDrink(2));
		Assert.assertTrue(blackCoffeAvailability.checkAvailabilityForDrink(2));

		Assert.assertFalse(teaAvailability.checkAvailabilityForDrink(200000));
		Assert.assertFalse(coffeAvailability.checkAvailabilityForDrink(200000));
		Assert.assertFalse(blackTeaAvailability.checkAvailabilityForDrink(200000));
		Assert.assertFalse(blackCoffeAvailability.checkAvailabilityForDrink(200000));

	} 

	/*
	 * @Test public void shouldSystemSupportToMakeTea() { makeTea.makePocess(2);
	 * Mockito.verify(makeTea).makePocess(2);
	 * 
	 * }
	 * 
	 * @Test public void shouldSystemSupportToMakeCoffee() {
	 * makeCoffee.makePocess(1); Mockito.verify(makeCoffee).makePocess(1);
	 * 
	 * }
	 * 
	 * @Test public void shouldSystemSupportToMakeBlackTea() {
	 * makeBlackTea.makePocess(2); Mockito.verify(makeBlackTea).makePocess(2); }
	 * 
	 * @Test public void shouldSystemSupportToMakeBlackCoffee() {
	 * makeBlackCoffee.makePocess(1);
	 * Mockito.verify(makeBlackCoffee).makePocess(1);
	 * 
	 * }
	 */
}
