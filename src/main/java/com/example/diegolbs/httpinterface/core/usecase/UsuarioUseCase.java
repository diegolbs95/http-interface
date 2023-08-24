package com.example.diegolbs.httpinterface.core.usecase;

import com.example.diegolbs.httpinterface.core.dto.UsuarioDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioUseCase {

    List<UsuarioDTO> findAllUsuarios(Pageable pageable);

    UsuarioDTO registrarUsuario(UsuarioDTO usuario);

    UsuarioDTO getUsuarioId (Long id);
}
