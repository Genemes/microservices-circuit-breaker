package br.com.genesedev.microservices.shipping.dto;

import java.time.LocalDate;

public record DeliveryDTO(
        Long requestId,
        LocalDate dateForDelivery,
        String sourceAddress,
        String destinationAddress
) {}
