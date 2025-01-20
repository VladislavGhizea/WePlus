package com.weplus.app.entita;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ambito")
public class Ambito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_ambito;

    @OneToMany(mappedBy = "ambito")
    private List<IndiceAmbito> indiceAmbiti;

    @Column(nullable = false, length=25) // Campo obbligatorio
    private String nome;

    public Ambito() {
    }

    public Ambito( List<IndiceAmbito> indiceAmbiti, String nome) {
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
