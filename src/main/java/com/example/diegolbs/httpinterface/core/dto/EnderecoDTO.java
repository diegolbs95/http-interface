package com.example.diegolbs.httpinterface.core.dto;

import java.io.Serializable;

public record EnderecoDTO (
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String ddd)  implements Serializable {
}
