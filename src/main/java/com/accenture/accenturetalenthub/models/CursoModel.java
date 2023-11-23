package com.accenture.accenturetalenthub.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "TB_CURSOS")
public class CursoModel implements Serializable {
    private static final long serialVersionUID = 2l;

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdCurso;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String imagem;
    private String descricao;
    private Boolean concluido = false;
    private int quantidadeHoras;
    private int pontuacaoGeral;
    @ManyToMany
    @JoinTable(
            name = "TB_CURSOS_INTERESSES",
            joinColumns =   @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "Interesse_Id")
    )
    @JsonIgnoreProperties({"cursos","usuarios"})
    private Set<InteresseModel> interesses =new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("curso")
    private Set<ModuloModel> modulos = new HashSet<>();

    @ManyToMany(mappedBy = "cursos")
    private List<UsuarioModel> usuarios = new ArrayList<>();
    @ManyToMany(mappedBy = "cursos")
    private Set<SalaModel> salas = new HashSet<>();

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<SalaModel> getSalas() {
        return salas;
    }

    public void setSalas(Set<SalaModel> salas) {
        this.salas = salas;
    }

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

    public int getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(int quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
     public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Set<ModuloModel> getModulos() {
        return modulos;
    }

    public void setModulos(Set<ModuloModel> modulos) {
        this.modulos = modulos;
    }

    public Object getId() {
        return null;
    }
}
