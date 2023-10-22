package com.accenture.accenturetalenthub.dtos;

import java.util.Date;
import java.util.UUID;

public record SalasRecordDto (UUID IdSala, String nome, String descricao, Date dataCriacao, Date dataTermino, byte[] banner){
    
}
