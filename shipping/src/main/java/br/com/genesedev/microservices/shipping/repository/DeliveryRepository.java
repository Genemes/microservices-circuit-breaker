package br.com.genesedev.microservices.shipping.repository;

import br.com.genesedev.microservices.shipping.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
