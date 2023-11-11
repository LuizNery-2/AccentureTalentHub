package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Table(name = "TB_SALAS")
public class SalaModel implements Serializable {
    private static final long serialVersionUID = 6l;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdSala;

    @ManyToMany(mappedBy = "salas")
    @JsonIgnoreProperties("salas")
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

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataTermino;

    @Lob
    private byte[] banner;


    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }

    public UUID getIdSala() {
        return IdSala;
    }

    public void setIdSala(UUID idSala) {
        IdSala = idSala;
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

    public Set<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(Set<CursoModel> cursos) {
        this.cursos = cursos;
    }

    public Set<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }
}

