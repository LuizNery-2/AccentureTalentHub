package com.accenture.accenturetalenthub.dtos;

import java.util.ArrayList;
import java.util.UUID;

import com.accenture.accenturetalenthub.models.AulaModel;

public record ModuloRecordDto(UUID IdModulo, String nomeModulo, ArrayList<AulaModel> aulas) {
    
}
