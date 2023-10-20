package com.accenture.accenturetalenthub.dtos;

import com.accenture.accenturetalenthub.models.InteresseModel;
import org.hibernate.mapping.Set;

import java.util.ArrayList;
import java.util.List;

public record CursoRecordDto(String nome, String descricao, int pontuacaoGeral, List<InteresseModel> interesses) {
}