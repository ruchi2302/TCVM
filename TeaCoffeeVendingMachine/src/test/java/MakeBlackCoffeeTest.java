import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.ContainerController;
import com.tcvm.dto.ContainerDto;
import com.tcvm.dto.MakeBlackCoffee;
import com.tcvm.serviceImpl.ProductRecord;
import com.tcvm.serviceImpl.WasteProductRecord;

@RunWith(MockitoJUnitRunner.class)
public class MakeBlackCoffeeTest {

	@InjectMocks
	MakeBlackCoffee makeBlackCoffee;
	
	@Mock
	ContainerController containerController;
	
    @Mock
    private ProductRecord productRecord;
    
    @Mock
    WasteProductRecord wasteproductRecord;

	
	@Test
	public void shouldSystemSupportToMakeBlackCoffee() throws IOException{
		ContainerDto containerDto=new ContainerDto(1, 0, 0, 0, 0);
		Mockito.when(containerController.getContainerInstance()).thenReturn(containerDto);
		makeBlackCoffee.makeProcess(2);
		//Mockito.verify(containerController,Mockito.atLeast(1)).getContainerInstance();
	}
}
