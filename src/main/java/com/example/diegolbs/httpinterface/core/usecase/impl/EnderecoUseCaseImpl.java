package com.example.diegolbs.httpinterface.core.usecase.impl;

import com.example.diegolbs.httpinterface.core.dto.EnderecoDTO;
import com.example.diegolbs.httpinterface.core.usecase.EnderecoUseCase;
import com.example.diegolbs.httpinterface.infrastructure.persistence.config.ConfigEnderecoClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnderecoUseCaseImpl implements EnderecoUseCase {

    private final ConfigEnderecoClient enderecoClient;

    @Override
//    @Cacheable("enderecos")
    public EnderecoDTO getByEndereco(String cep) {
        log.info("Buscando enderoco na API");
        return enderecoClient.get(cep);
    }
}
