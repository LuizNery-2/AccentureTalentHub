package com.accenture.accenturetalenthub.models;

import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_COMENTARIORESPOSTA")
public class ComentarioRespostaForum implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID idComentarioResposta;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private ForumModel forumModel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuarioModel;

    private String mensagemResposta;

    public String getMensagemResposta() {
        return mensagemResposta;
    }

    public void setMensagemResposta(String mensagemResposta) {
        this.mensagemResposta = mensagemResposta;
    }

    public UUID getIdComentarioResposta() {
        return idComentarioResposta;
    }

    public void setIdComentarioResposta(UUID idComentarioResposta) {
        this.idComentarioResposta = idComentarioResposta;
    }

    public ForumModel getForumModel() {
        return forumModel;
    }

    public void setForumModel(ForumModel forumModel) {
        this.forumModel = forumModel;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
    
}
