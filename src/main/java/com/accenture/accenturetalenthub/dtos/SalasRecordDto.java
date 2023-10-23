package com.accenture.accenturetalenthub.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record SalasRecordDto (UUID IdSala, String nome, String descricao, LocalDateTime dataCriacao, 
                              LocalDateTime dataTermino, byte[] banner){
    
}
