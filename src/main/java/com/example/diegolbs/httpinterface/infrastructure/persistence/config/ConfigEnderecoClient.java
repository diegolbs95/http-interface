package com.example.diegolbs.httpinterface.infrastructure.persistence.config;

import com.example.diegolbs.httpinterface.core.dto.EnderecoDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ConfigEnderecoClient {

    @GetExchange("/{cep}/json/")
    EnderecoDTO get(@PathVariable String cep);
}
