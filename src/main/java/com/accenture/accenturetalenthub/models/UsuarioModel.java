package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Table(name = "TB_USUARIOS")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdUsuario;

    @ElementCollection
    @ManyToMany
    @JoinTable(
            name = "TB_USUARIO_CURSO",
            joinColumns =   @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "Curso_Id")
    )
    private List<CursoModel> cursosConcluidos = new ArrayList<>();
    
    @ElementCollection
    @ManyToMany
    @JoinTable(
            name = "TB_USUARIO_INTERESSES",
            joinColumns =   @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "Interesse_Id")
    )
    private List<InteresseModel> interesses = new ArrayList<>();
    

    
    private String senha;
    private String usuario;
    private String nome; 
    private String cargo;
    // A representação de 'foto' depende do seu aplicativo; pode ser uma URL ou um Blob.
    private String foto;
    private int pontuacaoGeral;
    private int nivel;
    private int nivelInteresse;
    
    // getters e setters
    public List<InteresseModel> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<InteresseModel> interesses) {
        this.interesses = interesses;
    }

    public List<CursoModel> getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(List<CursoModel> cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public UUID getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        IdUsuario = idUsuario;
    }


     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(int pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivelInteresse() {
        return nivelInteresse;
    }

    public void setNivelInteresse(int nivelInteresse) {
        this.nivelInteresse = nivelInteresse;
    }
    
}
