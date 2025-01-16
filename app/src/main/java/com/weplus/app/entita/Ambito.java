package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "Ambito")
public class Ambito {

    @Id
    @ManyToMany //controllare con la key di indiceambiti
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_ambito;

    @Column(nullable = false) // Campo obbligatorio
    private String nome;

    public Ambito() {
    }

    public Ambito(Integer id_ambito, String nome) {
        this.id_ambito = id_ambito;
        this.nome = nome;
    }

    public Integer getId_ambito() {
        return id_ambito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
