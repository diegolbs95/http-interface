package com.example.diegolbs.httpinterface.infrastructure.persistence.controller;

import com.example.diegolbs.httpinterface.core.dto.EnderecoDTO;

public interface BuscarEnderecoController {

    EnderecoDTO getEndereco (String cep);
}
