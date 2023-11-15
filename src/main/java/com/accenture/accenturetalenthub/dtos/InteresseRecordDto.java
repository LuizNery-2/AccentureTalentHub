package com.accenture.accenturetalenthub.dtos;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;

import java.util.Set;

public record InteresseRecordDto(String nome, String categoria, int pontuacaoInteresse, Set<CursoModel> cursos, Set<UsuarioModel> usuarios) {
}
