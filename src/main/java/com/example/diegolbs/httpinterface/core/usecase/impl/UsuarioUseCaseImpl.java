package com.example.diegolbs.httpinterface.core.usecase.impl;

import com.example.diegolbs.httpinterface.core.dto.UsuarioDTO;
import com.example.diegolbs.httpinterface.core.usecase.UsuarioUseCase;
import com.example.diegolbs.httpinterface.infrastructure.persistence.entity.Usuario;
import com.example.diegolbs.httpinterface.infrastructure.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<UsuarioDTO> findAllUsuarios(Pageable pageable) {
        var listUsuarioDtos = new ArrayList<UsuarioDTO>();
        var pages =  repository.findAll(pageable);

        pages.getContent().forEach(x -> listUsuarioDtos.add(modelMapper.map(x, UsuarioDTO.class)));
        return listUsuarioDtos;
    }

    @Override
    public UsuarioDTO getUsuarioId (Long id) {
        var usaurio = repository.findById(id).orElseThrow(()
                -> new RuntimeException("Usuario não encontrado com id solicitado"));
        return modelMapper.map(usaurio, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        var usuario = repository.save(modelMapper.map(usuarioDTO, Usuario.class));
        usuarioDTO.setId(usuario.getId());
        return usuarioDTO;
    }
}
