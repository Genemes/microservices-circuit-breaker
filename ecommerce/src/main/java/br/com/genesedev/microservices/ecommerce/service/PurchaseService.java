package br.com.genesedev.microservices.ecommerce.service;

import br.com.genesedev.microservices.ecommerce.client.ShippingClient;
import br.com.genesedev.microservices.ecommerce.dto.*;
import br.com.genesedev.microservices.ecommerce.model.PurchaseStateEnum;
import br.com.genesedev.microservices.ecommerce.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.genesedev.microservices.ecommerce.client.ProviderClient;
import br.com.genesedev.microservices.ecommerce.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PurchaseService {

    private static final Logger LOG =  LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private ProviderClient providerClient;

    @Autowired
    private ShippingClient shippingClient;

    @Autowired
    private PurchaseRepository repository;

    public Purchase getById(Long id) {
        return repository.findById(id).orElse(new Purchase());
    }

    public Purchase placeOrder(PurchaseDTO purchase) {
        Purchase purchaseSave = new Purchase();
        purchaseSave.setState(PurchaseStateEnum.RECEIVED);
        purchaseSave.setDestinationAddress(purchase.address().toString());
        repository.save(purchaseSave);
        var purchaseDTO = new PurchaseDTO(purchaseSave.getId(), purchase.items(), purchase.address());

        final String state = purchase.address().state();
        InfoProviderDTO infoProvider = providerClient.getInfoProvider(state);
        InfoRequestDTO infoRequest = providerClient.placeOrder(purchase.items());
        purchaseSave.setState(PurchaseStateEnum.ORDER_MADE);
        LocalDate time = LocalDate.now().plusDays(infoRequest.preparationTime());
        purchaseSave.setPreparationTime(time);
        repository.save(purchaseSave);

        InfoDeliveryDTO deliveryDTO = new InfoDeliveryDTO(infoRequest.id(), time, infoProvider.address());
        VoucherDTO voucher = shippingClient.reserveDelivery(deliveryDTO); //transportadorClient.reservaEntrega(entregaDto);
        purchaseSave.setState(PurchaseStateEnum.DELIVERY_RESERVATION_MADE);
        purchaseSave.setDeliveryDate(voucher.deliveryDate());
        purchaseSave.setVoucher(voucher.number());
        repository.save(purchaseSave);

        return purchaseSave;
    }


    public Purchase realizaCompraFallback(PurchaseDTO purchase) {
        if(purchase.purchaseId() != null) {
            return repository.findById(purchase.purchaseId()).get();
        }

        Purchase purchaseFallback = new Purchase();
        purchaseFallback.setDestinationAddress(purchase.address().toString());
        return purchaseFallback;
    }
}
