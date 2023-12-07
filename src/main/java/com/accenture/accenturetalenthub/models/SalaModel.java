package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Table(name = "TB_SALAS")
public class SalaModel implements Serializable {
    private static final long serialVersionUID = 6l;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdSala;

    @ManyToMany(mappedBy = "salas")
    private Set<UsuarioModel> usuarios = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "TB_SALA_CURSO",
            joinColumns =   @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "Curso_Id")
    )
    @JsonIgnoreProperties("salas")
    private Set<CursoModel> cursos =new HashSet<>();

    private String nome;
    private String descricao;

    
    private Date dataCriacao;

    
    private Date dataTermino;

    @Column(columnDefinition = "Text")
    private String banner;


    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public UUID getIdSala() {
        return IdSala;
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

    public Set<CursoModel> getCurso() {
        return cursos;
    }

    public void setCurso(Set<CursoModel> curso) {
        this.cursos = curso;
    }

    public Set<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(Set<CursoModel> cursos) {
        this.cursos = cursos;
    }
}

