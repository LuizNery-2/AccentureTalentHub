package com.accenture.accenturetalenthub.dtos;

import java.util.UUID;

public record ComentarioForumDto(UUID idUsuario, UUID idForum, String mensagem) {
    public UUID getIdForum() {
        return idForum;
    }
    
    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getMensagem() {
        return mensagem;
    }
}



