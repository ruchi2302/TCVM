import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.dto.ProductDto;
import com.tcvm.serviceImpl.CheckTotalSale;
import com.tcvm.serviceImpl.ProductRecord;

@RunWith(MockitoJUnitRunner.class)
public class TotalSaleTest {

	@InjectMocks
	CheckTotalSale totalSale;

	@Mock
	ProductRecord productRecord;

	@Mock
	Logger logger;

	@Test
	public void shouldReturnTotalSale() throws IOException {
		Mockito.doNothing().when(logger).info(Mockito.anyString());
		ProductDto product = new ProductDto("tea", 1, 10);
		ProductDto product1 = new ProductDto("black tea", 1, 15);
		ProductDto product2 = new ProductDto("black coffee", 1, 15);
		ProductDto product3 = new ProductDto("coffee", 1, 15);
		List<ProductDto> productList = new ArrayList<ProductDto>();
		productList.add(product);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		Mockito.when(productRecord.getProductList()).thenReturn(productList);
		totalSale.productTotalSale();

		Mockito.verify(productRecord, Mockito.times(10)).getProductList();

	}
}