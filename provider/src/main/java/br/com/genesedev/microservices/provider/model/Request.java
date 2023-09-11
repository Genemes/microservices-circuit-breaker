package br.com.genesedev.microservices.provider.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int preparationTime;
    @Enumerated(EnumType.STRING)
    private StatusRequest status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestId")
    private List<ItemRequest> items;

    public Request(List<ItemRequest> items) {
        this.items = items;
        this.status = StatusRequest.RECEIVED;
    }

    public Request() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public StatusRequest getStatus() {
        return status;
    }

    public void setStatus(StatusRequest status) {
        this.status = status;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return preparationTime == request.preparationTime && Objects.equals(id, request.id) && status == request.status && Objects.equals(items, request.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preparationTime, status, items);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", preparationTime=" + preparationTime +
                ", status=" + status +
                ", items=" + items +
                '}';
    }
}
