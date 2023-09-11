package br.com.genesedev.microservices.ecommerce.dto;

import java.time.LocalDate;

public record VoucherDTO(
        Long number,
        LocalDate deliveryDate) {}
