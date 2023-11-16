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
@Table(name = "TB_COMENTARIOFORUM")
public class ComentarioForum implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdComentarioForum;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private ForumModel forumModel;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuarioModel;
    
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public UUID getIdComentarioForum() {
        return IdComentarioForum;
    }
    public void setIdComentarioForum(UUID idComentarioForum) {
        IdComentarioForum = idComentarioForum;
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
