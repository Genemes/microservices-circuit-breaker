package br.com.genesedev.microservices.provider.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class InfoProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String state;
    private String address;

    public InfoProvider() {}

    public InfoProvider(Long id, String name, String state, String address) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.address = address;
    }
    public InfoProvider(String name, String state, String address) {
        this.name = name;
        this.state = state;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoProvider that = (InfoProvider) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(state, that.state) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, address);
    }

    @Override
    public String toString() {
        return "InfoProvider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
