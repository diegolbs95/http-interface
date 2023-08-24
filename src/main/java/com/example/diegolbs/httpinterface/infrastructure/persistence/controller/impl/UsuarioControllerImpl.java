package com.example.diegolbs.httpinterface.infrastructure.persistence.controller.impl;

import com.example.diegolbs.httpinterface.core.dto.UsuarioDTO;
import com.example.diegolbs.httpinterface.core.usecase.UsuarioUseCase;
import com.example.diegolbs.httpinterface.infrastructure.persistence.controller.UsuarioController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<UsuarioDTO>> findAllUsuarios(Pageable pageable) {
        var usuarioDTOList = usuarioUseCase.findAllUsuarios(pageable);
        usuarioDTOList.forEach(x ->
                x.add(linkTo(methodOn(UsuarioControllerImpl.class).getUsuarioId(x.getId())).withSelfRel()));

        return ResponseEntity.ok(usuarioDTOList);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioId(@PathVariable Long id) {
        var usuarioDto = usuarioUseCase.getUsuarioId(id);
        usuarioDto.add(linkTo(methodOn(UsuarioControllerImpl.class)
                .findAllUsuarios(null)).withRel("findAllUsuarios"));
        return ResponseEntity.ok(usuarioDto);
    }

    @Override
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioUseCase.registrarUsuario(usuario));
    }
}
