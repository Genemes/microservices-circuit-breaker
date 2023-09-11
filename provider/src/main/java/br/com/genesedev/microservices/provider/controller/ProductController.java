package br.com.genesedev.microservices.provider.controller;

import br.com.genesedev.microservices.provider.model.Product;
import br.com.genesedev.microservices.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/{state}")
    public List<Product> getProductsPerState(@PathVariable("state") String estado) {
        return service.getProductPerState(estado);
    }
}
