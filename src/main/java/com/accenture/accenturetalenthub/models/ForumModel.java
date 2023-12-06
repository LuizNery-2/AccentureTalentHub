package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "TB_FORUM")
public class ForumModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdForum;

    @OneToMany(mappedBy = "forumModel", cascade = CascadeType.ALL)
    private List<ComentarioForum> comentarioForum = new ArrayList<>();

    @OneToMany(mappedBy = "forumModel", cascade = CascadeType.ALL)
    private List<ComentarioRespostaForum> comentarioResposta = new ArrayList<>();

    public UUID getIdForum() {
        return IdForum;
    }

    public void setIdForum(UUID idForum) {
        IdForum = idForum;
    }


}
