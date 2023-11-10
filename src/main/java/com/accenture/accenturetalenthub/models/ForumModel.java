package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "TB_FORUM")
public class ForumModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdForum;
    private String mensagem;
    
    public UUID getIdForum() {
        return IdForum;
    }


    public void setIdForum(UUID idForum) {
        IdForum = idForum;
    }


    public String getMensagem() {
        return mensagem;
    }


    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
