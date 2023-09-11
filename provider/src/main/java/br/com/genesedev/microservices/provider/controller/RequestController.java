package br.com.genesedev.microservices.provider.controller;

import br.com.genesedev.microservices.provider.dto.ItemPerOrderDTO;
import br.com.genesedev.microservices.provider.model.Request;
import br.com.genesedev.microservices.provider.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request")
public class RequestController {

    @Autowired
    private RequestService service;

    @RequestMapping(method = RequestMethod.POST)
    public Request realizaPedido(@RequestBody List<ItemPerOrderDTO> products) {
        return service.placeOrder(products);
    }

    @RequestMapping("/{id}")
    public Request getRequestPerId(@PathVariable Long id) {
        return service.getRequestPerId(id);
    }
}
