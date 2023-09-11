package br.com.genesedev.microservices.shipping.controller;

import br.com.genesedev.microservices.shipping.dto.DeliveryDTO;
import br.com.genesedev.microservices.shipping.dto.VoucherDTO;
import br.com.genesedev.microservices.shipping.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @RequestMapping(method = RequestMethod.POST)
    public VoucherDTO reservationDelivery(@RequestBody DeliveryDTO deliveryDTO){
        return service.reservationDelivery(deliveryDTO);
    }
}
