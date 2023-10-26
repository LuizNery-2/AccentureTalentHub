package com.accenture.accenturetalenthub.dtos;

import java.util.ArrayList;
import java.util.UUID;

import com.accenture.accenturetalenthub.models.AulasModel;

public record ModulosRecordDto(UUID IdModulo, String nomeModulo, ArrayList<AulasModel> aulas) {
    
}
