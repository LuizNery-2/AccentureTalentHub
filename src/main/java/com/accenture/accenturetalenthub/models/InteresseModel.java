package com.accenture.accenturetalenthub.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_INTERESSES")
public class InteresseModel implements Serializable {
    private static final long serialVersionUID = 4l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long IdInteresse;
    private String nome;
    private String categoria;
    private int pontuacaoInteresse;
    @ManyToMany(mappedBy = "interesses")
    @JsonIgnoreProperties("interesses")
    private Set<CursoModel> cursos = new HashSet<>();

    @ManyToMany(mappedBy = "interesses")
    private Set<UsuarioModel> usuarios = new HashSet<>();

    public long getIdInteresse() {
        return IdInteresse;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPontuacaoInteresse() {
        return pontuacaoInteresse;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPontuacaoInteresse(int pontuacaoInteresse) {
        this.pontuacaoInteresse = pontuacaoInteresse;
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

    public void setUsuarios(Set<UsuarioModel> usuario) {
        this.usuarios = usuario;
    }
}
