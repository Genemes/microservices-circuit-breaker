package br.com.genesedev.microservices.provider.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ItemRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quatity;

    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Product product;

    public ItemRequest(){}
    public ItemRequest(Long id, int quatity, Product product) {
        this.id = id;
        this.quatity = quatity;
        this.product = product;
    }

    public ItemRequest(int quatity, Product product) {
        this.quatity = quatity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRequest that = (ItemRequest) o;
        return quatity == that.quatity && Objects.equals(id, that.id) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quatity, product);
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "id=" + id +
                ", quatity=" + quatity +
                ", product=" + product +
                '}';
    }
}
