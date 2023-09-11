package br.com.genesedev.microservices.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public record PurchaseDTO(
        @JsonIgnore Long purchaseId,
        List<PurchaseItemDTO> items,
        AddressDTO address) {
}
