package com.accenture.accenturetalenthub.repositories;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.accenturetalenthub.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
    Optional<UsuarioModel> findById(UUID IdUsuario);

    Optional<UsuarioModel> findByUsuarioAndSenha(String nomeUsuario, String senha);

}

