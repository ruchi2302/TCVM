import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.tcvm.serviceImpl.TeaAvailability;

public class MakeTeaAvailabilityTest {

	@InjectMocks
	TeaAvailability teaAvailability;

	@Test
	public void shouldSystemReturnTrueWhenTeaContainerQuantityIsGreaterThanTeaConsumeQuantity() throws IOException {
		assertTrue(new TeaAvailability().checkAvailabilityForDrink(4));

		assertFalse(new TeaAvailability().checkAvailabilityForDrink(40000));

	}

	@Test
	public void shouldSystemReturnTrueWhenWaterContainerQuantityIsGreaterThanWaterConsumeQuantity() throws IOException {

		assertTrue(new TeaAvailability().checkAvailabilityForDrink(3));
	}

}
