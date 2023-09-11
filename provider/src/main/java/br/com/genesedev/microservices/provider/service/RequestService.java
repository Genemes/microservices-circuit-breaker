package br.com.genesedev.microservices.provider.service;

import br.com.genesedev.microservices.provider.dto.ItemPerOrderDTO;
import br.com.genesedev.microservices.provider.model.ItemRequest;
import br.com.genesedev.microservices.provider.model.Product;
import br.com.genesedev.microservices.provider.model.Request;
import br.com.genesedev.microservices.provider.repository.ProductRepository;
import br.com.genesedev.microservices.provider.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ProductRepository productRepository;

    public Request placeOrder(List<ItemPerOrderDTO> items){
        if(items == null) {
            return null;
        }

        List<ItemRequest> itemsRequest = toPedidoItem(items);
        Request request = new Request(itemsRequest);
        request.setPreparationTime(items.size());
        return requestRepository.save(request);
    }

    public Request getRequestPerId(Long id){
        return this.requestRepository.findById(id).orElse(new Request());
    }

    private List<ItemRequest> toPedidoItem(List<ItemPerOrderDTO> items) {

        List<Long> idsProducts = items
                .stream()
                .map(item -> item.id())
                .collect(Collectors.toList());

        List<Product> productsPerRequest = productRepository.findByIdIn(idsProducts);

        List<ItemRequest> itemsRequest = items
                .stream()
                .map(item -> {
                    Product product = productsPerRequest
                            .stream()
                            .filter(p -> p.getId() == item.id())
                            .findFirst().get();

                    ItemRequest itemRequest = new ItemRequest();
                    itemRequest.setProduct(product);
                    itemRequest.setQuatity(item.quanty());
                    return itemRequest;
                })
                .collect(Collectors.toList());
        return itemsRequest;
    }
}
