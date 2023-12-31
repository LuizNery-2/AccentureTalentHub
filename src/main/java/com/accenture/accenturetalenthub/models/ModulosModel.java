package com.accenture.accenturetalenthub.models;

import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Table(name = "TB_MODULOS")
public class ModulosModel implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdModulo;

    private String nomeModulo;


    @ManyToMany
    @JoinTable(
            name = "TB_MODULOS_AULAS",
            joinColumns =   @JoinColumn(name = "modulo_id"),
            inverseJoinColumns = @JoinColumn(name = "Aula_Id")
    )
    private ArrayList<AulasModel> aulas;


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

    public ArrayList<AulasModel> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<AulasModel> aulas) {
        this.aulas = aulas;
    }
}
