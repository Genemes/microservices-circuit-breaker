package br.com.genesedev.microservices.ecommerce.repository;

import br.com.genesedev.microservices.ecommerce.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
