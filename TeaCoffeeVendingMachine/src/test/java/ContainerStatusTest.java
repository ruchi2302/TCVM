import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.serviceImpl.ContainerStatus;


@RunWith(MockitoJUnitRunner.class)
public class ContainerStatusTest {

	
    @InjectMocks
    ContainerStatus containerStatus;
    
    @Test
    public void shouldSystemSupportContainerStatus() throws IOException {
    	assertTrue(containerStatus.showContainerStatus());
           
           
    }

	

}
