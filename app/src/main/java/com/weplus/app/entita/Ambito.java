package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ambito")
public class Ambito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_ambito;

    @ManyToMany(mappedBy = "ambiti")
    @JsonIgnore
    private List<UtenteGenerale> soggetti;

    @Column(nullable = false, length=25) // Campo obbligatorio
    private String nome;

    public Ambito() {
    }

    public Ambito(String nome) {
        this.nome = nome;
    }

    public List<UtenteGenerale> getSoggetti() {
        return soggetti;
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
