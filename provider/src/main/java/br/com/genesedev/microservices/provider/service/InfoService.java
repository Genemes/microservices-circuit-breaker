package br.com.genesedev.microservices.provider.service;

import br.com.genesedev.microservices.provider.model.InfoProvider;
import br.com.genesedev.microservices.provider.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository repository;

    public InfoProvider getInfoPerState(String state){
        return repository.findByState(state);
    }
}
