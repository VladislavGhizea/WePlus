package com.weplus.app.entita;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ambito")
public class Ambito {

    @Id
    @ManyToMany //controllare con la key di indiceambiti
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_ambito;

    @OneToMany(mappedBy = "ambito")
    private List<IndiceAmbito> indiceAmbiti;

    @Column(nullable = false, length=25) // Campo obbligatorio
    private String nome;

    public Ambito() {
    }

    public Ambito(Integer id_ambito, String nome) {
        this.id_ambito = id_ambito;
        this.nome = nome;
    }

    public Ambito(Integer id_ambito, List<IndiceAmbito> indiceAmbiti, String nome) {
        this.id_ambito = id_ambito;
        this.indiceAmbiti = indiceAmbiti;
        this.nome = nome;
    }

    public Ambito(String nome) {
        this.nome = nome;
    }

    public List<IndiceAmbito> getIndiceAmbiti() {
        return indiceAmbiti;
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
