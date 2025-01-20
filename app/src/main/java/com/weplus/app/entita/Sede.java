package com.weplus.app.entita;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_sede;

    @OneToMany(mappedBy = "sede")
    private List<PersonaGiuridica> personaGiuridica;

    @OneToMany(mappedBy = "sede") // Corretto il nome del campo
    private List<EntitaIndividuale> entitaIndividuale;

    @Column(nullable = false) // Campo obbligatorio
    private String indirizzo;

    @Column(nullable = false) // Campo obbligatorio
    private boolean principale = false;

    public Sede() {}


    public Sede(boolean principale, String indirizzo) {
        this.principale = principale;
        this.indirizzo = indirizzo;
    }

    public List<PersonaGiuridica> getPersonaGiuridica() {
        return personaGiuridica;
    }

    public List<EntitaIndividuale> getEntitaIndividuale() {
        return entitaIndividuale;
    }

    public Integer getId_sede() {
        return id_sede;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }
}
