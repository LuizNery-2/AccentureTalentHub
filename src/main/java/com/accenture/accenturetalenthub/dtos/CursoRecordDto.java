package com.accenture.accenturetalenthub.dtos;

import com.accenture.accenturetalenthub.models.InteresseModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

public record CursoRecordDto(@NotBlank String nome, @NotBlank String descricao, @NotNull int pontuacaoGeral, int quantidadeHoras, Set<InteresseModel> interesses) {
}
