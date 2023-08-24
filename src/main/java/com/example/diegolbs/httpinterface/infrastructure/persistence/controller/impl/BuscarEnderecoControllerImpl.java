package com.example.diegolbs.httpinterface.infrastructure.persistence.controller.impl;

import com.example.diegolbs.httpinterface.core.dto.EnderecoDTO;
import com.example.diegolbs.httpinterface.core.usecase.EnderecoUseCase;
import com.example.diegolbs.httpinterface.infrastructure.persistence.controller.BuscarEnderecoController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class BuscarEnderecoControllerImpl implements BuscarEnderecoController {

    private final EnderecoUseCase enderecoUseCase;

    @Override
    @GetMapping
    public EnderecoDTO getEndereco(@RequestHeader String cep) {
        return enderecoUseCase.getByEndereco(cep);
    }
}
