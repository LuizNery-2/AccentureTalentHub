package com.accenture.accenturetalenthub.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;


public record SalaRecordDto(UUID IdSala, String nome, String descricao, Date dataCriacao,
                            Date dataTermino, String banner, Set<UsuarioModel> usuarios,
                            Set<CursoModel> cursos){

   
    
}
