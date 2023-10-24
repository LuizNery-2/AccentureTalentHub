package com.accenture.accenturetalenthub.models;

import jakarta.persistence.*;
import org.hibernate.mapping.Array;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "TB_CURSOS")
public class CursoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdCurso;
    private String nome;
    private String descricao;
    private Boolean concluido;
    private int pontuacaoGeral;
    @ManyToMany
    @JoinTable(
            name = "TB_CURSOS_INTERESSES",
            joinColumns =   @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "Interesse_Id")
    )
    private Set<InteresseModel> interesses =new HashSet<>();

    public UUID getIdCurso() {
        return IdCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public int getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(int pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }

    public Set<InteresseModel> getInteresses() {
        return interesses;
    }

    public void setInteresses(Set<InteresseModel> interesses) {
        this.interesses = interesses;
    }
}
