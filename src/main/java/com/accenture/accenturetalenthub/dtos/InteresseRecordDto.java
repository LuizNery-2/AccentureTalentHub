package com.accenture.accenturetalenthub.dtos;

import com.accenture.accenturetalenthub.models.CursoModel;

import java.util.List;

public record InteresseRecordDto(String nome, String categoria, int pontuacaoInteresse, List<CursoModel> cursos) {
}
