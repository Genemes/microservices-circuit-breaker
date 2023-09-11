package br.com.genesedev.microservices.ecommerce.client;

import br.com.genesedev.microservices.ecommerce.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("shipping")
public interface ShippingClient {

    @RequestMapping(method=RequestMethod.POST, path="/delivery")
    VoucherDTO reserveDelivery(InfoDeliveryDTO info);
}
