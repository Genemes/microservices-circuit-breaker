package br.com.genesedev.microservices.shipping.service;

import br.com.genesedev.microservices.shipping.dto.DeliveryDTO;
import br.com.genesedev.microservices.shipping.dto.VoucherDTO;
import br.com.genesedev.microservices.shipping.model.Delivery;
import br.com.genesedev.microservices.shipping.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    public VoucherDTO reservationDelivery(DeliveryDTO deliveryDTO){
        Delivery delivery = new Delivery();
        delivery.setDateToSearch(deliveryDTO.dateForDelivery());
        delivery.setForecastForDelivery(deliveryDTO.dateForDelivery());
        delivery.setSourceAddress(deliveryDTO.sourceAddress());
        delivery.setDestinationAddress(deliveryDTO.destinationAddress());
        delivery.setRequestId(deliveryDTO.requestId());

        repository.save(delivery);

        VoucherDTO voucher = new VoucherDTO(delivery.getId(), delivery.getForecastForDelivery());
        return voucher;
    }
}
