package br.com.genesedev.microservices.ecommerce.dto;

import java.time.LocalDate;

public record InfoDeliveryDTO(
        Long deliveryId,
        LocalDate deliveryDate,
        String sourceAddress,
        String destinationAddress) {
    public InfoDeliveryDTO(Long deliveryId, LocalDate deliveryDate, String sourceAddress) {
        this(deliveryId, deliveryDate, sourceAddress, null);
    }
}
