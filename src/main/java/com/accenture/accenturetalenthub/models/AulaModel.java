package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.ArrayList;
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

    @ManyToMany(mappedBy = "aulas")
    @JsonIgnoreProperties("aulas")
    private ArrayList<ModuloModel> modulos;
    private String nomeAula;

    private String linkAula;


    //Get and Setters

    public UUID getIdModulo() {
        return IdAula;
    }

    public void setIdModulo(UUID idModulo) {
        IdAula = idModulo;
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

    public ArrayList<ModuloModel> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<ModuloModel> modulos) {
        this.modulos = modulos;
    }
}
