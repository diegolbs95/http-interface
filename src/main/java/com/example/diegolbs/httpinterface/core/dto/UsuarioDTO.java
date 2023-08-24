package com.example.diegolbs.httpinterface.core.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class UsuarioDTO extends RepresentationModel<UsuarioDTO> implements Serializable {

    private Long id;
    private String nome;
    private String email;

}
