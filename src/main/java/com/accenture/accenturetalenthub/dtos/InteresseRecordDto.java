package com.accenture.accenturetalenthub.dtos;

import com.accenture.accenturetalenthub.models.CursoModel;

import java.util.List;
import java.util.Set;

public record InteresseRecordDto(String nome, String categoria, int pontuacaoInteresse, Set<CursoModel> cursos) {
}
