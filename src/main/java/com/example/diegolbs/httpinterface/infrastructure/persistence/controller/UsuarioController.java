package com.example.diegolbs.httpinterface.infrastructure.persistence.controller;

import com.example.diegolbs.httpinterface.core.dto.UsuarioDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioController {

    ResponseEntity<List<UsuarioDTO>> findAllUsuarios(Pageable pageable);

    ResponseEntity<UsuarioDTO> registrarUsuario(UsuarioDTO usuario);

    ResponseEntity<UsuarioDTO> getUsuarioId(Long id);
}
