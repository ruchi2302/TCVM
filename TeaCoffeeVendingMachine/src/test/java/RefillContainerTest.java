import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.TCVMControllerMenu;
import com.tcvm.dto.ContainerDto;
import com.tcvm.serviceImpl.InputScanner;
import com.tcvm.serviceImpl.RefillContainer;

@RunWith(MockitoJUnitRunner.class)
public class RefillContainerTest {

	@InjectMocks
	RefillContainer refillContainer;

	@Mock
	TCVMControllerMenu tcvmMenu;

	@Mock
	ContainerDto container;
	
	@Mock
	InputScanner scanner;

	@Test
	public void shouldSystemSupportRefillContainer() throws IOException {
		Mockito.doNothing().when(container).setTeaContainer(Mockito.anyInt());
		Mockito.when(scanner.nextInt()).thenReturn(1);
		refillContainer.refillContainer(1);
		Mockito.verify(container).setTeaContainer(Mockito.anyInt());
	}
	
	@Test
	public void shouldSystemSupportRefillContainer2() throws IOException {
		Mockito.doNothing().when(container).setCoffeeContainer(Mockito.anyInt());
		Mockito.when(scanner.nextInt()).thenReturn(1);
		refillContainer.refillContainer(2);
		Mockito.verify(container).setCoffeeContainer(Mockito.anyInt());
	}
	@Test
	public void shouldSystemSupportRefillContainer3() throws IOException {
		Mockito.doNothing().when(container).setSugarContainer(Mockito.anyInt());
		Mockito.when(scanner.nextInt()).thenReturn(1);
		refillContainer.refillContainer(3);
		Mockito.verify(container).setSugarContainer(Mockito.anyInt());
	}
	@Test
	public void shouldSystemSupportRefillContainer4() throws IOException {
		Mockito.doNothing().when(container).setWaterContainer(Mockito.anyInt());
		Mockito.when(scanner.nextInt()).thenReturn(1);
		refillContainer.refillContainer(4);
		Mockito.verify(container).setWaterContainer(Mockito.anyInt());
	}
	
	@Test
	public void shouldSystemSupportRefillContainer5() throws IOException {
		Mockito.doNothing().when(container).setMilkContainer(Mockito.anyInt());
		Mockito.when(scanner.nextInt()).thenReturn(1);
		refillContainer.refillContainer(5);
		Mockito.verify(container).setMilkContainer(Mockito.anyInt());
	}
	
	@Test
	public void shouldSystemSupportRefillContainer6() throws IOException {
		Mockito.doNothing().when(container).setMilkContainer(Mockito.anyInt());
		Mockito.when(scanner.nextInt()).thenReturn(0).thenReturn(1);
		refillContainer.refillContainer(5);
		Mockito.verify(container).setMilkContainer(Mockito.anyInt());
	}
	
	@Test
	public void shouldSystemSupportRefillContainer7() throws IOException {
		//Mockito.doNothing().when(container).setMilkContainer(Mockito.anyInt());
		//Mockito.when(scanner.nextInt()).thenReturn(0).thenReturn(1);
		refillContainer.refillContainer(7);
		//Mockito.verify(container).setMilkContainer(Mockito.anyInt());
	}
}
