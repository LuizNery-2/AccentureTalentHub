package com.accenture.accenturetalenthub.models;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private static final long serialVersionUID = 7l;
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID IdUsuario;
    private String senha;
    private String usuario;
    private String nome; 
    private String cargo;
    // A representação de 'foto' depende do seu aplicativo; pode ser uma URL ou um Blob.
    private String foto;
    private String email;
   

    private int pontuacaoGeral;
    private int nivel;
    private int nivelInteresse;
    private int nivelUsuario;
   

    @ManyToMany
    @JoinTable(
            name = "TB_USUARIO_CURSO",
            joinColumns =   @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "Curso_Id")
    )
    @JsonIgnoreProperties("usuarios")
    private Set<CursoModel> cursos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "TB_USUARIO_INTERESSES",
            joinColumns =   @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "Interesse_Id")
    )
    @JsonIgnoreProperties("usuarios")
    private Set<InteresseModel> interesses = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "TB_USUARIOS_SALAS",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "salas_id")
    )
    @JsonIgnoreProperties("usuarios")
    private  Set<SalaModel> salas = new HashSet<>();
    // getters e setters
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public int getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(int nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }
    
    public Set<InteresseModel> getInteresses() {
        return interesses;
    }

    public void setInteresses(Set<InteresseModel> interesses) {
        this.interesses = interesses;
    }

    public Set<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(Set<CursoModel> cursos) {
        this.cursos = cursos;
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

    public Set<SalaModel> getSalas() {
        return salas;
    }

    public void setSalas(Set<SalaModel> salas) {
        this.salas = salas;
    }
}
