package br.com.genesedev.microservices.shipping.dto;

import java.time.LocalDate;

public record VoucherDTO(
        Long number,
        LocalDate forecastForDelivery
) {}
