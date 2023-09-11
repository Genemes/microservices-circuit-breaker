package br.com.genesedev.microservices.ecommerce.client;

import br.com.genesedev.microservices.ecommerce.dto.InfoProviderDTO;
import br.com.genesedev.microservices.ecommerce.dto.InfoRequestDTO;
import br.com.genesedev.microservices.ecommerce.dto.PurchaseItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping("/info/{state}")
    InfoProviderDTO getInfoProvider(@PathVariable String state);

    @RequestMapping(method=RequestMethod.POST, value="/purchase")
    InfoRequestDTO placeOrder(List<PurchaseItemDTO> items);
}
