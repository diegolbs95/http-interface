package com.example.diegolbs.httpinterface.infrastructure.persistence.repository;

import com.example.diegolbs.httpinterface.infrastructure.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {
}
