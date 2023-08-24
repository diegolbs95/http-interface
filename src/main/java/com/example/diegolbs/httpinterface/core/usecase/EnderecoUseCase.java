package com.example.diegolbs.httpinterface.core.usecase;

import com.example.diegolbs.httpinterface.core.dto.EnderecoDTO;

public interface EnderecoUseCase {

    EnderecoDTO getByEndereco(String cep);
}
