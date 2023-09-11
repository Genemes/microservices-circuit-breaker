package br.com.genesedev.microservices.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long requestId;
    private LocalDate preparationTime;
    private String destinationAddress;
    private LocalDate deliveryDate;
    private Long voucher;
    @Enumerated(EnumType.STRING)
    private PurchaseStateEnum state;

    public Purchase(){}
    public Purchase(Long id, Long requestId, LocalDate preparationTime, String destinationAddress, LocalDate deliveryDate, Long voucher, PurchaseStateEnum state) {
        this.id = id;
        this.requestId = requestId;
        this.preparationTime = preparationTime;
        this.destinationAddress = destinationAddress;
        this.deliveryDate = deliveryDate;
        this.voucher = voucher;
        this.state = state;
    }
    public Purchase(Long requestId, LocalDate preparationTime, String destinationAddress, LocalDate deliveryDate, Long voucher, PurchaseStateEnum state) {
        this.requestId = requestId;
        this.preparationTime = preparationTime;
        this.destinationAddress = destinationAddress;
        this.deliveryDate = deliveryDate;
        this.voucher = voucher;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public LocalDate getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(LocalDate preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getVoucher() {
        return voucher;
    }

    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

    public PurchaseStateEnum getState() {
        return state;
    }

    public void setState(PurchaseStateEnum state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id) && Objects.equals(requestId, purchase.requestId) && Objects.equals(preparationTime, purchase.preparationTime) && Objects.equals(destinationAddress, purchase.destinationAddress) && Objects.equals(deliveryDate, purchase.deliveryDate) && Objects.equals(voucher, purchase.voucher) && state == purchase.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestId, preparationTime, destinationAddress, deliveryDate, voucher, state);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", preparationTime=" + preparationTime +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", voucher=" + voucher +
                ", state=" + state +
                '}';
    }
}
