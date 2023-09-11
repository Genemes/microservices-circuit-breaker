package br.com.genesedev.microservices.provider.service;

import br.com.genesedev.microservices.provider.model.Product;
import br.com.genesedev.microservices.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProductPerState(String state){
        return repository.findByState(state);
    }
}
