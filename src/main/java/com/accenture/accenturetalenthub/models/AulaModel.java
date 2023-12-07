package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Table(name = "TB_AULAS")
public class AulaModel implements Serializable{
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdAula;


    @ManyToOne
    @JsonIgnoreProperties("aulas")
    private ModuloModel modulo;

    private String nomeAula;

    private String linkAula;


    //Get and Setters


    public UUID getIdAula() {
        return IdAula;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public String getLinkAula() {
        return linkAula;
    }

    public void setLinkAula(String linkAula) {
        this.linkAula = linkAula;
    }


    public ModuloModel getModulo() {
        return modulo;
    }

    public void setModulo(ModuloModel modulo) {
        this.modulo = modulo;
    }

}
