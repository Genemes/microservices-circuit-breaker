package br.com.genesedev.microservices.shipping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long requestId;
    private LocalDate dateToSearch;
    private LocalDate forecastForDelivery;
    private String sourceAddress;
    private String destinationAddress;

    public Delivery(){}
    public Delivery(Long id, Long requestId, LocalDate dateToSearch, LocalDate forecastForDelivery, String sourceAddress, String destinationAddress) {
        this.id = id;
        this.requestId = requestId;
        this.dateToSearch = dateToSearch;
        this.forecastForDelivery = forecastForDelivery;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
    }
    public Delivery(Long requestId, LocalDate dateToSearch, LocalDate forecastForDelivery, String sourceAddress, String destinationAddress) {
        this.requestId = requestId;
        this.dateToSearch = dateToSearch;
        this.forecastForDelivery = forecastForDelivery;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
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

    public LocalDate getDateToSearch() {
        return dateToSearch;
    }

    public void setDateToSearch(LocalDate dateToSearch) {
        this.dateToSearch = dateToSearch;
    }

    public LocalDate getForecastForDelivery() {
        return forecastForDelivery;
    }

    public void setForecastForDelivery(LocalDate forecastForDelivery) {
        this.forecastForDelivery = forecastForDelivery;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) && Objects.equals(requestId, delivery.requestId) && Objects.equals(dateToSearch, delivery.dateToSearch) && Objects.equals(forecastForDelivery, delivery.forecastForDelivery) && Objects.equals(sourceAddress, delivery.sourceAddress) && Objects.equals(destinationAddress, delivery.destinationAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestId, dateToSearch, forecastForDelivery, sourceAddress, destinationAddress);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", dateToSearch=" + dateToSearch +
                ", forecastForDelivery=" + forecastForDelivery +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                '}';
    }
}
