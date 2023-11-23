package com.accenture.accenturetalenthub.models;



import java.util.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Table(name = "TB_MODULOS")
public class ModuloModel implements Serializable{
    private static final long serialVersionUID = 5l;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdModulo;

    private String nomeModulo;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("modulos")
    private Set<AulaModel> aulas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("modulos")
    private CursoModel curso;


    //Get and Setters

    public UUID getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(UUID idModulo) {
        IdModulo = idModulo;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModuo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public Set<AulaModel> getAulas() {
        return aulas;
    }

    public void setAulas(Set<AulaModel> aulas) {
        this.aulas = aulas;
    }


    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }


}
