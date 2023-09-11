package br.com.genesedev.microservices.provider.repository;

import br.com.genesedev.microservices.provider.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
}
