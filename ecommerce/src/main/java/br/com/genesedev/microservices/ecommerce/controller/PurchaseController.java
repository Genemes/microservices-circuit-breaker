package br.com.genesedev.microservices.ecommerce.controller;

import br.com.genesedev.microservices.ecommerce.dto.PurchaseDTO;
import br.com.genesedev.microservices.ecommerce.model.Purchase;
import br.com.genesedev.microservices.ecommerce.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @RequestMapping("/{id}")
    public Purchase getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Purchase placeOrder(@RequestBody PurchaseDTO purchase) {
        return service.placeOrder(purchase);
    }
}
