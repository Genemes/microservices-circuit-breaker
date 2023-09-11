package br.com.genesedev.microservices.provider.controller;

import br.com.genesedev.microservices.provider.model.InfoProvider;
import br.com.genesedev.microservices.provider.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService service;

    public InfoProvider getInfoPerState(@PathVariable String state){
        return service.getInfoPerState(state);
    }
}
