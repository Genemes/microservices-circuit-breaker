package br.com.genesedev.microservices.ecommerce;

import br.com.genesedev.microservices.ecommerce.service.PurchaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ECommerceApplicationTests {
/*
	@Autowired
	ProviderClient providerClient;

	@Autowired
	ShippingClient shippingClient;
*/
	@Autowired
	PurchaseService purchaseService;

	@Test
	void test() {
		purchaseService.getById(1L);
	}

}
